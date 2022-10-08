USE hammadb;

CREATE TABLE Actor(
	ActorID INT NOT NULL AUTO_INCREMENT,
	First_Name VARCHAR(100) NULL,
	Last_Name VARCHAR(100) NULL,
    
    PRIMARY KEY(ActorID),
    -- unique constraint ensures that all values in the column are different
    UNIQUE(First_Name)
);

INSERT INTO Actor (First_Name, Last_Name) VALUES ('Hammad', 'Shaikh'), ('Sikandar', 'Bakht'), ('Samina', 'Memon');

-- the below query will give an error duplicate entry 'Hammad' for First_name
-- INSERT INTO Actor (First_Name, Last_Name) VALUES ('Hammad', 'Bakht');

SELECT * FROM Actor;
DESC Actor;


CREATE TABLE Movie(
	MovieID INT NOT NULL AUTO_INCREMENT,
    Name_Movie VARCHAR(100) NULL,
    
    ActorID INT,
    
    PRIMARY KEY(MovieID),
    -- here ActorID is the primary key of table Actor which is foreign key in Movie table
    CONSTRAINT Constraint_Movie FOREIGN KEY(ActorID) REFERENCES Actor(ActorID)
);

TRUNCATE TABLE Movie;
INSERT INTO Movie (Name_Movie, ActorID) VALUES ('SPIDER-MAN', 2), ('AVENGERS', 1), ('JAMES-BOND', 3);

DESC Movie;

SELECT a.First_Name, m.Name_Movie FROM Actor a INNER JOIN Movie m 
ON a.ActorID = m.ActorID;

ALTER TABLE Movie 
DROP CONSTRAINT Constraint_Movie;

SELECT * FROM Movie;

-- DROP TABLE Movie;

-- can also declare with CONSTRAINT CONSTRAINT_NAME CHECK(Age >= 18)
CREATE TABLE Person(
	PersonID INT NOT NULL AUTO_INCREMENT,
    Full_Name VARCHAR(100) NULL,
    Age INT NULL,
    
    PRIMARY KEY(PersonID),
	CHECK (Age >= 18)
);

INSERT INTO Person (Full_Name, Age)  VALUES ('Hammad Shaikh', 22), ('Kaivan Shah', 21), ('Priyam', 23);

-- the below query will give error as the check constraint is violated since age >= 18
-- INSERT INTO Person (Full_Name, Age)  VALUES ('Kajal Jha', 17);

SELECT * FROM Person;

-- used to add new check constraint to the existing table
ALTER TABLE Person
ADD CONSTRAINT Check_Person CHECK(LENGTH(Full_Name) >= 7);

-- used to drop the check constraint
ALTER TABLE Person
DROP CHECK Check_Person;

DELETE FROM Person WHERE Full_Name = 'Priyam';

DESC Person;



SELECT Full_Name FROM Person;



DESC Person;



DELETE FROM Person WHERE Full_Name = 'Joie';

SELECT * FROM Person;

ALTER TABLE Person
ADD CONSTRAINT Full_Name_Constraint CHECK(LENGTH(Full_Name) > 8);

-- the below query will result into error saying check constraint is violated
-- INSERT INTO Person (Full_Name, Age) VALUES ('Joie', 23);

DROP TABLE movie;


SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'movie' AND TABLE_SCHEMA = 'hammadb';


SELECT COLUMN_NAME, REFERENCED_COLUMN_NAME, REFERENCED_TABLE_NAME
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'movie' AND TABLE_SCHEMA = 'hammadb';

SELECT TABLE_NAME, TABLE_TYPE, ENGINE
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = 'hammadb';


DESC Movie;
SELECT * FROM Movie;


ALTER TABLE Movie
ADD CONSTRAINT Movie_Constraint CHECK(LENGTH(Name_Movie) > 5);

-- the below query will result into an error displaying check constraint violated
-- INSERT INTO Movie (Name_Movie, ActorID) VALUES ('JAWS', 2);

ALTER TABLE Movie
DROP CONSTRAINT Movie_Constraint;


-- parent table
CREATE TABLE Author(
	AuthorID INT NOT NULL AUTO_INCREMENT,
    Author_Name VARCHAR(255) NULL,
    Author_Age INT NULL,
    
    PRIMARY KEY(AuthorID),
    CONSTRAINT UNIQUE_AUTHOR_NAME UNIQUE(Author_Name)
);

DESC Author;

INSERT INTO Author (Author_Name, Author_Age) VALUES ("Hammad", 22), ("Sikandar", 63), ("Samina", 52);

SELECT * FROM Author;


-- child table
CREATE TABLE Books(
	BookID INT NOT NULL AUTO_INCREMENT,
    Book_Name VARCHAR(255) NULL,
    Book_Price INT NULL,
    AuthorID INT,
    
    PRIMARY KEY(BookID),
    CONSTRAINT FOREIGN KEY(AuthorID) REFERENCES Author(AuthorID)
	-- if there is a deletion/update in the parent table then the child table gets also affected
    -- i.e the row which is deleted/updated in the parent table will also get deleted/updated in child table
	-- it is a foreign key constraint
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

DESC Books;

INSERT INTO Books (Book_Name, Book_Price, AuthorID) VALUES ("Java", 3000, 2), ("C++", 2000, 1), ("Python", 1000, 3);

DROP TABLE Books;

SELECT * FROM Books;

DELETE FROM Author WHERE AuthorID = 2;

UPDATE Author SET Author_Name = "Mittu" WHERE AuthorID = 3;

-- we explicity change the author id in the parent table and it gets automatically changed in the child table
UPDATE Author SET AuthorID = 5  WHERE AuthorID = 3;

CREATE TABLE Parent(
	ParentID INT NOT NULL AUTO_INCREMENT,
    Parent_Name VARCHAR(255) NULL,
    
    PRIMARY KEY(ParentID),
    CONSTRAINT UNIQUE_PARENT_NAME UNIQUE(Parent_Name)
);


INSERT INTO Parent (Parent_Name) VALUES ("Sikandar"), ("Ronaldo"), ("Federer");

SELECT * FROM Parent ORDER BY ParentID;

CREATE TABLE Child(
	ChildID INT NOT NULL AUTO_INCREMENT,
    Child_Name VARCHAR(255) NULL,
    ParentID INT,
    
    PRIMARY KEY(ChildID),
    CONSTRAINT FOREIGN KEY(ParentID) REFERENCES Parent(ParentID)
	
    -- it prevents any deletion/update of row from the parent table
    -- if any column is a foreign key in another table (child table)
    -- it is a foreign key constraint
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

INSERT INTO Child (Child_Name, ParentID) VALUES ("Hammad", 1), ("Junior", 2), ("Twins", 3);

-- the below queries would give an error displaying cannot delete or update a parent row
-- foreign key constraint fails
DELETE FROM Parent WHERE Parent_Name = 'Sikandar';
UPDATE Parent SET ParentID = 5 WHERE ParentID = 2;




