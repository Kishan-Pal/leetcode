-- Write your PostgreSQL query statement below

with 
requesters as (
    select requester_id, count(requester_id) count_r
    from RequestAccepted
    group by requester_id
),
accepters as (
    select accepter_id, count(accepter_id) count_a
    from RequestAccepted
    group by accepter_id
),
friends as (
    select coalesce(requester_id, accepter_id) as id, coalesce(count_r,0)+coalesce(count_a,0) as total_count
    from requesters full outer join accepters on requester_id = accepter_id
)
select id as id, total_count as num from friends
order by num desc
limit 1;