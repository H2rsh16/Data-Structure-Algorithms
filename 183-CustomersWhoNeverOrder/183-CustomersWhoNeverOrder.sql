-- Last updated: 22/05/2026, 11:24:56
SELECT c.name As Customers
FROM customers c
LEFT JOIN orders o ON c.id = o.customerId
WHERE o.customerId IS NULL;