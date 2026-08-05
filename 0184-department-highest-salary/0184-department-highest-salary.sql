# Write your MySQL query statement below
SELECT d.name AS Department,
       e.name AS Employee,
       e.salary AS Salary

FROM Employee e
LEFT JOIN Department d
ON e.departmentId = d.id

-- Match the (departmentId, salary) pair from the original table
WHERE (e.departmentId, e.salary) IN
(
    SELECT departmentId,
           MAX(salary) AS Max_salary
    FROM Employee
    GROUP BY departmentId
);