-- Last updated: 22/05/2026, 11:24:57
# Write your MySQL query statement below
SELECT email from Person
group by email
having count(email) > 1;