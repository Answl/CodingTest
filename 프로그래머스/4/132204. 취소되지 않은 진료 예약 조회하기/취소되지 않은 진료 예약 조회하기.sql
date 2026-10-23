-- 코드를 입력하세요
SELECT a.APNT_NO, c.PT_NAME, c.PT_NO, b.MCDP_CD, b.DR_NAME, a.APNT_YMD
from APPOINTMENT a join DOCTOR b on a.MDDR_ID = b.DR_ID join PATIENT c on a.PT_NO = c.PT_NO
where date(a.APNT_YMD) = '20220413' and a.APNT_CNCL_YN = 'N' and b.MCDP_CD = 'CS'
order by a.APNT_YMD
