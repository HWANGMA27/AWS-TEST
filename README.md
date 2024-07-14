# AWS-TEST 프로젝트

## 개요
AWS-TEST는 AWS와 Docker를 테스트하기 위한 Spring Boot 프로젝트입니다. GitHub Actions를 통해 EC2에 배포하고, Spring Boot 애플리케이션을 Docker 컨테이너로 빌드 및 배포하는 예제를 포함합니다.

## 주요 기능
- **Spring Boot 프로젝트**: RESTful API 예제 포함
- **RabbitMQ 연동**: 비동기 처리 예제
- **Docker**: Dockerfile 및 docker-compose 설정
- **CI/CD**: GitHub Actions를 통한 자동화된 배포

## 파일 구조
- `src/`: 소스 코드
  - `main/`: 애플리케이션 소스 코드
  - `test/`: 테스트 코드
- `Dockerfile`: 도커 이미지 설정 파일
- `docker-compose.yml`: Docker Compose 설정 파일
- `.github/workflows/gradle.yml`: GitHub Actions 워크플로우 파일

## 사용 방법
1. 저장소 클론:
   ```bash
   git clone https://github.com/HWANGMA27/AWS-TEST.git
   cd AWS-TEST

2.	Docker Compose로 컨테이너 실행:
    ```bash
    docker-compose up -d

3.	애플리케이션 접속: 웹 브라우저에서 http://localhost:8080 접속

## GitHub Actions 설정
github/workflows/gradle.yml 파일은 다음 작업을 포함합니다:
- 코드 푸시 시 자동 빌드 및 테스트
- Docker Hub에 이미지 푸시
- AWS EC2 인스턴스에 배포

## 필수 조건
- AWS 계정: EC2 인스턴스 생성 및 IAM 역할 설정
- Docker: 도커 및 도커 컴포즈 설치
- GitHub: GitHub Actions 사용을 위한 GitHub 계정
