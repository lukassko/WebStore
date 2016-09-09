CREATE DATABASE IF NOT EXISTS webstore;
GRANT ALL PRIVILEGES ON webstore.* TO pc@localhost IDENTIFIED BY 'pc';

USE webstore;

CREATE TABLE IF NOT EXISTS category (
	id INT(4)  UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS product (
	id INT(4)  UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20),
	category_id INT(4) UNSIGNED NOT NULL,
	price DECIMAL(4,2),
	image longblob,
	INDEX(name),
	FOREIGN KEY (category_id) REFERENCES category(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS client (
	id INT(4)  UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(30),
 	last_name VARCHAR(30),
 	email VARCHAR(50),
 	password VARCHAR(50),
 	role VARCHAR(50),
 	INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS orders (
	id INT(4)  UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	client_id INT(4) UNSIGNED NOT NULL,
	date_order DATE,
	total_price DECIMAL(4,2),
	INDEX(client_id),
	FOREIGN KEY (client_id) REFERENCES client(id)
) engine=InnoDB;

--	quantity INT(4) UNSIGNED NOT NULL,
CREATE TABLE IF NOT EXISTS shopping_cart (
	order_id INT(4) UNSIGNED NOT NULL,
	product_id INT(4) UNSIGNED NOT NULL,
	INDEX(order_id),
	FOREIGN KEY (order_id) REFERENCES orders(id),
	FOREIGN KEY (product_id) REFERENCES product(id)
) engine=InnoDB;