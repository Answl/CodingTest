-- 코드를 작성해주세요
select count(*) as FISH_COUNT, a.FISH_NAME as FISH_NAME
from FISH_NAME_INFO a join FISH_INFO b on a.FISH_TYPE = b.FISH_TYPE
group by a.FISH_TYPE
order by FISH_COUNT desc