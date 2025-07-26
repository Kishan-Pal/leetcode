-- Write your PostgreSQL query statement below

select to_char(t1.trans_date, 'yyyy-mm') as month, t1.country, count(t1.amount) as trans_count, count(t2.amount) as approved_count, coalesce(sum(t1.amount), 0) as trans_total_amount, coalesce(sum(t2.amount), 0) as approved_total_amount
from Transactions t1 left join (select * from Transactions where state = 'approved') t2 on t1.id = t2.id
group by t1.country, to_char(t1.trans_date, 'yyyy-mm')

-- 