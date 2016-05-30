USE webstore;

CREATE TABLE category (
	id int primary key,
	name varchar(30)
)

CREATE TABLE product (
	id int NOT NULL,
	name varchar(30),
	category_id int NOT NULL,
	price money,
	primary key (id),
	foreign key (category_id) references category(id)

)

CREATE TABLE client (
	id int NOT NULL,
	first_name VARCHAR(30),
 	last_name VARCHAR(30),
 	email VARCHAR(50),
 	password VARCHAR(50),
	primary key (id),
) 

CREATE TABLE orders (
	id int NOT NULL,
	client_id INT NOT NULL,
	date_order DATE,
	total_price DECIMAL(4,2),
	primary key (id),
	FOREIGN KEY (client_id) REFERENCES client(id)
)

CREATE TABLE shopping_cart (
	id INT NOT NULL,
	order_id INT NOT NULL,
	product_id INT  NOT NULL,
	primary key (id),
	FOREIGN KEY (order_id) REFERENCES orders(id),
	FOREIGN KEY (product_id) REFERENCES product(id)
) 