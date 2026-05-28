-- 코드를 입력하세요
select a.CATEGORY, a.max as max_price, b.PRODUCT_NAME
from 
(SELECT CATEGORY, max(PRICE) as max
from FOOD_PRODUCT
where CATEGORY in ('과자', '국', '김치', '식용유')
group by CATEGORY) a join FOOD_PRODUCT b on a.CATEGORY = b.CATEGORY
where a.max = b.price
order by max_price desc