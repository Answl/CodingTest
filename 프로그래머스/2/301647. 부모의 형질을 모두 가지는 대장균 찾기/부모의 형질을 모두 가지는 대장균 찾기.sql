-- 코드를 작성해주세요 a가 부모, b가 자식
select b.ID, b.GENOTYPE, a.GENOTYPE
from ECOLI_DATA a join ECOLI_DATA b on a.ID = b.PARENT_ID
where b.GENOTYPE & a.GENOTYPE = a.GENOTYPE
