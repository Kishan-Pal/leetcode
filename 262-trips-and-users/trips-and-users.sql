# Write your MySQL query statement below
with valid_row as (
    select t.id, t.status, t.request_at
    from Trips t
    join Users c on t.client_id = c.users_id
    join Users d on t.driver_id = d.users_id
    where request_at between '2013-10-01' and '2013-10-03' 
    and c.banned = 'No' and d.banned = 'No'
)

select request_at as 'Day', round(sum(status!='completed')/count(status), 2) as 'Cancellation Rate'
from valid_row
group by request_at

-- select * from valid_row