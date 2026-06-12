# https://school.programmers.co.kr/learn/courses/30/lessons/293261?language=mysql

# 1차 풀이
# SELECT 
#     f.id,
#     n.fish_name,
#     f.length AS length
# FROM fish_info f
# JOIN fish_name_info n ON f.fish_type = n.fish_type
# JOIN (SELECT 
#         fish_type,
#         MAX(length) AS max_length
#      FROM fish_info
#      GROUP BY fish_type) m ON f.fish_type = f.fish_type
# WHERE f.length = m.max_length
# GROUP BY f.fish_type;

SELECT 
    f.id,
    n.fish_name,
    f.length AS length
FROM fish_info f
JOIN fish_name_info n ON f.fish_type = n.fish_type
JOIN (SELECT 
        fish_type,
        MAX(length) AS max_length
     FROM fish_info
     GROUP BY fish_type) m ON f.fish_type = m.fish_type
WHERE f.length = m.max_length
GROUP BY f.fish_type;