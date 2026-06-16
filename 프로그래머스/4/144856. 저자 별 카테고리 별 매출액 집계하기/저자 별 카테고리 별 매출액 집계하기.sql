# https://school.programmers.co.kr/learn/courses/30/lessons/144856
# 잘못 적은 코드 - 문제의 원인: a.AUTHOR_NAME과 b.PRICE 컬럼이 GROUP BY 절에 없습니다.

# AUTHOR_ID와 CATEGORY별로 데이터를 묶으면, 데이터베이스는 해당 그룹에 속한 여러 행 중 어떤 행의 AUTHOR_NAME이나 PRICE를 선택해야 할지 알 수 없습니다. -> GROUP BY는 SELECT보다 먼저 실행됩니다. 따라서 SELECT에서 GROUP BY에 없는 컬럼을 호출하면, DB는 어떤 데이터를 보여줘야 할지 결정하지 못해 오류를 반환합니다.

# 표준 SQL에서는 집계 함수(SUM, MAX, MIN 등)로 감싸지 않은 컬럼은 반드시 GROUP BY에 포함해야 합니다.
# 이미 서브쿼리(s)에서 BOOK_ID별로 판매량을 합산했으므로, 메인 쿼리에서는 전체 매출액을 SUM으로 합산하는 것이 정확합니다.
# SELECT
#     b.AUTHOR_ID,
#     a.AUTHOR_NAME,
#     b.CATEGORY,
#     s.group_sales * b.PRICE AS TOTAL_SALES
# FROM BOOK b
# JOIN (SELECT BOOK_ID, SUM(SALES) AS group_sales
#         FROM BOOK_SALES 
#         WHERE SALES_DATE >= '2022-01-01' AND SALES_DATE < '2022-02-01'
#         GROUP BY BOOK_ID) s ON b.BOOK_ID = s.BOOK_ID
# JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
# GROUP BY AUTHOR_ID, AUTHOR_NAME, CATEGORY
# ORDER BY AUTHOR_ID ASC, CATEGORY DESC;

# 더 좋은 정답 코드
SELECT 
    a.AUTHOR_ID, 
    a.AUTHOR_NAME, 
    b.CATEGORY, 
    SUM(s.SALES * b.PRICE) AS TOTAL_SALES
FROM BOOK_SALES s
JOIN BOOK b ON s.BOOK_ID = b.BOOK_ID
JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE s.SALES_DATE LIKE '2022-01%'
GROUP BY a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY
ORDER BY a.AUTHOR_ID ASC, b.CATEGORY DESC;