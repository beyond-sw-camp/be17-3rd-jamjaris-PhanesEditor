<h1 align="center">Phanes Editor</h1>

![header](https://capsule-render.vercel.app/api?type=waving&color=0:8EC5FC,100:E0C3FC&height=200&section=header&text=Phanes%20Editor&fontSize=60&fontColor=ffffff&animation=fadeIn&fontAlignY=35&desc=Real-time%20Collaboration%20on%20Code&descAlignY=60&descAlign=50)

<h1>설치 없이 즐기는 실시간 코드 공유</h1>
<h3>팀워크 강화, Phanes Editor로 완성하세요</h3>

---

## 👨‍👩‍👧‍👦 팀원

<figure>
  <table>
    <tr>
      <td align="center">
        <img src="https://avatars.githubusercontent.com/u/583231?v=4" width="120" height="120" alt="이현식"><br>
        팀원: <a href="https://github.com/why48382">이현식</a>
      </td>
      <td align="center">
        <img src="https://avatars.githubusercontent.com/u/9919?s=200&v=4" width="120" height="120" alt="염준선"><br>
        팀원: <a href="https://github.com/junsun-yeam">염준선</a>
      </td>
    </tr>
  </table>
</figure>


---

<h3>🌐 프론트엔드 주소</h3> 
👉 <a href = "http://gomorebi.kro.kr">도메인 주소</a>


---

<br>
<h3 id="devtools">⚙️ 기술 스택</h3>

<!-- Database -->
<h4>📂 Database</h4>
<div>
  <img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white">
</div>

<!-- Infrastructure -->
<h4>☁️ Infrastructure (예정) </h4>
<div>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
  <img src="https://img.shields.io/badge/AWS%20S3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">
</div>

<!-- Backend -->
<h4>🚀 Backend</h4>
<div>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white">
  <img src="https://img.shields.io/badge/QueryDSL-0099CC?style=for-the-badge&logoColor=white">
  <img src="https://img.shields.io/badge/WebSocket-010101?style=for-the-badge&logo=socketdotio&logoColor=white">
  <img src="https://img.shields.io/badge/STOMP-006699?style=for-the-badge&logo=apachekafka&logoColor=white">
</div>

<!-- Frontend -->
<h4>💻 Frontend</h4>
<div>
  <img src="https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white">
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  <img src="https://img.shields.io/badge/Vue--Router-42B883?style=for-the-badge&logo=vue.js&logoColor=white">
  <img src="https://img.shields.io/badge/Monaco%20Editor-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white">
</div>

<!-- Tools -->
<h4>🛠️ Tools</h4>
<div>
  <img src="https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white">
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white">
</div>

<!-- Communication -->
<h4>💬 Communication</h4>
<div>
  <img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">
</div>


### 📖 API 명세서
👉 <a href = "http://localhost:8080/swagger-ui/index.html">API 명세서</a>

### 🚀 주요 기능
- JWT + OAuth2 로그인 (카카오)
- 프로필 조회
- 프로젝트 생성
- 프로젝트 일반검색 및 상세검색
- 프로젝트 참여
- 실시간 코드 동시 편집 (Monaco Editor + STOMP)
- 프로젝트별 실시간 채팅
- 로그아웃

### ✅ 기능 테스트
- 단위 테스트 (JUnit5)
- 통합 테스트 (SpringBootTest)
- 프론트와 연동된 E2E 테스트 (Cypress)

### ⚡ 성능 개선
- 프로젝트 `likesCount` 컬럼 반정규화 → 조회 성능 개선
- N+1 문제 해결 (fetch join, BatchSize)
- Redis 캐싱 도입 (세션/토큰, 최근 작업 캐시)

### 📏 코딩 컨벤션
- 네이밍 룰, 패키지 구조 규칙
- Controller → Service → Repository 3계층 구조
- DTO 분리 원칙

### 🏗️ 시스템 아키텍처
![시스템 아키텍처](./assets/architecture/system-architecture.png)

### 🧩 소프트웨어 아키텍처
![소프트웨어 아키텍처](./assets/architecture/software-architecture.png)

---
