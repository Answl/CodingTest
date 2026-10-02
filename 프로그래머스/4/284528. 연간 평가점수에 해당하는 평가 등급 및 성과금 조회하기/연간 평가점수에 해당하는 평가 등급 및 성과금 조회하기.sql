-- 코드를 작성해주세요
select a.EMP_NO, a.EMP_NAME, b.GRADE, b.bonus * a.SAL as BONUS
from HR_EMPLOYEES a join
(select EMP_NO, 
case 
    when avg(SCORE)>=96 then 'S'
    when avg(SCORE)>=90 then 'A'
    when avg(SCORE)>=80 then 'B'
    else 'C' end as grade,
case 
    when avg(SCORE)>=96 then 0.2
    when avg(SCORE)>=90 then 0.15
    when avg(SCORE)>=80 then 0.1
    else 0 end as bonus
from HR_GRADE
group by EMP_NO) b on a.EMP_NO = b.EMP_NO