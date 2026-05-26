-- 코드를 입력하세요

select a.AUTHOR_ID, c.AUTHOR_NAME, a.CATEGORY, sum(PRICE * b.summ) as TOTAL_SALES
from 
(SELECT BOOK_ID, sum(sales) as summ
from BOOK_SALES
where month(SALES_DATE) = 1 and year(SALES_DATE) = 2022
group by BOOK_ID) b join BOOK a on a.BOOK_ID = b.BOOK_ID 
join AUTHOR c on a.AUTHOR_ID = c.AUTHOR_ID
group by a.AUTHOR_ID, a.CATEGORY
order by a.AUTHOR_ID, a.CATEGORY desc