-- 코드를 입력하세요
select a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, 
round(avg(b.REVIEW_SCORE),2) as SCORE
from
(SELECT *
from REST_INFO
where address like '서울%') a join REST_REVIEW b
on a.REST_ID = b.REST_ID
group by REST_ID
order by SCORE desc, a.FAVORITES desc