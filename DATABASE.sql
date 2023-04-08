﻿CREATE DATABASE AGILE_PROJECT

CREATE TABLE LOGIN (
	USERNAME NVARCHAR(50) NOT NULL,
	PASSWORD_USER VARCHAR(16) NOT NULL,
	PRIMARY KEY (USERNAME)
);

CREATE TABLE PRODUCT_MANAGEMENT (
	ID_PRODUCT VARCHAR(30) NOT NULL,
	NAME_PRODUCT NVARCHAR(255) NOT NULL,
	UNIT_PRICE INT NOT NULL,
	QUANTITY INT NOT NULL,
	REVENUE INT NOT NULL,
	DATE_PRO DATETIME NOT NULL
	PRIMARY KEY (ID_PRODUCT)
);

CREATE TABLE CALCULATE (
	ID_PRODUCT VARCHAR(30) REFERENCES PRODUCT_MANAGEMENT(ID_PRODUCT) NOT NULL,
	NAME_PRODUCT NVARCHAR(255) NOT NULL,
	QUANTITY INT NOT NULL,
	UNIT_PRICE INT NOT NULL,
	TOTAL INT NOT NULL,
	PRIMARY KEY (ID_PRODUCT)
);

CREATE TABLE BILLINGDETAIL (
	ORDINAL_NUMBERS INT IDENTITY(1, 1) NOT NULL,
	ID_PRODUCT VARCHAR(30) REFERENCES PRODUCT_MANAGEMENT(ID_PRODUCT) NOT NULL,
	NAME_PRODUCT NVARCHAR(255) NOT NULL,
	QUANTITY INT NOT NULL,
	UNIT_PRICE INT NOT NULL,
	TOTAL INT NOT NULL,
	PRIMARY KEY (ORDINAL_NUMBERS)
);


INSERT INTO LOGIN VALUES(N'Lê Danh Hiếu', '12345678')
INSERT INTO LOGIN VALUES(N'Phạm Hiểu Phong', '88888888')
INSERT INTO LOGIN VALUES(N'Kim Oanh', '99999999')
INSERT INTO LOGIN VALUES(N'Trọng Đạt', '34343434')
INSERT INTO LOGIN VALUES(N'Tùng Dương', '16161616')
INSERT INTO LOGIN VALUES(N'Ha Nam', '999999999')

SELECT * FROM LOGIN
 
INSERT INTO PRODUCT_MANAGEMENT VALUES('BB', N'Bim Bim Ostar', 7000, 20, 35000 ,CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('VE', N'Rau cải thìa 300 gam', 10000, 10, 20000,CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('TS', N'Áo phông', 200000, 10, 800000, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('JE', N'Quần JEANS', 150000, 15, 900000, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('MI', N'Sữa tươi Vinamilk 1 lít', 100000, 5, 200000,CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('CA', N'Bánh Chocopie', 46000, 12, 92000, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('CO', N'Coca Cola 1,5 lít', 17000, 18, 34000, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('BE', N'Hộp thịt bò 500 gam', 150000, 5, 150000, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('ME', N'Hộp thịt heo 500 gam', 50000, 8, 150000, CURRENT_TIMESTAMP);
INSERT INTO PRODUCT_MANAGEMENT VALUES('FA', N'Sữa Family hộp 200 ml', 5000, 24, 20000, CURRENT_TIMESTAMP);


SELECT * FROM PRODUCT_MANAGEMENT 
WHERE DATE_PRO < '2023-04-08 01:32:14.420' AND DATE_PRO > '2023-04-05 01:32:14.420'
ORDER BY REVENUE ASC


SELECT P.NAME_PRODUCT, P.UNIT_PRICE FROM PRODUCT_MANAGEMENT P
WHERE P.ID_PRODUCT = 'FA'

SELECT TOP 1 ID_PRODUCT, NAME_PRODUCT FROM BILLINGDETAIL
GROUP BY ID_PRODUCT, NAME_PRODUCT
ORDER BY SUM(TOTAL) DESC

INSERT INTO CALCULATE VALUES ('FA'
,(SELECT P.NAME_PRODUCT FROM PRODUCT_MANAGEMENT P WHERE P.ID_PRODUCT = 'FA')
, 3
, (SELECT P.UNIT_PRICE FROM PRODUCT_MANAGEMENT P WHERE P.ID_PRODUCT = 'FA')
, 3 * (SELECT P.UNIT_PRICE FROM PRODUCT_MANAGEMENT P WHERE P.ID_PRODUCT = 'FA'));
 

 SELECT * FROM CALCULATE

 SELECT * FROM PRODUCT_MANAGEMENT 

 DELETE FROM CALCULATE WHERE ID_PRODUCT = 'BB'
 DELETE FROM PRODUCT_MANAGEMENT WHERE ID_PRODUCT = 'CO'

 SELECT TOP 1 * FROM CALCULATE ORDER BY TOTAL DESC

 SELECT C.ID_PRODUCT, P.QUANTITY - C.QUANTITY
FROM PRODUCT_MANAGEMENT P
 INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT


  SELECT P.REVENUE + C.TOTAL
FROM PRODUCT_MANAGEMENT P
 INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT

 UPDATE PRODUCT_MANAGEMENT
 SET QUANTITY = ( SELECT P.QUANTITY - C.QUANTITY
				FROM PRODUCT_MANAGEMENT P
				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT
				WHERE P.ID_PRODUCT = 'ME' 
				),
	REVENUE = ( SELECT P.REVENUE + C.TOTAL
				FROM PRODUCT_MANAGEMENT P
				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT
				WHERE P.ID_PRODUCT = 'ME'
				 ),
	DATE_PRO = GETDATE()
WHERE ID_PRODUCT = 'ME' 

DELETE FROM CALCULATE

 UPDATE PRODUCT_MANAGEMENT
 SET QUANTITY = ( SELECT P.QUANTITY + C.QUANTITY
				FROM PRODUCT_MANAGEMENT P
				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT
				WHERE P.ID_PRODUCT = 'ME' 
				),
	REVENUE = ( SELECT P.REVENUE - C.TOTAL
				FROM PRODUCT_MANAGEMENT P
				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT
				WHERE P.ID_PRODUCT = 'ME'
				 ),
	DATE_PRO = GETDATE()
WHERE ID_PRODUCT = 'ME' 

SELECT * FROM PRODUCT_MANAGEMENT 
WHERE (DATE_PRO > CAST('2023-04-01' AS DATETIME) or DATE_PRO = CAST('2023-04-01' AS DATETIME)) 
	AND (DATE_PRO < CAST('2023-04-09' AS DATETIME) or DATE_PRO = CAST('2023-04-09' AS DATETIME))
ORDER BY REVENUE desc
