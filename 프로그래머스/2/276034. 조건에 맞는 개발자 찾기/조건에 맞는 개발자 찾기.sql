-- 코드를 작성해주세요
select b.ID, b.EMAIL, b.FIRST_NAME, b.LAST_NAME
from DEVELOPERS b
where b.SKILL_CODE & (select CODE from SKILLCODES where NAME = 'Python') or b.SKILL_CODE & (select CODE from SKILLCODES where NAME = 'C#')
order by b.ID