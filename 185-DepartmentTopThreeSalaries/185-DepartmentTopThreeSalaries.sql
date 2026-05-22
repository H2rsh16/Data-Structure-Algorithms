-- Last updated: 22/05/2026, 11:24:53
WITH SalaryRank AS (
    SELECT 
        e.name AS Employee,
        e.salary AS Salary,
        d.name AS Department,
        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rnk
    FROM employee e
    JOIN department d ON e.departmentId = d.id
)
SELECT 
    Department,
    Employee,
    Salary
FROM SalaryRank
WHERE rnk <= 3;
