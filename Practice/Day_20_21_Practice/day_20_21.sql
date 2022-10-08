USE hammadb;

CREATE TABLE Customer(
	CustomerID INT NOT NULL,
    Customer_Name VARCHAR(255) NULL,
    City VARCHAR(255) NULL,
    
    PRIMARY KEY (CustomerID),
    UNIQUE (Customer_Name)
);

ALTER TABLE Customer
MODIFY CustomerID INT NOT NULL AUTO_INCREMENT;

DESC Customer;

INSERT INTO Customer (Customer_Name, City) VALUES ('Hammad', 'Mumbai'), ('Kaivan', 'Mumbai'), ('Gauri', 'UP'), ('Kajal', 'UP');

SELECT * FROM Customer;

-- self join 
SELECT  c1.Customer_Name AS Customer1, c2.Customer_Name AS Customer2
FROM  Customer c1, Customer c2
WHERE c1.CustomerID <> c2.CustomerID AND c1.City = c2.City;


-- partitioning
-- for range and list partitioning the expression should return an integer value
-- for column partitioning it could return result of any type like varchar (string)
CREATE TABLE Friend(
	FriendID INT NOT NULL,
    Friend_Name VARCHAR(255),
    Age INT
)
-- partition by range using values less than operator
PARTITION BY  RANGE (Age)(
	PARTITION P0 VALUES LESS THAN (10),
    PARTITION P1 VALUES LESS THAN (25),
    PARTITION P2 VALUES LESS THAN (40),
    PARTITION P3 VALUES LESS THAN (60)
);

INSERT INTO Friend(FriendID, Friend_Name, Age) VALUES (1, 'Hammad', 22), (2, 'Sikandar', 58), (3, 'Mittu', 8), (4, 'Samina','38');

INSERT INTO Friend(FriendID, Friend_Name, Age) VALUES (5, 'Kaivan', 35);
INSERT INTO Friend(FriendID, Friend_Name, Age) VALUES (6, 'Gauri', 42);

SELECT * FROM Friend;

-- for displaying the partitions using information_schema
SELECT PARTITION_NAME, PARTITION_EXPRESSION, PARTITION_DESCRIPTION 
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_SCHEMA = 'hammadb' AND TABLE_NAME = 'Friend';

-- for displaying a particular partition by name
SELECT * FROM Friend PARTITION(P2);
SELECT * FROM Friend PARTITION(P3);


-- partition by list
-- every unique key on the table must use every column in the table's partitioning expression
CREATE TABLE Citizen(
	CitizenID INT NOT NULL,
    CitizenName VARCHAR(255) NULL,
    AreaCode INT,
    
    UNIQUE (CitizenName, AreaCode),
    PRIMARY KEY (CitizenID, AreaCode)
)

PARTITION BY LIST (AreaCode)(
	PARTITION Thane VALUES IN (401107, 401105, 401106),
    PARTITION Mumbai VALUES IN (401150, 401151, 401152),
    PARTITION Navi_Mumbai  VALUES IN (401130, 401131, 401132)
);

INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (1, 'Hammad',  401107);
INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (2, 'Samina',  401105);
INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (3, 'Sikandar',  401105);

INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (4, 'Gauri',  401130);
INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (5, 'Kajal',  401131);
INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (6, 'Sandipt',  401132);

INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (7, 'Abhishek',  401150);
INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (8, 'Pravendra',  401151);
INSERT INTO Citizen (CitizenID, CitizenName, AreaCode) VALUES (9, 'Arpit',  401152);

SELECT * FROM Citizen;

SELECT * FROM Citizen PARTITION (Thane);
SELECT * FROM Citizen PARTITION (Navi_Mumbai);

-- column partitioning (by range)
-- in this we can add multiple columns in the partitioning expression
CREATE TABLE Square(
	Num INT,
    Res INT, 
	
    UNIQUE (Num, Res)
)

PARTITION BY RANGE COLUMNS (Num, Res)(
	PARTITION P1 VALUES LESS THAN (11, 101),
    PARTITION P2 VALUES LESS THAN (21, 401),
    PARTITION P3 VALUES LESS THAN (31, 901),
    PARTITION P4 VALUES LESS THAN (MAXVALUE, MAXVALUE)
);

DESC Square;

INSERT INTO Square (Num, Res) VALUES (1,1), (2,4), (5,25), (7,49), (10, 100);
INSERT INTO Square (Num, Res) VALUES (11,121), (12,144), (15,225), (17,289), (19, 361);
INSERT INTO Square (Num, Res) VALUES (21,441), (25,625), (27,729), (29,841), (30, 900);
INSERT INTO Square (Num, Res) VALUES (40,1600);


DELETE FROM Square WHERE Num = 30;

SELECT * FROM Square PARTITION (P1);
SELECT * FROM Square PARTITION (P3);
SELECT * FROM Square PARTITION (P4);

-- hash partitioning (done implicitly)
-- here also the expression should return an integer value
-- the partition number is calculated using the function mod(expr, num_of_partitions)
-- in our case since total partitions are 3 so partition numbers would be 0,1,2
-- and the row will be inserted automatically in the partition
CREATE TABLE Product(
	ProductID INT NOT NULL,
    ProductName VARCHAR(255),
    Price INT, 
    
    PRIMARY KEY (ProductID, Price),
    UNIQUE (ProductName, Price)
)

PARTITION BY HASH (Price)
PARTITIONS 3;


INSERT INTO Product (ProductID, ProductName, Price) VALUES (1, 'Shampoo', 200), (2, 'FaceWash', 500), (3, 'BodyWash', 1000);
INSERT INTO Product (ProductID, ProductName, Price) VALUES (4, 'Blender', 1200), (5, 'Trimmer', 1400), (6, 'Earbud', 2000);
INSERT INTO Product (ProductID, ProductName, Price) VALUES (7, 'Powerbank', 2500), (8, 'HeadPhones', 2700), (9, 'FireStick', 2900);

-- blender and headphones will give a result of 0 and would be inserted in the first partition
SELECT * FROM Product PARTITION(P0);
SELECT * FROM Product PARTITION(P1);
SELECT * FROM Product PARTITION(P2);


-- 