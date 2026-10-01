-- 코드를 입력하세요
SELECT a.BOOK_ID, b.AUTHOR_NAME, a.PUBLISHED_DATE
from BOOK a join AUTHOR b on a.AUTHOR_ID = b.AUTHOR_ID
where CATEGORY = '경제'
order by a.PUBLISHED_DATE