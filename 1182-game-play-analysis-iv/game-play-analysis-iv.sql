# Write your MySQL query statement below
with first_login as (
    select player_id, event_date
    from (
        select *, row_number() over (partition by player_id order by event_date) as rowNum
        from Activity
    ) as temp
    where rowNum = 1
)
select round(
    (select count(f.player_id) as 'count'
    from first_login f join Activity a on f.player_id = a.player_id and datediff(a.event_date, f.event_date) = 1)/
    (select count(distinct player_id) as 'count'
    from Activity a), 2
) as 'fraction'




-- select * from first_login

-- select round(count(a1.player_id)/count(distinct a2.player_id), 2) as 'fraction'
-- from (
--     select f.player_id
--     from c
-- ) as a1, Activity a2