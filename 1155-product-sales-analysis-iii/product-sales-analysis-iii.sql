# Write your MySQL query statement below
select product_id, year as first_year, quantity, price from
(select sale_id, product_id, year, quantity, price, 
dense_rank() over (partition by product_id order by year) as 'rank'
from Sales) as temp
where temp.rank = 1;