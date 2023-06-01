## 헬스원(HealthOne) : 나를 위한 건강관리 매니저

**안드로이드 어플리케이션 하나로 관리하는 건강관리 서비스**

<br/>

## 📜 프로젝트 개요

### **_당신의 건강한 삶을 헬스원이 함께하겠습니다._**

언제 어디서나 나만을 위한 건강관리 매니저 **헬스원(healthone)** 으로!

- 휴대폰 앱 하나로 오늘의 걸음수를 측정할 수 있습니다.
- 오늘 먹은 음식과 운동을 기록해서 칼로리 계산도 해주고, 건강한 삶을 위한 당신의 수면 패턴 측정이 가능합니다.
- 복잡하고 관리하기 어려운 나의 건강상태를 앱하나로 스마트하게 관리해보세요.

### Andriod Application - HealthOne

[Google Play Store](https://play.google.com/store/apps/details?id=com.secui.healthone&pli=1)

<br/>

## 📃 주요기능

1. 건강 데이터 입력 및 목표 설정

2. 모바일 디바이스의 센서와 Google fit API를 사용한 걸음수 측정, 자체 수면 측정, 심박수 데이터 기록 (시각화 및 대시보드 제공)

3. 섭취 식단과 운동을 기록하고 칼로리 계산

4. 유저 맞춤형 운동 프로그램 소개

   - 많이 참여한, 유저들이 관심있어하는 운동 프로그램 소개

5. 건강 데이터 백업 및 다운로드

<br>

## 🎬 프로젝트 기간

#### 2023. 04. 10. (월) ~ 2023. 05. 19. (금) (6주)

<br/>

## 🛠 프로젝트에 사용된 기술

**Back-end : Spring Boot**

```
- Springboot 2.7.8
- Gradle 7.6
- Spring Data JPA
- Spring Security
- OAuth2
- Swagger 3.0.0
- MariaDB
- Redis
```

**Front-end : Web Application**

```
- axios 1.3.0
- react 18.2.0
- node.js 18.12.1
- react-redux 8.0.5
- redux 4.2.1
- sweetalert2 11.7.1
- swiper 9.0.0
```

**Front-end : Android Native App(with Kotlin)**

```
- Kotlin 222-1.8.0-release-AS3739.54
- Gradle 8.0
- Android compileSdk 33
- Java 8
- Android minSdk 26
- Android targetSdk 33
- Jetpack compose 1.6.1
- Compose UI 1.3.3
- Compose Material 1.2.0
- Compose Runtime: Runtime 1.3.3, Runtime LiveData 1.3.3, Runtime RxJava2 1.3.3
- Kotlin Extensions: Core KTX 1.7.0, Lifecycle Runtime KTX 2.3.1, Activity KTX 1.6.1
- Navigation Compose 2.4.1
- Coroutines Android 1.6.0
- Google Play Services: Location 21.0.1, Auth 20.1.0, Fitness 21.0.1
- Retrofit 2.9.0
- Converter Gson 2.9.0
- OkHttp 4.9.3
- Persistent Cookie Jar v1.0.1
```

**CI/CD**

```
- Elastic Amazone Kubernetes 1.25
- EC2 Ubuntu 20.04 LTS, Amazon Linux 2 v20230509
- S3
- CloudFront
- Jenkins 2.387.2
- ArgoCD v2.6.7+5bcd846
- docker 23.0.4
- Istio 1.27
- Envoy Proxy 1.25.4
- Docker registry latest
- Joxit-ui 1.5
- Ambassador Edge Stack 3.6.0
- ElasticSearch 8.6.2
- Fluentd 0.9.1
- Kibana 7.9.1
- AWS Network LoadBalancer
- AWS Elastic LoadBalancer
- Route53
- SonarQube 8.9.9
- Prometheus
- Grafana
- HorizontalPodAuthScaler
- Cluster AutoScaler 1.25.1
- AWS EBS CSI
```

<br/>

## 🚩 Project Info

### 1. 기능명세서

[기능 명세서(스프레드 시트) 보러가기](https://docs.google.com/spreadsheets/d/1r_Q3wj2S8LpA_8p1xgQYoIveTYeNxu2gi-hhOvXI3gA/edit?usp=sharing)

![기능명세서 Link](./assets/function_specification.PNG)

<br/>

### 2. 와이어 프레임

[와이어 프레임(피그마) 보러가기](https://www.figma.com/file/c6VDORQFg4rsYtcoMQqrsf/%EC%99%80%EC%9D%B4%EC%96%B4%ED%94%84%EB%A0%88%EC%9E%84?type=design&node-id=0%3A1&t=jultSwCYdOwtg0AB-1)

![와이어 프레임](./assets/wire_frame.PNG)

<br/>

### 3. 아키텍쳐 설계

![아키텍처 설계](./assets/healthone_architecture.png)

<br/>

### 4. E-R Diagram

[ERD 보러가기 (구글로그인 필요)](https://drive.google.com/file/d/1GRkUi9qbZjGUuojL2Cbs_ZNRKNWhOH9Z/view?usp=share_link)

![ERD](./assets/erd_table.jpg)

<br/>

### 5. API 명세서

[API 문서 보러가기](https://www.notion.so/BE-API-91a49862404d448e8c23e7051880e293?pvs=4)

![API 명세서 Link](./assets/healthone_api_docs.PNG)

<br/>

### 6. 간트 차트(Gantt Chart)

![간트 차트](./assets/gantt_chart.PNG)

<br/>

## 서비스 화면

### Android Application

#### 로그인 및 간편가입 페이지

<img src="./assets/login-register-img.jpg" width="768px"/>
<br/>

#### 메인 페이지

<img src="./assets/main-img.jpg" width="768px"/>
<br/>

#### 걸음수 측정 페이지

<img src="./assets/walk-measure-img.jpg" width="512px"/>
<br/>

#### 심박수 측정 페이지

<img src="./assets/heart-measure-img.jpg" width="1024px"/>
<br/>

### 식단 기록 페이지

<img src="./assets/diet-log-img1.jpg" width="768px" />
<br/>
<img src="./assets/diet-log-img2.jpg" width="768px" />
<br/>

### 건강 정보 페이지

<img src="./assets/health-info-img.jpg" width="512px" />
<br/>

### 🔥 챌린지 페이지

<img src="./assets/challenge-img1.jpg" width="768px" />
<br/>
<img src="./assets/challenge-img2.jpg" width="512px" />
<br/>

### 건강 데이터 다운로드 페이지

<img src="./assets/download-img.jpg" width="252px" height="560px"/>
<br/>

### WEB

#### 홈페이지 (홍보용 팜플릿 형식)

![홈페이지](./assets/healthone_hompage.png)

<br/>

#### 서비스 이용약관

![서비스 이용약관](./assets/healthone_term.png)

<br/>

#### 개인정보 처리방침

![개인정보 처리방침](./assets/healthone_policy.png)

<br/>

### 관리자 페이지 for APP Service

#### 로그인 페이지

<div align="left">
<img src="./assets/web_login1.png"/>
<img src="./assets/web_login2.png"/>
</div>

<br/>

#### 회원관리 페이지

<div align="left">
<img src="./assets/web_user_manage_list1.png"/>
<img src="./assets/web_user_manage_list2.png"/> 
<img src="./assets/web_user_manage_search.png"/>
</div>

<br/>

#### 불편사항 관리 페이지

<div align="left">
<img src="./assets/web_voice_list.png"/>
<img src="./assets/web_voice_answer.png"/>
</div>

<br/>

## 협업방식

### [](#matter-most)**Matter Most**

- 평상시 소통을 위한 도구
- 짧은 코드나 참조 url 공유

### **Notion** - [노션 워크스페이스 보러가기](https://playful-reading-a8e.notion.site/_-Health-One-1b0dc7ae9bfe4ebd94b3ce67f365ec3c)

- 프로젝트 환경설정 공유
- 프로젝트 문서 공유
- 회의록 저장
- 프로젝트 자료 정리

![](./assets/notion_1.PNG) <br>
![](./assets/notion_2.PNG) <br>
![](./assets/notion_3.PNG) <br>

### **Figma**

- 기획 회의
- 와이어 프레임 구성
- 직접 화면을 구성하면서 회의
- 실행가능한 프로토 타입을 통한 사용성 검증

### **Jira**

- 일정 관리
- 프로젝트 목표 공유
- 업무 배분

### **Git-lab**

- 개발 코드 형상 관리
- 메인, 작업 브랜치와 작업 브렌치로 구분
- 도메인별 핵심 브랜치에서 개발 기능 별로 브랜치를 확장하여 핵심 브랜치로 병합
- 브랜치 전략

## 협업 컨벤션

### 1. 브랜치 컨벤션

![브랜치 이미지](./assets/git_branch.jpg)
<br/>

### 2. 안드로이드 패키지 컨벤션

![안드로이드 패키지](./assets/android_package.png)

### 3. 백엔드 패키지 컨벤션

도메인 계층 전략

```
com
 ㄴ secui
     ㄴ healthone
         ㄴ domain
         |   ㄴ user
         |   |   ㄴ api
         |   |   ㄴ entity
         |   |   ㄴ service
         |   |   ㄴ dto
         |   |   ㄴ repository
         |   ㄴ walk
         |   |   ㄴ api
         |   |   ㄴ entity
         |   |   ㄴ service
         |   |   ㄴ dto
         |   |   ㄴ repository
         |   ...
         ㄴ global
             ㄴ config
             ㄴ error
             ㄴ response
             ㄴ util
             |   ...
```

### 4. 파이프라인

**Android Pipeline**

```
pipeline{
    agent{
        label 'healthone-front-jenkins'
    }
    tools{
        gradle 'Android-Gradle'
        jdk 'jdk-17'
    }

    stages{
        stage('GitLab Clone'){
            steps{
                git branch: "APP-build",credentialsId:"${env.GIT_CREDENTIAL_ID}",url:"${env.GITLAB_URL}"
                sh "chmod +x -R ${env.WORKSPACE}"
            }
        }

        stage('SonarQube analysis'){
            steps{
                withSonarQubeEnv('SonarQubeServer'){
                    dir('mobile'){
                        sh '''
                           ./gradlew init
                           chmod +x gradlew
                           '''
                    }
                }
            }
        }
        stage('Build ') {
            steps {
                echo 'Building'
                script {
//                    VARIANT = getBuildType()
                    dir('mobile'){
                        sh "gradle wrapper"
                        sh "chmod +x gradlew"
//                        sh "./gradlew clean bundleRelease" // 일반 APK 빌드
                        sh "find $WORKSPACE -name '*.aab'"
                    }
                }
            }
        }

        stage('Deploy App to Store') {
            steps {
                echo 'Deploying'
                script {
                    dir('mobile'){
                    }
                }
            }
        }
    }

    post {
        failure {
            mattermostSend (color: '#ff0000', message: "### Build Failure \n __Name__ \n ${env.JOB_NAME} \n __Version__ \n 0.0.${currentBuild.number}")
        }
        success {
            mattermostSend (color: '#81c147', message: "### Build Success \n __Name__ \n ${env.JOB_NAME} \n __Version__ \n 0.0.${currentBuild.number}")

        }
    }
}
```

**Back-End Pipeline Template**

````
pipeline{
    agent{
        label 'healthone-back-jenkins'
    }
    tools{
        gradle 'Gradle'
    }



    stages{
        stage('GitLab Clone'){
            steps{
                git branch: "be-challenge-service-build",credentialsId:"${env.GIT_CREDENTIAL_ID}",url:"${env.GITLAB_URL}"
                sh "chmod +x -R ${env.WORKSPACE}"
            }
        }

        stage('SonarQube analysis'){
            steps{
                withSonarQubeEnv('SonarQubeServer'){
                    dir('back/healthone-challenge-service'){
                        sh '''
                           gradle init
                           chmod +x gradlew
          '''
                    }
                }
            }
        }

        stage('JUnit Test'){
            steps{
                dir('back/healthone-challenge-service'){
                    script {
                        try {
                            sh "./gradlew test"
                        } catch (Exception e) {
                            throw mattermostSend (color: '#ff0000', message: "Junit Test Failure: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL}) \n ### Detail \n ```\n ${currentBuild.rawBuild.getLog(1000).join('\n')}\n```")
                        }
                    }
                }
            }
        }

        stage('Build'){
            steps{
                dir('back/healthone-challenge-service'){
                    sh "./gradlew clean build --exclude-task test"
                }
            }
        }

        stage('Push Docker Image'){
            steps{
                dir('back/healthone-challenge-service'){
                    script{
                       image.push()
                    }
                }
            }
        }

        stage('Clone ArgoCD'){
            steps{
                git branch: "master",credentialsId:"${env.GIT_CREDENTIAL_ID}",url:"${env.GITLAB_ARGO_URL}"
                sh "chmod +x -R ${env.WORKSPACE}"
            }
        }

        stage('Update Version'){
            steps{
            }
        }

        stage('Push ArgoCD Repo'){
            steps{
                sh """
                   git push
                   """
            }
        }
    }


    post {
        failure {
            mattermostSend (color: '#ff0000', message: "### Build Failure \n __Name__ \n ${env.JOB_NAME} \n __Version__ \n 0.0.${currentBuild.number}")
        }
        success {
            mattermostSend (color: '#81c147', message: "### Build Success \n __Name__ \n ${env.JOB_NAME} \n __Version__ \n 0.0.${currentBuild.number}")

        }
    }
}
````

### Project Member - 이산가족

- 조원희 (Team Leader, Android Developer)
- 박주승(Android Developer)
- 이상훈(Android Developer)
- 한재윤 (BackEnd, Backend Leader)
- 이흥종(BackEnd)
- 안효관 (CI/CD)
