-- 코드를 입력하세요
SELECT a.WRITER_ID, b.NICKNAME, concat(b.CITY, " ", b.STREET_ADDRESS1," ", b.STREET_ADDRESS2) as `전체주소`, 
concat(substring(b.TLNO,1,3),"-",substring(b.TLNO,4,4),"-",substring(b.TLNO,8,4)) as `전화번호`
from USED_GOODS_BOARD a join USED_GOODS_USER b on a.WRITER_ID = b.USER_ID
group by a.WRITER_ID
having count(BOARD_ID) >= 3
order by a.WRITER_ID desc