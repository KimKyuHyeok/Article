# Article

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
