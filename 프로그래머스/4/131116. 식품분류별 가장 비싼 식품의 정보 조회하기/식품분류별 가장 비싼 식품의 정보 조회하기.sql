# https://school.programmers.co.kr/learn/courses/30/lessons/131116
SELECT
    f.CATEGORY,
    f.PRICE AS MAX_PRICE,
    f.PRODUCT_NAME
FROM FOOD_PRODUCT f
JOIN (SELECT
    CATEGORY,
    MAX(PRICE) AS MAX_PRICE
FROM FOOD_PRODUCT
GROUP BY CATEGORY) m ON f.CATEGORY = m.CATEGORY
WHERE f.PRICE = m.MAX_PRICE
    AND f.CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC;

# 더 좋은 풀이 - 다른 사람 코드
# 방법 1 - WHERE 절에서 (CATEGORY, PRICE) IN (서브쿼리) 형식을 사용하면 따로 JOIN을 적지 않아도 되어 코드가 한결 간결해짐
# SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
# FROM FOOD_PRODUCT
# WHERE (CATEGORY, PRICE) IN (
#     SELECT CATEGORY, MAX(PRICE)
#     FROM FOOD_PRODUCT
#     GROUP BY CATEGORY
# ) AND CATEGORY IN ('과자', '국', '김치', '식용유')
# ORDER BY MAX_PRICE DESC;

# 방법2 - 코딩테스트에서 그룹 내 최댓값/최솟값을 가진 행을 찾을 때 가장 표준적으로 사용하는 방식 : FOOD_PRODUCT 테이블을 단 한 번만 스캔하므로 대용량 데이터에서 성능상 서브쿼리나 조인보다 유리할 때가 많다.
# 만약 동일 카테고리에 최고가를 가진 상품이 2개 이상일 때, 문제 조건에 따라 모두 출력해야 하면 RANK(), 하나만 출력해야 하면 ROW_NUMBER()를 선택해서 유연하게 대응
# SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
# FROM (
#     SELECT CATEGORY, PRICE, PRODUCT_NAME,
#            RANK() OVER (PARTITION BY CATEGORY ORDER BY PRICE DESC) AS rnk
#     FROM FOOD_PRODUCT
#     WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
# ) inline_view
# WHERE rnk = 1
# ORDER BY MAX_PRICE DESC;
