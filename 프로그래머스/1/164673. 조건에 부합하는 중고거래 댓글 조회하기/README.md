## ✅ 학습 포인트 & 확장 개념

### 1. **JOIN의 정확성: 단순 병합이 아닌 ‘관계 기반 결합’**

* `FROM A, B` 구문은 카테시안 곱(Cartesian Product)을 만들어 **조합 가능한 모든 행**을 생성함.
  → 조건이 누락되면 데이터가 수천 배로 폭증할 수 있음.
* `JOIN ... ON`은 **관계형 데이터의 논리적 결합**으로, **키(Primary/Foreign Key)**를 명시적으로 사용하여 안전하고 명확하게 연결함.
---

### 2. **날짜 비교: BETWEEN보다 경계 명시가 더 안전**

* `BETWEEN '2022-10-01' AND '2022-10-31'` 은 시간 정보가 있는 경우 `2022-10-31 23:59:59` 이전 데이터만 포함함.
  → DATETIME 컬럼이면 일부 데이터가 누락될 수 있음.
* `>= '2022-10-01' AND < '2022-11-01'` 형식은 **시간 정보 유무와 상관없이 안전**함.

---

### 3. **날짜 포맷팅은 SELECT 출력 전용으로만**

* `DATE_FORMAT()`은 데이터 비교용이 아니라 **표시용 함수**로만 사용해야 함.
  WHERE절에서 변환을 쓰면 **인덱스가 깨짐(Full Table Scan)** → 성능 저하.
* *날짜 비교는 원본 형식 그대로**, **출력만 포맷팅**이 원칙.

---

### 4. **다중 정렬(ORDER BY) 설계 시 주의점**

* `ORDER BY created_date, title`은 내부적으로 **Stable Sort**를 수행함.
  즉, 첫 번째 정렬 기준이 같을 때만 두 번째 정렬을 적용.
* 기본이 `ASC`(오름차순)이므로 **명시하지 않아도 되지만**, 실무에서는 **가독성을 위해 명시**하는 것이 좋음.
  → 팀 코드 리뷰에서 “정렬 의도”를 명확히 하기 위해.
* 인덱스 튜닝 시에도 ORDER BY 순서가 중요하므로, 정렬 순서를 일관되게 유지하는 습관이 좋음.

---

### 5. **JOIN 순서와 필터 순서의 성능 영향**

* MySQL 옵티마이저는 내부적으로 JOIN 순서를 재조정하지만,
  **WHERE 필터를 더 좁은 범위의 테이블에 먼저 적용**하는 게 기본 원칙.
* 즉, `USED_GOODS_BOARD`에서 먼저 2022-10월 게시글을 좁혀놓고
  → 그 결과에 대해서만 댓글 테이블을 JOIN하는 것이 효율적.

  ```sql
  FROM (SELECT * FROM USED_GOODS_BOARD WHERE CREATED_DATE >= '2022-10-01' AND CREATED_DATE < '2022-11-01') AS B
  JOIN USED_GOODS_REPLY AS R ON B.BOARD_ID = R.BOARD_ID
  ```

  이렇게 하면 옵티마이저가 정확히 인덱스 필터링된 subset에만 join 수행.

---

### 6. **DATE 타입과 DATETIME 타입의 차이 인식**

* `DATE`: 날짜만 저장 (`YYYY-MM-DD`)
* `DATETIME`: 날짜 + 시각 (`YYYY-MM-DD HH:MM:SS`)
  → 비교 시 시각 포함 여부에 따라 누락 발생 가능

---

### 7. **조건식의 논리 연산자**

* MySQL에서는 `&&`와 `AND`가 동일하게 동작하지만,
  표준 SQL에서는 `AND`를 권장함.
  → DBMS 호환성과 코드 가독성을 위해 `AND`로 통일하는 습관이 좋음.
  (ANSI SQL 2016 표준)




# [level 1] 조건에 부합하는 중고거래 댓글 조회하기 - 164673 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/164673) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > SELECT

### 채점결과

Empty

### 제출 일자

2025년 10월 16일 18:26:45

### 문제 설명

<p>다음은 중고거래 게시판 정보를 담은 <code>USED_GOODS_BOARD</code> 테이블과 중고거래 게시판 첨부파일 정보를 담은 <code>USED_GOODS_REPLY</code> 테이블입니다. <code>USED_GOODS_BOARD</code> 테이블은 다음과 같으며 <code>BOARD_ID</code>, <code>WRITER_ID</code>, <code>TITLE</code>, <code>CONTENTS</code>, <code>PRICE</code>, <code>CREATED_DATE</code>, <code>STATUS</code>, <code>VIEWS</code>은 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>BOARD_ID</td>
<td>VARCHAR(5)</td>
<td>FALSE</td>
</tr>
<tr>
<td>WRITER_ID</td>
<td>VARCHAR(50)</td>
<td>FALSE</td>
</tr>
<tr>
<td>TITLE</td>
<td>VARCHAR(100)</td>
<td>FALSE</td>
</tr>
<tr>
<td>CONTENTS</td>
<td>VARCHAR(1000)</td>
<td>FALSE</td>
</tr>
<tr>
<td>PRICE</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
<tr>
<td>CREATED_DATE</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>STATUS</td>
<td>VARCHAR(10)</td>
<td>FALSE</td>
</tr>
<tr>
<td>VIEWS</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p><code>USED_GOODS_REPLY</code> 테이블은 다음과 같으며 <code>REPLY_ID</code>, <code>BOARD_ID</code>, <code>WRITER_ID</code>, <code>CONTENTS</code>, <code>CREATED_DATE</code>는 각각 댓글 ID, 게시글 ID, 작성자 ID, 댓글 내용, 작성일을 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>REPLY_ID</td>
<td>VARCHAR(10)</td>
<td>FALSE</td>
</tr>
<tr>
<td>BOARD_ID</td>
<td>VARCHAR(5)</td>
<td>FALSE</td>
</tr>
<tr>
<td>WRITER_ID</td>
<td>VARCHAR(50)</td>
<td>FALSE</td>
</tr>
<tr>
<td>CONTENTS</td>
<td>VARCHAR(1000)</td>
<td>TRUE</td>
</tr>
<tr>
<td>CREATED_DATE</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<hr>

