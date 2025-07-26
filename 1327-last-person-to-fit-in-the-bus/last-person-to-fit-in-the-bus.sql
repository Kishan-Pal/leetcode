-- Write your PostgreSQL query statement below

select person_name from (
select *, sum(weight) over (order by turn) as moving_sum
from Queue ) as p
where moving_sum <= 1000
order by moving_sum desc
limit 1;