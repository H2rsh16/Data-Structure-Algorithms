-- Last updated: 22/05/2026, 11:25:03
select score, rnk as "rank"
from (
    select score, dense_rank() over (order by score desc) as rnk
    from scores
) ranked