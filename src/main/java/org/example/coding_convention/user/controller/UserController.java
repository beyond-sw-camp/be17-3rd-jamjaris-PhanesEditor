package org.example.coding_convention.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.coding_convention.common.model.BaseResponse;
import org.example.coding_convention.user.model.UserDto;
import org.example.coding_convention.user.service.UserService;
import org.example.coding_convention.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "유저관련기능")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "회원가입기능",
            description = "회원가입할 때 실행되는 기능"
    )
    @PostMapping("/signup")
    public BaseResponse signup(@RequestBody UserDto.Register dto) throws MessagingException {
        userService.signup(dto);

        return BaseResponse.success("이메일 인증요망");
    }
    @Operation(
            summary = "프로필 조회기능",
            description = "로그인 후 오른쪽 상단 profile에 대한 기능"
    )
    @GetMapping("/usr_mypage")
    public BaseResponse usrMypage(@AuthenticationPrincipal UserDto.AuthUser authUser) throws MessagingException {
        UserDto.Profile dto= userService.findProfile(authUser);

        return BaseResponse.success(dto);
    }

    @PostMapping("/usr_mypage/image")
    public BaseResponse uploadProfileImage(
            @RequestParam("profileImage") MultipartFile file,
            @AuthenticationPrincipal UserDto.AuthUser authUser) throws MessagingException {

           String imagePath = userService.updateImage(file, authUser);
        return BaseResponse.success(imagePath);
    }

    @Operation(
            summary = "이메일 인증기능",
            description = "이메일 인증시 실행되는 기능"
    )
    @GetMapping("/verify")
    public BaseResponse verify(String uuid) {
        userService.verify(uuid);

        return BaseResponse.success("이메일 인증완료");
    }

    @PostMapping("/logout")
    public BaseResponse logout(HttpServletResponse response) {
        JwtUtil.deleteToken(response);
        return BaseResponse.success("로그아웃 완료");

    }

}
