# Write your MySQL query statement below

select distinct(p.product_id), p.product_name
from Product p join Sales S on p.product_id = s.product_id
group by p.product_id
having max(s.sale_date) between '2019-01-01' and '2019-03-31'
    and min(s.sale_date) between '2019-01-01' and '2019-03-31';
