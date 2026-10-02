# -- 코드를 입력하세요
# select year(SALES_DATE), month(SALES_DATE), count(distinct a.USER_ID)
# from ONLINE_SALE a join (
# SELECT USER_ID, count(*)
# from USER_INFO
# where year(JOINED) = 2021 ) b on a.USER_ID = b.USER_ID
# group by year(SALES_DATE), month(SALES_DATE)
select year(SALES_DATE), month(SALES_DATE), count(distinct b.USER_ID),
round(count(distinct b.USER_ID) / cc,1) as PUCHASED_RATIO
from ONLINE_SALE a join
(SELECT USER_ID
from USER_INFO
where year(JOINED) = 2021) b
on a.USER_ID = b.USER_ID join
(SELECT count(*) as cc
from USER_INFO 
where year(JOINED) = 2021) c
group by year(SALES_DATE), month(SALES_DATE)