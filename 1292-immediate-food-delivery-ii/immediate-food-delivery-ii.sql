-- Write your PostgreSQL query statement below
with ranked as (
    select *, 
    dense_rank() over (partition by customer_id order by order_date) as rank
    from Delivery
),
first_orders as (
    select *  from ranked where rank = 1
),
immediate_orders as (
    select *  from ranked where rank = 1 and order_date = customer_pref_delivery_date
)
select round(count(i.delivery_id)::decimal/count(*) * 100,2) as immediate_percentage
from first_orders f left join immediate_orders i on f.delivery_id = i.delivery_id;
-- select round(immediate_order_count / first_order_count, 2) as immediate_percentage 
-- from first_orders, immediate_orders;