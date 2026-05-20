-- 코드를 입력하세요
SELECT a.book_id, b.author_name, a.PUBLISHED_DATE
from BOOK a join AUTHOR b on a.author_id = b.author_id
where CATEGORY='경제'
order by PUBLISHED_DATE;