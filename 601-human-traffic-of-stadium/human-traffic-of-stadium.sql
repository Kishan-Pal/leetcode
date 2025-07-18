-- Write your PostgreSQL query statement below

with temp as(
    select * from Stadium
    where people >= 100
    order by visit_date
)

select * from temp 
where 
id - 1 in (select id from temp) and id + 1 in (select id from temp) or
id - 2 in (select id from temp) and id - 1 in (select id from temp) or
id + 1 in (select id from temp) and id + 2 in (select id from temp);

