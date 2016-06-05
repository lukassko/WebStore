
INSERT IGNORE INTO category VALUES (1, 'Film');
INSERT IGNORE INTO category VALUES (2, 'Book');

INSERT IGNORE INTO product VALUES (1, 'Superman', 1, 19.99);
INSERT IGNORE INTO product VALUES (2, 'Wikings', 1, 29.99);
INSERT IGNORE INTO product VALUES (3, 'Game', 2, 18.99);
INSERT IGNORE INTO product VALUES (4, 'Sheep', 2, 39.99);

INSERT IGNORE INTO client VALUES (1, 'Lukasz', 'Szczepanski', 'lukasz@gmail.com', 'szczepek');

INSERT IGNORE INTO orders VALUES (1, '2016-05-26', 29.99 ,1 );

INSERT IGNORE INTO shopping_cart VALUES (1, 1);
INSERT IGNORE INTO shopping_cart VALUES (1, 2);
INSERT IGNORE INTO shopping_cart VALUES (1, 3);