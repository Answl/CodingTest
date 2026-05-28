with recursive GEN as (
    select ID, PARENT_ID, 1 as GENERATION
    from ECOLI_DATA
    where PARENT_ID is null
     
    union all
    
    select b.id, b.PARENT_ID, a.GENERATION + 1
    from gen a join ECOLI_DATA b on a.ID = b.PARENT_ID
)

select count(*) as count, a.GENERATION
from gen a left join gen b on a.ID = b.PARENT_ID
where b.ID is null
group by a.GENERATION