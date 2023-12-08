# Article

---
### 프로젝트

Spring 과 Thymeleaf 문법을 학습하기 위해 만들어보는 게시판 서비스 입니다.
Security 를 이용하여 Login / Logout 부분을 구현하였고
CRUD 형식의 게시판 페이지 입니다.

---
### 프로젝트를 진행하면서 느낀 점

기본적인 기능 구현조차 어렵다고 생각했던 Security 부분이 생각보다 단순하였습니다.
이번 프로젝트를 하면서 디테일하고 다양한 부분을 구현한 것은 아니지만 Security 에 대해 한 층 더 알게되는 시간이였던 것 같습니다.
또한 thymeleaf 와 기본적인 CRUD 형식의 페이지가 어떻게 구성되고 어떻게 구현을 해야 더 깔끔하게 작성할 수 있는지 그리고
테스트 코드의 중요성과 편리함에 대해 한층 더 알게되는 시간이였던 것 같습니다.


---
### 기술 세부 스택
* Spring Boot Actuator
* Spring Web
* Spring Data JPA
* Rest Repositories
* Rest Repositories HAL Explorer
* Thymeleaf
* Spring Security
* H2 Database
* MySQL Driver
* Lombok
* Spring Boot DevTools
* Spring Configuration Processor

---

## API
|종료|URL|Method|기능|설명|
|----|-----|---|-----|-----|
|뷰|/|GET|루트 페이지|게시판 페이지로 이동|
|뷰|/error|GET|에러 페이지|--|
|뷰|/login|GET|로그인 페이지|--|
|뷰|/sign-up|GET|회원가입 페이지|--|
|뷰|/articles|GET|게시판 페이지|--|
|뷰|/aritcles/{article-id}|GET|게시글 페이지|--|
|뷰|/aritcles/search|GET|게시판 검색 전용 페이지|--|
|뷰|/articles/search-hashtag|GET|게시판 해시태그 검색 전용 페이지|--|
|API|/api/sign-up|POST|회원가입|--|
|API|/api/login|GET|로그인 요청|--|
|API|/api/articles|GET|게시글 리스트 조회|--|
|API|/api/aritcles/{article-id}|GET|게시글 단일 조회|--|
|API|/api/articles|POST|게시글 추가|--|
|API|/api/aritcles/{article-id}|PUT,PATCH|게시글 수정|--|
|API|/api/aritcles/{article-id}|DELETE|게시글 삭제|--|
|API|/api/articleComments|GET|댓글 리스트 조회|--|
|API|/api/articleComments/{article-comment-id}|GET|댓글 단일 조회|--|
|API|/api/articles/{aritcle-id}/articleComments|GET|게시글에 연관된 댓글 리스트 조회|--|
|API|/api/articles/{aritcle-id}/articleComments/{article-comment-id}|GET|게시글에 연관된 댓글 단일 조회|--|
|API|/api/articles/{article-id}/articleComments|POST|댓글 등록|--|
|API|/api/articles/{aritcle-id}/articleComments/{article-comment-id}|PUT,PATCH|댓글 수정|--|
|API|/api/articles/{aritcle-id}/articleComments/{article-comment-id}|DELETE|댓글 삭제|--|
