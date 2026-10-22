-- 코드를 입력하세요
# SELECT
# from MEMBER_PROFILE a join REST_REVIEW b on a.MEMBER_ID = b.MEMBER_ID

select MEMBER_NAME, REVIEW_TEXT, REVIEW_DATE
from MEMBER_PROFILE a join 
REST_REVIEW b on a.MEMBER_ID = b.MEMBER_ID
join (select MEMBER_ID, count(REVIEW_SCORE)
from REST_REVIEW 
group by MEMBER_ID
order by count(REVIEW_SCORE) desc
limit 1) c on b.MEMBER_ID = c.MEMBER_ID
order by REVIEW_DATE, REVIEW_TEXT

