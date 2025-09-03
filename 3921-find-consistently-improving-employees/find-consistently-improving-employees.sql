# Write your MySQL query statement below

with ranking as (
    select e.name, e.employee_id, p.review_date, p.rating,
    RANK() over (partition by p.employee_id order by p.review_date desc) as ranks
    from performance_reviews as p join employees as e on e.employee_id = p.employee_id
),
reduced as (
    select employee_id, name, 
    max(case when ranks = 1 then rating end) as last_rating,
    max(case when ranks = 2 then rating end) as sec_rating,
    max(case when ranks = 3 then rating end) as first_rating
    from ranking
    group by employee_id, name
)
select employee_id, name, last_rating - first_rating as improvement_score
from reduced 
where last_rating is not null 
and first_rating is not null
and last_rating > sec_rating
and sec_rating > first_rating
order by improvement_score desc, name asc;