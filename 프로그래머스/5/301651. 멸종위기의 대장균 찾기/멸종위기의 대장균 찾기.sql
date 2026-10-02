-- 코드를 작성해주세요
with recursive tree as (
    select id, PARENT_ID, 1 as gen
    from ECOLI_DATA
    where PARENT_ID is null
    
    union all
    
    select a.id, a.PARENT_ID, gen +1
    from ECOLI_DATA a join tree b on b.id = a.parent_id
)
select count(*) ,a.gen as GENERATION
from tree a left join tree b on a.ID = b.PARENT_ID
where b.ID is null
group by a.gen