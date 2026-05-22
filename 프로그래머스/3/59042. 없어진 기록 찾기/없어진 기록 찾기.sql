-- 코드를 입력하세요
SELECT b.ANIMAL_ID, b.NAME
from ANIMAL_INS a right join ANIMAL_OUTS b on a.ANIMAL_ID = b.ANIMAL_ID
where a.DATETIME is null
order by b.ANIMAL_ID