# https://school.programmers.co.kr/learn/courses/30/lessons/131532
#  회원수 - 그룹별(년, 월, 성별) - 오름차순 / 성별 null이면 제외
SELECT
    YEAR(o.SALES_DATE) AS YEAR,
    MONTH(o.SALES_DATE) AS MONTH,
    u.gender AS GENDER,
    COUNT(DISTINCT u.user_id) AS USERS
FROM USER_INFO u
JOIN ONLINE_SALE o ON u.user_id = o.user_id
WHERE u.gender IS NOT NULL
GROUP BY YEAR, MONTH, u.gender
ORDER BY year ASC, month ASC, gender ASC;

# 문제를 제대로 안 읽어서 sales_date가 아니라 joined 기준으로 group by를 하고 있었음. 문제만 읽고 바로 풀지 않고 예시까지 시뮬레이션 해보는게 중요함
# user 중복 제거를 위해 DISTINCT 키워드도 사용함.