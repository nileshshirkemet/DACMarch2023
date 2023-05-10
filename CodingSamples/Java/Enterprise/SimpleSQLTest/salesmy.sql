DROP DATABASE IF EXISTS sales;
CREATE DATABASE sales;
USE sales;

CREATE TABLE `counters` (
  `ctr_name` varchar(8) NOT NULL,
  `cur_val` int NOT NULL,
  PRIMARY KEY (`ctr_name`)
);
INSERT INTO `counters` VALUES ('orders',4),('products',4);

CREATE TABLE `customers` (
  `cust_id` varchar(8) NOT NULL,
  `pwd` varchar(16) NOT NULL,
  `email` varchar(32) NOT NULL,
  `credit` double DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
);
INSERT INTO `customers` VALUES ('CU301','PWD301','cu301@met.edu',1000),('CU302','PWD302','cu302@met.edu',2000),('CU303','PWD303','cu303@met.edu',3000);

CREATE TABLE `products` (
  `pno` int NOT NULL,
  `price` double NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`pno`),
  CONSTRAINT `products_stock_chk` CHECK ((`stock` >= 0))
);
INSERT INTO `products` VALUES (301,550.65,95),(302,827.45,75),(303,243.15,65),(304,685.35,55);

CREATE TABLE `orders` (
  `ord_no` int NOT NULL,
  `ord_date` date NOT NULL,
  `cust_id` varchar(8) NOT  NULL,
  `pno` int NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`ord_no`),
  CONSTRAINT `orders_customers_fk` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`cust_id`),
  CONSTRAINT `orders_products_fk` FOREIGN KEY (`pno`) REFERENCES `products` (`pno`),
  CONSTRAINT `orders_qty_chk` CHECK ((`qty` > 0))
);
INSERT INTO `orders` VALUES (1001,'2020-01-12','CU301',302,5),(1002,'2020-01-12','CU302',303,8),(1003,'2020-01-12','CU303',301,3),(1004,'2020-04-15','CU301',304,3);

DELIMITER $$
CREATE PROCEDURE place_order(IN customer varchar(8), IN product int, IN quantity int, OUT orderno int)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		RESIGNAL;
	END;
	START TRANSACTION;
	UPDATE counters SET cur_val=cur_val+1 WHERE ctr_name='orders';
	SELECT cur_val+ 1000 INTO orderno FROM counters WHERE ctr_name='orders';
	INSERT INTO orders VALUES(orderno, SYSDATE(), customer, product, quantity);
	COMMIT;
END$$
DELIMITER ;

CREATE VIEW invoices AS 
SELECT o.ord_no, o.ord_date, o.cust_id, o.pno, o.qty, o.qty * p.price amt 
FROM orders o INNER JOIN products p 
ON o.pno = p.pno;



