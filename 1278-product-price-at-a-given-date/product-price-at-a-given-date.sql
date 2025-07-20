# Write your MySQL query statement below

with something as (
    select product_id, new_price, change_date, 
    dense_rank() over (partition by product_id order by change_date desc) as 'rank'
    from Products
    where change_date <= '2019-08-16'
    
), 
unique1 as (
    select distinct(product_id) from Products
)
select p.product_id, coalesce(something.new_price, 10) as price
from unique1 p left join something on p.product_id = something.product_id
where something.rank = 1 or something.rank is null;

-- select product_id, new_price as price
-- from Products 
-- group by product_id
-- having max(change_date) <= '2019-08-16';

-- 