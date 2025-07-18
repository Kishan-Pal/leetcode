-- Write your PostgreSQL query statement below

select name, population, area
from world
where true
and area >= 3000000 or population >= 25000000