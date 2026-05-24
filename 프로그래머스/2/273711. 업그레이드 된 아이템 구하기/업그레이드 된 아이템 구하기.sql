select c.item_id, c.ITEM_NAME, c.RARITY
from ITEM_INFO c
where c.ITEM_ID in (select b.ITEM_ID
from ITEM_INFO a join ITEM_TREE b on a.ITEM_ID = b.PARENT_ITEM_ID
where a.RARITY = 'RARE')
order by c.item_id desc