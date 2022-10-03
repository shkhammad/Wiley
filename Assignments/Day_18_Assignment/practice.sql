USE hammadb;

-- P1
SELECT * FROM employee;

-- P2
SELECT First_name, Last_name FROM employee;

-- P3
SELECT First_name AS 'Employee Name' FROM employee;

-- P4
SELECT LOWER(Last_name) AS 'Last Name' FROM employee;   
 
-- P5
SELECT UPPER(Last_name) AS 'Last Name' FROM employee;

-- P6 
SELECT DISTINCT Departement AS 'Department' FROM employee;

-- P7
SELECT SUBSTR(First_name, 1, 4) AS 'First_Four' FROM employee;

-- P8
SELECT POSITION('h' IN 'John') AS 'Position' FROM DUAL;

-- P9
SELECT RTRIM(First_name) AS 'Right Trim' FROM employee;

-- P10
SELECT LTRIM(First_name) AS 'Left Trim' FROM employee;

-- P11
SELECT LENGTH(First_name) AS 'First Name' FROM employee;

-- P12
SELECT REPLACE(First_name, 'o' , '#') AS 'First Name' FROM employee;

-- P13
SELECT DAY(Joining_date) AS 'Day', MONTH(Joining_date) AS 'Month', YEAR(Joining_date) AS 'Year' FROM employee;

-- P14
SELECT * FROM employee 
ORDER BY First_name;

-- P15
SELECT * FROM employee 
ORDER BY First_name DESC;

-- P16
SELECT * FROM employee 
ORDER BY First_name, Salary DESC;

-- P17
SELECT * FROM employee WHERE First_name = 'Bob';

-- P18
SELECT * FROM employee WHERE First_name = 'Bob' OR First_name = 'Alex';

-- P19
SELECT * FROM employee WHERE First_name <> 'Bob' AND First_name <> 'Alex';

-- P20
SELECT * FROM EMPLOYEE WHERE First_name LIKE 'J___';

-- P21
SELECT * FROM EMPLOYEE WHERE MONTH(Joining_date) = 1;

-- P22
SELECT * FROM EMPLOYEE WHERE Joining_date < '2019-03-01';

-- P23
SELECT TIMESTAMPDIFF(DAY, e.Joining_date, r.date_reward) AS 'Day Difference', TIMESTAMPDIFF(MONTH, e.Joining_date, r.date_reward) AS 'Month Difference' FROM employee e INNER JOIN reward r 
ON e.Employee_id = r.Employee_ref_id;









