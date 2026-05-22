-- Last updated: 22/05/2026, 11:22:22
# Write your MySQL query statement below

select distinct author_id as id from views where author_id = viewer_id order by id;