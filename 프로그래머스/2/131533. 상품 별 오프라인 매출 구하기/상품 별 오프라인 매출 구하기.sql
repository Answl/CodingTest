-- 코드를 입력하세요
select c.PRODUCT_CODE, c.SALES
from (SELECT a.PRODUCT_ID, a.PRODUCT_CODE, sum(b.SALES_AMOUNT)*a.price as SALES
from PRODUCT a join OFFLINE_SALE b on a.PRODUCT_ID=b.PRODUCT_ID
group by a.PRODUCT_ID) c
order by c.SALES desc, c.PRODUCT_CODE
