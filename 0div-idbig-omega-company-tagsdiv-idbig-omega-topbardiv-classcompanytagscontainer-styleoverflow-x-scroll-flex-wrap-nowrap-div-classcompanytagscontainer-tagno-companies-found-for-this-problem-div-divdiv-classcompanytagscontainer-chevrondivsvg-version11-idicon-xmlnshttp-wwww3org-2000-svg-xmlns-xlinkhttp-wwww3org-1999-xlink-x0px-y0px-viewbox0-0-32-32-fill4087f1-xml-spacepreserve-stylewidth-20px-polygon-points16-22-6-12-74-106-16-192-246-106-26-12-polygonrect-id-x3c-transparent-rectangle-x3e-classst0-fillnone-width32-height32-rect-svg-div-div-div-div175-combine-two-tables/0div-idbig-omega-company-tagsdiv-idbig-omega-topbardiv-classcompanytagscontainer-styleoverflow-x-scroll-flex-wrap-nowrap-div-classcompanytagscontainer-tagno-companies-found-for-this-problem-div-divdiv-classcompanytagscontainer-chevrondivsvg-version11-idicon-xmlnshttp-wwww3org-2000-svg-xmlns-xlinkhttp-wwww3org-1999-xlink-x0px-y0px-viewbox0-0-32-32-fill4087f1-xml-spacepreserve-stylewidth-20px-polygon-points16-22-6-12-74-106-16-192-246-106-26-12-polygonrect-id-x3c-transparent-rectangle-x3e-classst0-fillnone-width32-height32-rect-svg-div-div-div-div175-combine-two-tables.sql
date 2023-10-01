# Write your MySQL query statement below
SELECT per.firstName, per.lastName, addr.city,addr.state
FROM Person per
LEFT JOIN Address addr
ON per.personId = addr.personId