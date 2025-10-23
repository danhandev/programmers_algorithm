SELECT 
    e.id,
    COALESCE(c.child_count, 0) as child_count
FROM ecoli_data as e
LEFT JOIN (
    SELECT parent_id, count(*) as child_count
    FROM ecoli_data
    GROUP BY parent_id 
) as c
ON e.id = c.parent_id
ORDER BY id