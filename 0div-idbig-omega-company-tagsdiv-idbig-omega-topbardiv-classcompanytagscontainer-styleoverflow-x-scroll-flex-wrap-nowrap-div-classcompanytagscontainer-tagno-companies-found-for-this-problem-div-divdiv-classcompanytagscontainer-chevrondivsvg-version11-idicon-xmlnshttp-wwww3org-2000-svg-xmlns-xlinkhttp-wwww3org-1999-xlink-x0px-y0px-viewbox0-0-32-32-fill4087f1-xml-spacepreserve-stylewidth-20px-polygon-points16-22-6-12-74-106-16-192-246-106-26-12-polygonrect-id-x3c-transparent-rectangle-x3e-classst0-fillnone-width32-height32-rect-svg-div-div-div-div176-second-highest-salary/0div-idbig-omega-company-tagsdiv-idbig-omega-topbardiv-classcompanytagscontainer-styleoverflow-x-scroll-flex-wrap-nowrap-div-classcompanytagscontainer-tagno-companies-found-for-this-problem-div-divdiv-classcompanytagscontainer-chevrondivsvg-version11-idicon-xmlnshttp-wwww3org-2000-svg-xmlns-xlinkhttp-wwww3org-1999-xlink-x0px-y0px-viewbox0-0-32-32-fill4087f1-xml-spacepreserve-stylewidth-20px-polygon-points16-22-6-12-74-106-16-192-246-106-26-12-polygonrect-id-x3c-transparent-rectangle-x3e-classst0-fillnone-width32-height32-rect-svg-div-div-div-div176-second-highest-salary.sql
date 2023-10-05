# Write your MySQL query statement below
SELECT MAX(salary) as SecondHighestSalary FROM Employee WHERE salary  = (SELECT DISTINCT salary FROM Employee ORDER BY salary desc LIMIT 1 OFFSET 1);