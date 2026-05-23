-- 코드를 입력하세요
SELECT a.CATEGORY, sum(b.SALES)
from BOOK a join BOOK_SALES b on a.BOOK_ID = b.BOOK_ID
where b.SALES_DATE between '2022-01-01' and '2022-01-31'
group by a.CATEGORY
order by a.CATEGORY