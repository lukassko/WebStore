
SET FOREIGN_KEY_CHECKS=0;

INSERT IGNORE INTO category VALUES (1, 'Film');
INSERT IGNORE INTO category VALUES (2, 'Book');

INSERT IGNORE INTO product (id, name, price, category_id) VALUES (1, 'Superman',19.99 ,1);
INSERT IGNORE INTO product (id, name, price, category_id) VALUES (2, 'Wikings', 29.99, 1);
INSERT IGNORE INTO product (id, name, price, category_id) VALUES (3, 'Game', 18.99, 2);
INSERT IGNORE INTO product (id, name, price, category_id) VALUES (4, 'Sheep', 39.99, 2);

INSERT IGNORE INTO client VALUES (1, 'Lukasz', 'Szczepanski', 'lukasz@gmail.com', 'szczepek', 'USER');

INSERT IGNORE INTO orders VALUES (1 ,'2016-05-26', 29.99,1 );
INSERT IGNORE INTO orders VALUES (2 ,'2016-05-29', 29.99,1 );
INSERT IGNORE INTO orders VALUES (3 ,'2016-05-30', 29.99,1 );
INSERT IGNORE INTO orders VALUES (4 ,'2016-06-29', 29.99,1 );

INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (1, 1);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (1, 2);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (1, 3);

INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (2, 1);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (2, 4);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (2, 3);

INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (3, 1);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (3, 2);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (3, 4);

INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (4, 1);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (4, 3);
INSERT IGNORE INTO shopping_cart(order_id, product_id) VALUES (4, 2);