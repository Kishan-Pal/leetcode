# Write your MySQL query statement below

with 
buyerids as (
    select buyer_id from Orders
    where order_date between '2019-01-01' and '2019-12-31'
)
select u.user_id as buyer_id, u.join_date, count(buyer_id) as orders_in_2019
from Users u left join buyerids on u.user_id = buyerids.buyer_id
group by u.user_id;