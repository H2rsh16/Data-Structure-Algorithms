-- Last updated: 22/05/2026, 11:25:05
SELECT (SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET 1) AS SecondHighestSalary;