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
- 회원가입
- 이메일 인증 기능
- 로그인 기능
- 프로필 조회
- 프로젝트 생성
- 프로젝트 검색
- 실시간 코드 동시 편집 (Monaco Editor + STOMP)
- 프로젝트별 실시간 채팅
- 로그아웃

## ✅ 기능 테스트

각 주요 기능은 Swagger를 통해 직접 호출하여 검증하였습니다.  
테스트 결과는 요청/응답 화면 캡처 및 실제 동작으로 정리하였습니다.  


### - 회원가입 API (`POST /user/signup`)

<details>
  <summary>👉 클릭해서 테스트 결과 보기</summary>
<h5>요청</h5>
<img src="./assets/test/회원가입요청.png" width="70%" alt="회원가입 요청 화면">
<h5>응답</h5>
<img src="./assets/test/회원가입응답.png" width="70%" alt="회원가입 응답 화면">
</details>

### -  이메일인증 API (`POST /user/verify`)

<details>
  <summary>👉 클릭해서 테스트 결과 보기</summary>
<h5>요청</h5>
<img src="./assets/test/이메일인증요청.png" width="70%" alt="회원가입 요청 화면">
<h5>응답</h5>
<img src="./assets/test/이메일인증응답.png" width="70%" alt="회원가입 응답 화면">
<h5>실제요청화면</h5>
<img src="./assets/test/이메일인증.png" width="70%" alt="회원가입 응답 화면">
</details>

### -  로그인 API (`POST /user/login`)

<details>
  <summary>👉 클릭해서 테스트 결과 보기</summary>
<h5>요청</h5>
<img src="./assets/test/로그인요청.png" width="70%" alt="회원가입 요청 화면">
<h5>응답</h5>
<img src="./assets/test/로그인응답.png" width="70%" alt="회원가입 응답 화면">
</details>




### - 프로필 조회 API (`POST /user/usr_mypage`)

<details>
  <summary>👉 클릭해서 테스트 결과 보기</summary>
<h5>요청 (전달받은 토큰을 통해 로그인 한 유저의 정보 조회)</h5> 
<img src="./assets/test/프로필조회요청.png" width="70%" alt="회원가입 요청 화면">
<h5>응답</h5>
<img src="./assets/test/프로필조회응답.png" width="70%" alt="회원가입 응답 화면">
</details>

### - 프로젝트 생성 API (`POST /project/create`)

<details>
  <summary>👉 클릭해서 테스트 결과 보기</summary>
<h5>요청</h5> 
<img src="./assets/test/프로젝트생성요청.png" width="70%" alt="회원가입 요청 화면">
<h5>응답</h5>
<img src="./assets/test/프로젝트생성응답.png" width="70%" alt="회원가입 응답 화면">
</details>

### - 프로젝트 검색 API (`POST /project/search`)

<details>
  <summary>👉 클릭해서 테스트 결과 보기</summary>
<h5>요청</h5> 
<img src="./assets/test/프로젝트검색요청.png" width="70%" alt="회원가입 요청 화면">
<h5>응답</h5>
<img src="./assets/test/프로젝트검색응답.png" width="70%" alt="회원가입 응답 화면">
</details>

### - 파일저장 API (`POST /user/signup`)

<details>
  <summary>👉 클릭해서 테스트 결과 보기</summary>
<h5>요청</h5>
<img src="./assets/test/파일저장요청.png" width="70%" alt="회원가입 요청 화면">
<h5>응답</h5>
<img src="./assets/test/파일저장응답.png" width="70%" alt="회원가입 응답 화면">
</details>

---

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
