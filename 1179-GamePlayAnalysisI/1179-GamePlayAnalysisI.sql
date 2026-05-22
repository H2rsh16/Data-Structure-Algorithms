-- Last updated: 22/05/2026, 11:22:28
SELECT player_id, MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;
