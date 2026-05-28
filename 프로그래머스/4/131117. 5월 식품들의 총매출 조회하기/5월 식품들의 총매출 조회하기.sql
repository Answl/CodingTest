-- 코드를 입력하세요
SELECT a.PRODUCT_ID, a.PRODUCT_NAME, sum(price * AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT a join FOOD_ORDER b on a.PRODUCT_ID = b.PRODUCT_ID
where PRODUCE_DATE between '2022-05-01' and '2022-05-31'
group by a.PRODUCT_ID
order by TOTAL_SALES desc, a.PRODUCT_ID