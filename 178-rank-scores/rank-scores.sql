select s.score, 
    (select count(distinct s2.Score)
    from Scores s2
    where s2.Score >= s.Score) as 'Rank'
from Scores s
order by s.Score desc