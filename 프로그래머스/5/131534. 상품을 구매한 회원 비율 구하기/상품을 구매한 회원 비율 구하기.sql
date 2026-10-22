-- 코드를 입력하세요
select year(b.SALES_DATE) as year, month(b.SALES_DATE) as month, count(distinct a.USER_ID) as PURCHASED_USERS , round(count(distinct a.USER_ID)/c.count, 1) as PURCHASED_RATIO
from
(SELECT USER_ID
from USER_INFO 
where year(joined) = 2021) a join ONLINE_SALE b on a.USER_ID = b.USER_ID join 
(SELECT count(distinct USER_ID) as count
from USER_INFO 
where year(joined) = 2021) c
group by year(b.SALES_DATE), month(b.SALES_DATE)
order by year, month