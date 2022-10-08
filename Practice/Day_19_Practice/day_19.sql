USE hammadb;

-- give a comprehesive overview of the table like no_of_rows, engine, version, create time, etc
SHOW TABLE STATUS WHERE NAME = 'Author';

-- show all the tables in the database
SHOW TABLES;

-- displays table_name and table_type of all the tables in the database
SHOW FULL TABLES;


-- ALTER TABLE Person
-- DROP INDEX Index_Name;

-- gives a detailed overview of the select query like select_type, table, rows, filtered, etc
EXPLAIN SELECT * FROM Author;

-- indexing is used to retrieve data from the database more quickly than otherwise.
-- create indexes on columns that will be frequently searched
-- indexing should not be used where there are large number of null values
-- index-type is B-tree in MySql
CREATE INDEX Author_Index
ON Author(Author_Name);

-- here author_name is frequently searched
SELECT Author_Age FROM Author WHERE Author_Name = 'Hammad';

CREATE INDEX Author_Index_Sub
ON Author(Author_Name);

ALTER TABLE Author
DROP INDEX Author_Index_Sub;

-- gives all the index in the given table
SHOW INDEX FROM Author;

-- gives detailed overview of the indexes in the given table like null, cardinality, index_type
SHOW EXTENDED INDEX FROM Author;


SELECT * FROM BOOKS;

-- the query below will create an index based on the first four characters (subparts) of the book_name column
CREATE INDEX Book_Index
ON Books(Book_Name(4));

SELECT Book_Name FROM BOOKS;

SHOW INDEX FROM Books;

-- view is like a virtual table created from select queries
-- dynamically connected
CREATE VIEW BOOK_INFO AS (SELECT a.Author_Name, b.Book_Name FROM Author a INNER JOIN Books b ON a.AuthorID = b.AuthorID);

SELECT * FROM BOOK_INFO;

-- will display book_info as a view
SHOW FULL TABLES;

-- updating a view automatically updates the table itself
UPDATE BOOK_INFO SET Author_Name = 'Sikandar' WHERE Book_Name = 'Python';

SELECT * FROM Author;

INSERT INTO Author(Author_Name, Author_Age) VALUES ('Mittu', 15);
INSERT INTO Books(Book_Name, Book_Price) VALUES ('NCERT', 1500);

UPDATE Books SET AuthorID = 6 WHERE Book_Name = 'NCERT';

-- the below query will display the view from another schema (db)
CREATE VIEW VIEW_NAME AS (SELECT * FROM SCHEMA_NAME.TABLE_NAME);

-- create a temporary table
-- they are dynamically linked as view i.e any changes in the original (parent) table
-- would not be be reflected in the temporary table 
-- A temporary table is visible only within the current session
-- and is dropped automatically when the session is closed
CREATE TEMPORARY TABLE Temp_Author 
SELECT Author_Name FROM Author;

SELECT * FROM Temp_Author;

-- the below query would not affect the temporary table temp_author
INSERT INTO Author (Author_Name, Author_Age) VALUES ('Samina', 40);










