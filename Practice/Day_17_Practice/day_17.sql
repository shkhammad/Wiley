USE hammadb;

CREATE TABLE Student(
	StudentID INT NOT NULL AUTO_INCREMENT,
    Full_Name VARCHAR(200) NULL,
    Result BOOLEAN NULL,
    
    -- there could be only 'one' primary key in the table
    PRIMARY KEY(StudentID)
);

-- boolean values in MySQL are false(0) and true(1)  
INSERT INTO Student (Full_Name, Result, Marks) VALUES ('Hammad', true, 90), ('Sikandar', false, 60), ('Max', true, 45);
-- we can pass the default value of the column which is 50 in this case
INSERT INTO Student (Full_Name, Result, Marks) VALUES ('Samina', true, DEFAULT);


-- maintains the structure or columns of the table and deletes only the rows from the table
-- better than drop if want to delete only rows of the table and not entire table from the db
TRUNCATE TABLE Student;

-- delete a particular column in the table
ALTER TABLE Student DROP COLUMN MARKS;

SELECT * FROM STUDENT;

-- add a particular column in the table with some default value
ALTER TABLE Student ADD COLUMN Marks INT DEFAULT 50;

-- gives the overview of the table with parameters such as Type, Null, Key, Default Value, Extra
DESC Student;

-- field method returns the index of the value from the list of column_values  
-- so if Marks = 50 the field will return 1 (so row would be at position 1), 
-- if Marks = 45 it will return 4 (so row would be at position 4)
-- and based on that the order by clause will order the rows 
SELECT * FROM Student 
ORDER BY FIELD(Marks, 50,90,60,45);

SELECT * FROM Student 
ORDER BY FIELD(StudentID, 1,4,3,2);

SELECT * FROM Student 
ORDER BY FIELD(Result, 1,0);

SELECT * FROM Student
WHERE Full_Name NOT LIKE 'H%';

-- 'in' takes any value in the list
SELECT * FROM Student
WHERE Marks IN (50,45);

-- limit index, total_rows (including from index)
-- index starts from 0
-- total_rows starts from 0 but 1 is preferred since we want the query to output something
SELECT * FROM Employee
LIMIT 1,5;

-- To display the current date from the system
SELECT CURDATE() AS 'Date' FROM DUAL;

-- To display the current time from the system
SELECT CURTIME() AS 'Time' FROM DUAL;
