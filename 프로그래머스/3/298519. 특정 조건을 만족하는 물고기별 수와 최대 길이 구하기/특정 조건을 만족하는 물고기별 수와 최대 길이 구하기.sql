-- 코드를 작성해주세요
select count(*) as FISH_COUNT, max(a.LENGTH) as MAX_LENGTH, a.FISH_TYPE
from (select ID, FISH_TYPE, 
      case when LENGTH > 10 then LENGTH else 10 end as LENGTH, TIME
      from FISH_INFO) a
group by a.FISH_TYPE
having avg(a.LENGTH) >= 33
order by a.FISH_TYPE