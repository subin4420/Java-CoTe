# 자바 코테 스터디 (IT's your life 5기)
2024년 알고리즘 스터디: "[Do it! 알고리즘 코딩테스트 자바편] 및 인프런 강의

<br>
<br>

## 📍팀원


|  | 박수빈 | 서석현 | 공희진 | 배광민 |
| --- | --- | --- | ---| ---|
| 이메일 | subin4420@gmail.com | 3 |0|0|
| Git | https://github.com/subin4420 | 6 |0|0|

|  | 백도현 | 오상민 | 오수민 | 이보윤 |
| --- | --- | --- | ---| ---|
| 이메일 | 0 | 3 |0|0|
| Git | 0 | 6 |0|0|


<br>

<br>


## 📍스터디 일정
### 총 기간 : 2024년 6월 4일 ~ 

- 스터디 분량 : 코딩테스트 전범위
- 스터디 언어 : Java
- 참고 자료
  <br>
  [Do it! 알고리즘 코딩테스트 자바편]
 <br>
  https://www.inflearn.com/course/%EB%91%90%EC%9E%87-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94/dashboard

<br>

- 스터디 주차별 계획
  - Part 02 주요 알고리즘 이론과 실전 문제(8개 챕터) + Part 03 알고리즘 유형별 기출문제
  - 주제별 4일씩 분량 설정하여 2일은 Part2로 이론 학습, 2일은 Part3로 실전 문제 풀이(단, 분량에 따라 유동적일 수 있습니다!)
      - ex) Part2의 ch3 그리디 학습 2일 → 그 다음 2일은 Part3 ch11 그리디 문제 풀이



- 상세 내용은 다음 링크 참조!<br>
[Notion/Java CoTe Study](노션렝크)

<br>
<br>

## 📍스터디 룰
- 개인 학습
    - 매주 정해진 분량에 따라 정리한 내용을 팀 Github Repository에 push
        - Part 2 Days→ 이론 학습 : 작은 챕터 분량을 반으로 나눠 이틀간 이론 내용 + 실전문제 함께 정리하여 push
        - Part 3 Days→ 기출문제 : 작은 챕터 분량을 반으로 나눠 이틀간 코드 + 풀이 정리하여 push
    - 문제 풀이가 포함되어 있는 경우 반드시 풀이과정 .md 파일로 함께 업로드 필수
    - 틀렸을 경우, 오답 노트 포함 업로드
    
     
- 팀 미팅
    - 매주 금 1회 진행
    - 문제 풀이 설명, 질의응답
    - ZEP or ZOOM : 미팅 시간에는 카메라 및 마이크 ON 유지


- 코어타임 운영
    - 매일(ZEP) 인증 가능 : 카메라 및 마이크 ON&OFF 자유롭게 진행
    - ```✏️자율(필수 참여 아님)✏️```

<br>
<br>

