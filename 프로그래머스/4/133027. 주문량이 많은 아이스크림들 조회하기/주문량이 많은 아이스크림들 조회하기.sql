-- 코드를 입력하세요
select t.flavor
from(
select a.flavor, sumj+sumf
from 
(SELECT flavor, sum(TOTAL_ORDER) as sumj from july
group by flavor) a join 
(select flavor, sum(TOTAL_ORDER) as sumf from FIRST_HALF
group by flavor) b on a.flavor = b.flavor
order by sumj+sumf desc
limit 3) t

