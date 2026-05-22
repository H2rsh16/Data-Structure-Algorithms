-- Last updated: 22/05/2026, 11:24:47
WITH ranked AS (
    SELECT Id, Email,
           ROW_NUMBER() OVER (PARTITION BY Email ORDER BY Id) AS rn
    FROM Person
)
DELETE FROM Person
WHERE Id IN (
    SELECT Id FROM ranked WHERE rn > 1
);