## 📍파일 관리
- 각자 이름으로 구성된 폴더 내에 개인 스터디 내용을 정리하는 방식으로 진행 <br>
  - 초기 설정
  1. ```
     git clone {현재 레포지터리 주소}
     ```
  2. ```
     git pull origin main
     ```
  3. ```
     git checkout -b {브랜치 이름(폴더 이름과 동일한 이름 권장)}
     ```
     <br>
     <br>

  - 그 후 사용
  1. ```
     git status //본인 이름으로 된 브랜치명이 뜨는지 반드시 확인할 것.
     ```
  2. 자유롭게 내용 추가
  3. ```
     git add .
     git commit -m "커밋 컨벤션을 지킨 내용으로 작성"
     git push origin {본인 브랜치}
     ```
  4. merge 진행<br>
     - 방법은 다음 링크 참조 : [Merge 진행 방법!](https://2l24algochallenge.notion.site/Merge-4f0f27f65df34f898e40a10a89041f14?pvs=4)
      

<br>
<br>

## 📍구조
- 4/4(목) 최종 Update 완료

```
└── 🗂 HayanLee
|   ├── 🗂 DFS_BFS
|   ├── 🗂 구현
|   ├── 🗂 그래프이론
|   ├── 🗂 그리디
|   ├── 🗂 다이나믹프로그래밍
|   ├── 🗂 삼성전자 기출
|   ├── 🗂 이진탐색
|   ├── 🗂 정렬
|   ├── 🗂 최단경로
|   └── 📑 참고.md
|
│
└── 🗂 SeowonLee
    ├── 🗂 Binary Search
    ├── 🗂 DFS·BFS
    ├── 🗂 Dynamic Programming
    ├── 🗂 Graph
    ├── 🗂 Greedy
    ├── 🗂 Implementation
    ├── 🗂 Shortest Path
    ├── 🗂 Sorting
    └── 🗂 삼성 기출

    
```

<br>
<br>

## KB IT's Your Life 5기 Algorithm & CS 스터디
---
## :computer:Algorithm
#### :ocean:Directory convention
```
src/{이름}/{n}주차/{플랫폼}{문제번호}_{이니셜2자}.java
ex) src/조우형/week1/boj1234_wh.java
```

#### :ocean:Source file convention
- 문제출처+문제번호_이름이니셜2자.java
  - 백준 - boj
  - 삼성 SW Expert Academy - swea
  - 프로그래머스 - pgs
  - ```ex) boj1234_wh.java```

#### :ocean:Commit convention
```
git commit -m"add : 이름/n주차/문제번호"
ex) git commit -m"add : 조우형/week1/boj1234"

수정하는 경우
git commit -m"fix : 조우형/week1/boj1234" 
```

#### :ocean:Pull Request convention
- PR 제목 ```이름/n주차/푼 문제번호(여러개면 여러개)```

   <img src=https://github.com/wxxhyeong/kb-study/assets/78301292/d44edcc2-d1dc-41c4-9870-53bc991e81ee width="600px" height="200px"/>

- <b>Add a description</b> : 문제 풀면서 어려웠던 점 or 접근 방법 or 풀지 못했다면 이유
  (ex. ~식으로 접근했는데 안됐다, 접근 방법을 모르겠다.) 를 남겨야 다른 팀원들의 코드 리뷰를 통해 해결할 수 있습니다!

##### :heavy_exclamation_mark: 주의 사항 :heavy_exclamation_mark:
- merge는 오전 9:00 또는 merge 요청에 진행
- 다른 팀원의 파일은 touch X

---

#### :smiley_cat:Git 초기 사용법
초기 설정에 시간 뺏기지 않도록 가이드라인 작성했습니다. 문제 생기거나 잘 안되는 부분 있으면 바로바로 물어보세요!

1. 저장소 fork
   
   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/68a993ed-db01-4e58-9e10-4f6eeda95245)

2. git clone하기
   
     ```git clone `원본 Repo말고 fork한 자신의 Repo주소'```
  
3. git bash or Repository 폴더에서 cmd 실행

   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/314b7dc8-7a36-4680-a1e4-1f833c7a6244)


4. 자신의 로컬 환경에서 이름으로 브랜치 생성 후 작업하기

   ```
   ex)
   git branch woohyeong // pc에 branch 생성 ※원격 Repository 환경에 생성된 것은 아님
   git checkout woohyeong // 작업할 브랜치로 전환 (main -> woohyeong)
   ```

5. 작업 후 push

   ```
   git add .   // 작업한 내용을 stage로 올리기
   git commit -m"message"   // commit message 작성
   git push origin woohyeong // 원격에 자신의 이름 branch가 있으면 거기에 push 없으면 자동으로 branch가 생성되며 push
   ```
   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/6403b0f7-3690-425e-af89-a01eb78843ab)

6. push 이후 web에서 pull request 작성
   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/1483839a-743f-4970-9098-2d962421d6d0)


## commit message convention
- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서
- style: 포맷팅, 누락된 세미콜론 등
- refactor: 코드 리팩토링
- test: 테스트 관련
- chore: 기타 수정
- build: 빌드 시스템 또는 외부 의존성에 영향을 주는 변경
- remove: 파일을 삭제