<h5>문제</h5>

<p><code>USED_GOODS_BOARD</code>와 <code>USED_GOODS_REPLY</code> 테이블에서 2022년 10월에 작성된 게시글 제목, 게시글  ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요. 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글  제목을 기준으로 오름차순 정렬해주세요.</p>

<hr>

<h5>예시</h5>

<p><code>USED_GOODS_BOARD</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th>BOARD_ID</th>
<th>WRITER_ID</th>
<th>TITLE</th>
<th>CONTENTS</th>
<th>PRICE</th>
<th>CREATED_DATE</th>
<th>STATUS</th>
<th>VIEWS</th>
</tr>
</thead>
        <tbody><tr>
<td>B0001</td>
<td>kwag98</td>
<td>반려견 배변패드 팝니다</td>
<td>정말 저렴히 판매합니다. 전부 미개봉 새상품입니다.</td>
<td>12000</td>
<td>2022-10-01</td>
<td>DONE</td>
<td>250</td>
</tr>
<tr>
<td>B0002</td>
<td>lee871201</td>
<td>국내산 볶음참깨</td>
<td>직접 농사지은 참깨입니다.</td>
<td>3000</td>
<td>2022-10-02</td>
<td>DONE</td>
<td>121</td>
</tr>
<tr>
<td>B0003</td>
<td>goung12</td>
<td>배드민턴 라켓</td>
<td>사놓고 방치만 해서 팝니다.</td>
<td>9000</td>
<td>2022-10-02</td>
<td>SALE</td>
<td>212</td>
</tr>
<tr>
<td>B0004</td>
<td>keel1990</td>
<td>디올 귀걸이</td>
<td>신세계강남점에서 구입. 정품 아닐시 백퍼센트 환불</td>
<td>130000</td>
<td>2022-10-02</td>
<td>SALE</td>
<td>199</td>
</tr>
<tr>
<td>B0005</td>
<td>haphli01</td>
<td>스팸클래식 팔아요</td>
<td>유통기한 2025년까지에요</td>
<td>10000</td>
<td>2022-10-02</td>
<td>SALE</td>
<td>121</td>
</tr>
</tbody>
      </table>
<p><code>USED_GOODS_REPLY</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th>REPLY_ID</th>
<th>BOARD_ID</th>
<th>WRITER_ID</th>
<th>CONTENTS</th>
<th>CREATED_DATE</th>
</tr>
</thead>
        <tbody><tr>
<td>R000000001</td>
<td>B0001</td>
<td>s2s2123</td>
<td>구매하겠습니다. 쪽지 드립니다.</td>
<td>2022-10-02</td>
</tr>
<tr>
<td>R000000002</td>
<td>B0002</td>
<td>hoho1112</td>
<td>쪽지 주세요.</td>
<td>2022-10-03</td>
</tr>
<tr>
<td>R000000003</td>
<td>B0006</td>
<td>hwahwa2</td>
<td>삽니다. 연락주세요.</td>
<td>2022-10-03</td>
</tr>
<tr>
<td>R000000004</td>
<td>B0007</td>
<td>hong02</td>
<td>예약중</td>
<td>2022-10-06</td>
</tr>
<tr>
<td>R000000005</td>
<td>B0009</td>
<td>hanju23</td>
<td>구매완료</td>
<td>2022-10-07</td>
</tr>
</tbody>
      </table>
<p>SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th>TITLE</th>
<th>BOARD_ID</th>
<th>REPLY_ID</th>
<th>WRITER_ID</th>
<th>CONTENTS</th>
<th>CREATED_DATE</th>
</tr>
</thead>
        <tbody><tr>
<td>반려견 배변패드 팝니다</td>
<td>B0001</td>
<td>R000000001</td>
<td>s2s2123</td>
<td>구매하겠습니다. 쪽지 드립니다.</td>
<td>2022-10-02</td>
</tr>
<tr>
<td>국내산 볶음참깨</td>
<td>B0002</td>
<td>R000000002</td>
<td>hoho1112</td>
<td>쪽지 주세요.</td>
<td>2022-10-03</td>
</tr>
</tbody>
      </table>
<hr>

<h5>주의사항</h5>

<p><code>CREATED_DATE</code>의 포맷이 예시의 포맷과 일치해야 정답처리 됩니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
