-- Write your PostgreSQL query statement below

select 
    visited_on,
    (
        select sum(amount) 
        from Customer
        where visited_on between c.visited_on - interval '6 days' and c.visited_on
    ) as amount,
    round((
        select sum(amount)::decimal/7
        from Customer
        where visited_on between c.visited_on - interval '6 days' and c.visited_on
    ), 2) as average_amount
from Customer c
where c.visited_on >= (
    select min(visited_on) + interval '6 days'
    from Customer
)
group by visited_on
order by visited_on