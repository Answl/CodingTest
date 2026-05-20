-- 코드를 작성해주세요
select a.year as year, b.maxcol - a.SIZE_OF_COLONY as year_dev, a.id as id
from (select id, size_of_colony, year(DIFFERENTIATION_DATE) as year
from ECOLI_DATA) a
join 
(select year(DIFFERENTIATION_DATE) as year, max(SIZE_OF_COLONY) as maxcol
from ECOLI_DATA
group by year(DIFFERENTIATION_DATE)) b 
on a.year = b.year
order by year, year_dev