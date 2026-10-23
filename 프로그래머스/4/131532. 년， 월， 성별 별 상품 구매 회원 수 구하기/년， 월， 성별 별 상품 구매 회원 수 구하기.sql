-- 코드를 입력하세요
SELECT year(b.SALES_DATE), month(b.SALES_DATE), a.gender, count(distinct b.USER_ID)
from USER_INFO a join ONLINE_SALE b on a.USER_ID = b.USER_ID
where a.gender is not null
group by year(b.SALES_DATE), month(b.SALES_DATE), a.gender
order by year(b.SALES_DATE), month(b.SALES_DATE), a.gender