-- 코드를 작성해주세요
# select f.ID, n.FISH_NAME, f.LENGTH
# from (select id, fish_type, max(length) as masl from fish_info) a 
# join FISH_NAME_INFO b on a.FISH_TYPE = b.fish_type
# where f.length = masl
# order by f.id;

# select id, fish_type, length
# from fish_info 
# where length = (select fish_type, max(length)
# from fish_info 
# order by fish_type)

select c.id, b.fish_name, c.length
from (select fish_type, max(length) as maxl
from fish_info 
group by fish_type) a 
join FISH_NAME_INFO b using(fish_type)
join FISH_INFO c using(fish_type)
where c.length = a.maxl
order by c.id;
