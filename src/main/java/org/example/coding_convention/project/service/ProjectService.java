package org.example.coding_convention.project.service;

import io.kubernetes.client.custom.IntOrString;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.*;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import lombok.RequiredArgsConstructor;
import org.example.coding_convention.project.model.Project;
import org.example.coding_convention.project.model.ProjectDto;
import org.example.coding_convention.project.repository.ProjectQueryRepository;
import org.example.coding_convention.project.repository.ProjectRepository;
import org.example.coding_convention.project_member.model.ProjectMember;
import org.example.coding_convention.project_member.model.ProjectMemberDto;
import org.example.coding_convention.project_member.repository.ProjectMemberRepository;
import org.example.coding_convention.user.model.User;
import org.example.coding_convention.user.model.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectQueryRepository projectQueryRepository;
    private final CoreV1Api apiClient;

    public ProjectDto.ProjectRun run(Integer idx, UserDto.AuthUser authUser) throws InterruptedException, ApiException, IOException {
        Optional<Project> result = projectRepository.findByProjectIdx(idx);
        if (result.isPresent()) {
            Project project = result.get();

            String uuid= UUID.randomUUID().toString();
            V1Pod pod =
                    new V1PodBuilder()
                            .withNewMetadata()
                            .withName(uuid+"-pod")
                            .addToLabels("app", uuid)  // ← Service selector와 매칭될 라벨
                            .endMetadata()
                            .withNewSpec()
                            .withOverhead(null)            // ✅ overhead 제거
                            .withRuntimeClassName(null)    // ✅ 기본 런타임 사용
                            .addNewContainer()
                            .withName("www")
                            .withImage("nginx")
                            .endContainer()
                            .endSpec()
                            .build();

            apiClient.createNamespacedPod("default", pod).execute();
            System.out.println("Created!");

            V1Service svc = new V1ServiceBuilder()
                    .withNewMetadata()
                    .withName(uuid+"-svc")
                    .withNamespace("default")
                    .endMetadata()
                    .withNewSpec()
                    .withType("LoadBalancer")
                    .withSelector(Map.of("app", uuid)) // ← 파드 라벨과 매칭
                    .addNewPort()
                    .withName("http")
                    .withPort(80)                             // Service 포트
                    .withTargetPort(new IntOrString(80))      // 파드의 컨테이너 포트
                    .withProtocol("TCP")
                    .endPort()
                    .endSpec()
                    .build();

            apiClient.createNamespacedService("default", svc).execute();

            String endpoint = null;
            for (int i = 0; i < 120; i++) { // 최대 10분(5초 x 120)
                V1Service got = apiClient.readNamespacedService(uuid+"-svc", "default").execute();
                var lb = got.getStatus() != null ? got.getStatus().getLoadBalancer() : null;
                var ingressList = lb != null ? lb.getIngress() : null;

                if (ingressList != null && !ingressList.isEmpty()) {
                    var ing = ingressList.get(0);
                    String host = (ing.getIp() != null && !ing.getIp().isBlank())
                            ? ing.getIp() : ing.getHostname();
                    if (host != null && !host.isBlank()) {
                        endpoint = "http://" + host + ":80";
                        System.out.println("External endpoint: " + endpoint);

                        break;
                    }

                }

                Thread.sleep(5000);
            }

            return ProjectDto.ProjectRun.from(endpoint, endpoint);

        }
        return null;
    }


    public Page<ProjectDto.ProjectSearchRes> search(String projectName, String email, String language, Pageable pageable) {

        Page<Project> result = projectQueryRepository.searchProjects(projectName, email, language, pageable);
        return result.map(ProjectDto.ProjectSearchRes::from);
        // result.stream().map(ProjectDto.ProjectSearchRes::from).toList();
    }

    public ProjectDto.ProjectRes save(ProjectDto.ProjectReq dto, UserDto.AuthUser authUser) {
        User userIdx = User.builder()
                .idx(authUser.getIdx())
                .build();

        String url = "test";
        Project project = projectRepository.save(dto.toEntity(url, userIdx));

        Project projectIdx = Project.builder()
                .idx(project.getIdx())
                .build();

        String status = "ADMIN";

        ProjectMemberDto.ProjectMemberReq memberDto = ProjectMemberDto.ProjectMemberReq.builder()
                .projectId(projectIdx.getIdx())
                .userId(userIdx.getIdx())
                .status(status)
                .build();
        projectMemberRepository.save(memberDto.toEntity());
        // 저장이 진짜 되었는지 검증하고 싶으면 엔티티 반환해주면 됨
        for (Integer memIdx : dto.getMemberIdx()) {
            ProjectMemberDto.ProjectMemberReq projectMembers = ProjectMemberDto.ProjectMemberReq.builder()
                    .projectId(projectIdx.getIdx())
                    .userId(memIdx)
                    .status("USER")
                    .build();
            projectMemberRepository.save(projectMembers.toEntity());
        }
        return ProjectDto.ProjectRes.from(project);
    }

    public ProjectDto.ProjectRead read(Integer idx, UserDto.AuthUser authUser) {
        Optional<Project> result = projectRepository.findByProjectIdx(idx);
        if (result.isPresent()) {
            Project project = result.get();
            if (authUser == null) {
                return ProjectDto.ProjectRead.from(project);
            }
            return ProjectDto.ProjectRead.from(project, authUser);
        }
        return null;
    }

    public List<ProjectDto.ProjectList> list(UserDto.AuthUser authUser) {
        Integer userId = authUser.getIdx();
        List<ProjectMember> result = projectMemberRepository.findByProjectList(userId);
        return result.stream().map(ProjectDto.ProjectList::from).toList();
    }
}
