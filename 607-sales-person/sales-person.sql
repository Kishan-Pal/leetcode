-- Write your PostgreSQL query statement below

with red as (
    select com_id from Company
    where name like 'RED'
),
person_red as (
    select sales_id from Orders
    where com_id in (select com_id from red)
)
Select "name" from SalesPerson
where sales_id not in (select sales_id from person_red);