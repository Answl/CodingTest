-- 코드를 작성해주세요
select c.SCORE, b.EMP_NO, b.EMP_NAME, b.POSITION, b.EMAIL
from HR_EMPLOYEES b
join 
(select EMP_NO, sum(SCORE) as SCORE
from HR_GRADE
where year = 2022 
group by EMP_NO) c on b.EMP_NO = c.EMP_NO
order by c.SCORE desc
limit 1;