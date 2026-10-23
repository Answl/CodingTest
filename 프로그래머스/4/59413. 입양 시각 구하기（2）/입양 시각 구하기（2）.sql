-- 코드를 입력하세요
with recursive hi as (
    select 0 as hour
    
    union all 
    select hour+1 as hour
    from hi
    where hour+1 < 24
) 

SELECT b.hour, count(a.ANIMAL_ID)
from ANIMAL_OUTS a right join hi b on hour(a.DATETIME) = b.hour
group by b.hour
order by b.hour