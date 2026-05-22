-- Last updated: 22/05/2026, 11:24:54
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary FROM employee as e
LEFT JOIN department d ON d.id = e.departmentId
WHERE e.salary = (
        SELECT MAX(salary) 
        FROM Employee 
        WHERE departmentId = e.departmentId
    );