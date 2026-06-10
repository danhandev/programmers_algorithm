# SELECT id FROM ecoli_data WHERE parent_id IN (SELECT id FROM ecoli_data WHERE parent_id IN (SELECT id FROM ecoli_data WHERE parent_id IS NULL));

WITH a as (SELECT id FROM ecoli_data WHERE parent_id IS NULL),
    b as (SELECT id FROM ecoli_data WHERE parent_id IN (select * from a))
select id FROM ecoli_data WHERE parent_id IN (select * from b);