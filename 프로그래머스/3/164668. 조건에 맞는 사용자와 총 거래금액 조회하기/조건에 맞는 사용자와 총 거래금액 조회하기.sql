-- 코드를 입력하세요
SELECT a.user_id, a.nickname, b.total_sales
from USED_GOODS_USER a join (
select writer_id, sum(PRICE) as total_sales
from USED_GOODS_BOARD
where STATUS = 'DONE'
group by writer_id
having sum(PRICE) >= 700000) b
on a.user_id = b.writer_id 
order by b.total_sales