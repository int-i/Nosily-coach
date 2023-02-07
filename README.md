## 2023 인트아이 초하루배 해커톤 3팀 프로젝트 - 꼬치코치

### 팀 및 프로젝트 소개

---

> 안녕하세요! 초하루배 해커톤 3팀 꼬치코치입니다!
>
> 저희 팀은 인공지능 1명, 백엔드 2명, 프론트엔드 2명으로 구성되어있으며, 각 구성원은 다음과 같습니다.
>
> > 인공지능: 이상훈  
> > 백엔드: 김주영, 원민재  
> > 프론트엔드: 이수민, 정연한(팀장)
>
> 저희가 개발을 진행한 프로젝트는 저희 팀명과 이름이 같은 꼬치코치입니다.  
> 꼬치코치는 운동 정보 제공 서비스로, 운동법 추천, 식단 기록, 운동 루틴 제공 등 운동과 관련된 다양한 정보를 제공하고 있습니다.

### 사용 된 기술 스택

---

- 인공지능
  - 언어: Python 3.9.16
  - 프레임워크: TensorFlow 2.11.0, Pandas 1.4.4
- 백엔드
  - 언어: Java 17
  - 프레임워크: Spring Boot 3.0.2
- 프론트엔드
  - 언어: JavaScript ES6
  - 프레임워크: React 18.2.0

### 꼬치코치 기능 설명

---

1. 운동법 추천
   - 인공지능을 통해 적절한 운동법 추천
2. 운동법
   - 특정 카테고리의 운동법을 사용자가 직접 선택
3. 식단 기록
   - 사용자가 먹은 음식 직접 입력
4. 몸 상태
   - 사용자가 몸 상태 직접 입력
5. 루틴
   - 여러 운동 루틴 선택지를 제공하여 사용자가 선택하는 방식
6. 타이머
   - 각 운동 시간 및 쉬는 시간을 재주는 기능

## 개발 환경 빌드 방법

### Frontend

1. clone한 본 프로젝트를 VS Code를 통해 연다.
2. `` Ctrl + ` `` 를 눌러 터미널을 열고, `cd frontend`를 입력한다.
3. 마찬가지로 터미널에서 `npm install`을 입력해 빌드에 필요한 node module들을 다운받는다.
4. 터미널에서 `cd ..`를 입력해 `Nosily-coach` 디렉터리로 빠져나온다.
5. 마지막으로 터미널에서 `npm run festart`를 입력해 frontend 프로젝트를 빌드한다.

### Backend

1. clone한 본 프로젝트를 IntelliJ를 통해 연다.
2. 꼬치코치 notion 페이지에 올라와있는 `application-oauth.properties` 파일을 다운받아 backend/src/main/resources 경로에 넣어준다.
3. Project Structure로 들어가서 `SDK`가 17 이상인지 확인하고, `Language level`이 17인지 확인한다.
4. Settings을 열고 `Build, Execution, Deployment > Build Tools > Gradle`로 들어가서
   - `Build and run using`, `Run tests using` : IntelliJ IDEA로 바꿨는지 확인
   - `Gradle JVM` : Project SDK로 설정
5. 마찬가지로 Settings에서 `Builld, Execution, Deployment > Compiler > Annotation Processors`로 들어가서
   - `Enable annotation processing` 체크되어있는지 확인
6. 그런 다음 Gradle을 다시 로드하면 빌드가 진행된다.
