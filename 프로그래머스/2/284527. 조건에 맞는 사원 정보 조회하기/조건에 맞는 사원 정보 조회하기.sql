-- 코드를 작성해주세요
select sum(b.SCORE) as SCORE, a.EMP_NO, a.EMP_NAME, a.POSITION, a.EMAIL
from HR_EMPLOYEES a join HR_GRADE b on a.EMP_NO = b.EMP_NO
group by a.EMP_NO 
order by SCORE desc
limit 1;
