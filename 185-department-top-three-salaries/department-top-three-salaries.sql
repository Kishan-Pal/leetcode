# Write your MySQL query statement below
select Department, Employee, Salary from
(select d.name as 'Department', e.name as 'Employee', e.salary as 'Salary',
dense_rank() over (partition by e.departmentId order by e.salary desc) as 'rank1'
from Employee e join Department d on e.departmentId = d.id) rankTable
where rank1 <= 3
