-- Last updated: 22/05/2026, 11:25:06
SELECT firstName, lastName, city, state
FROM person
left join address
ON person.personId = address.personId;