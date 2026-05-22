-- Last updated: 22/05/2026, 11:23:34
SELECT class
FROM Courses
WHERE class IS NOT NULL
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
