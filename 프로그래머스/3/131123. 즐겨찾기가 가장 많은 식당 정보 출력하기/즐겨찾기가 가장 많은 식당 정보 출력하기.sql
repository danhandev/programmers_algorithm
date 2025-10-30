-- 코드를 입력하세요
SELECT 
    FOOD_TYPE,
    REST_ID, 
    REST_NAME, 
    FAVORITES
FROM rest_info r1
WHERE FAVORITES = (
    SELECT MAX(favorites)
    FROM rest_info r2
    WHERE r1.food_type = r2.food_type)
ORDER BY food_type DESC;