# PhanesEditor Backend Project
![header](https://capsule-render.vercel.app/api?type=waving&color=0:8EC5FC,100:E0C3FC&height=200&section=header&text=Phanes%20Editor&fontSize=60&fontColor=ffffff&animation=fadeIn&fontAlignY=35&desc=Real-time%20Collaboration%20on%20Code&descAlignY=60&descAlign=50)

## 한 줄 요약

프로젝트 단위 협업을 지원하는 **웹 기반 코드 에디터 백엔드**로, 프로젝트·멤버·파일을 중심으로 **WebSocket 기반 실시간 채팅 및 코드 동기화 기능**을 구현했습니다.

---

## 프로젝트 개요
PhanesEditor는 여러 사용자가 하나의 프로젝트에 참여하여
파일을 수정하고, 실시간으로 소통할 수 있는 협업형 웹 에디터입니다.

본 프로젝트에서 저는 **실시간 통신과 프로젝트 단위 접근 제어**를 중심으로 백엔드 핵심 기능을 담당했습니다.

---

## 담당 역할
* **채팅(Chat)**
* **프로젝트(Project)**
* **프로젝트 멤버(Project Member)**
* **파일(File)**
* **WebSocket 기반 실시간 통신**

---

## 주요 기능 및 구현 내용

### WebSocket 기반 채팅

* WebSocket을 이용한 실시간 채팅 기능 구현
* 동일 프로젝트에 참여한 멤버 간에만 메시지 송수신 가능하도록 제한
* 프로젝트 단위 채널 구조 설계

### 실시간 코드 수정 및 저장

* 프로젝트에 속한 파일을 WebSocket을 통해 실시간 수정
* 파일 변경 사항을 서버에서 수신 후 저장 처리
* 프로젝트 멤버가 아닌 사용자의 접근 차단

### 프로젝트 및 멤버 관리

* 프로젝트 생성 및 조회 기능 구현
* 프로젝트 멤버 관리 기능 설계
* 프로젝트 멤버 여부를 기준으로
    * 채팅 참여
    * 파일 열기 및 수정 권한 제어

---

## 설계 포인트

### 프로젝트 단위 접근 제어

* 모든 실시간 기능은 **프로젝트 멤버 여부**를 기준으로 동작
* WebSocket 연결 시 프로젝트 ID와 사용자 정보를 검증하여
  비인가 사용자의 실시간 접근 차단
* 채팅 코드수정 등 WebSocket 기능 사용시 프로젝트 맴버 여부를 검증하여 동작

### WebSocket 활용 구조

* HTTP 기반 CRUD와 WebSocket 기반 실시간 통신을 분리
* 채팅과 코드 수정 이벤트를 WebSocket 메시지 타입으로 구분하여 처리

---

## 기술 스택

### Backend

* Java
* Spring Boot
* Spring WebSocket
* Spring Data JPA

### Database

* mariadb (프로젝트 / 멤버 / 파일 관리)

---

## API 및 통신 구조

* REST API: 프로젝트, 멤버, 파일 관리
* WebSocket: 채팅 메시지 및 코드 변경 이벤트 처리

---

## 정리

* 프로젝트 단위 협업 구조 설계 경험
* WebSocket을 활용한 실시간 기능 구현 경험
* 접근 제어를 고려한 실시간 통신 처리

### 🏗️ 시스템 아키텍처
![시스템 아키텍처](./assets/architecture/system-architecture.png)

### 🧩 소프트웨어 아키텍처
![소프트웨어 아키텍처](./assets/architecture/software-architecture.png)

---




