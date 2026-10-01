-- 코드를 입력하세요
SELECT a.PRODUCT_CODE, sum(b.SALES_AMOUNT * a.PRICE) as total
from PRODUCT a join OFFLINE_SALE b on a.PRODUCT_ID = b.PRODUCT_ID
group by a.PRODUCT_CODE
order by total desc, a.PRODUCT_CODE