-- 코드를 작성해주세요
select a.ID, c.FISH_NAME, a.LENGTH
from FISH_INFO a join 
(select FISH_TYPE, max(LENGTH) as ml
from FISH_INFO
group by FISH_TYPE) b on a.LENGTH = b.ml and a.FISH_TYPE = b.FISH_TYPE
join FISH_NAME_INFO c on a.FISH_TYPE = c.FISH_TYPE
order by a.ID
