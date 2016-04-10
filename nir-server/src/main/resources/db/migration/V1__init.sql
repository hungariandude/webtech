-- MODEL

CREATE TABLE customer (
    customer_id bigint NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    
    PRIMARY KEY (customer_id)
);

CREATE TABLE product (
    product_id bigint NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    description varchar(500),
    stock_quantity int NOT NULL,
    sale_price double precision NOT NULL,
    
    PRIMARY KEY (product_id)
);

CREATE TABLE sale (
    sale_id bigint NOT NULL AUTO_INCREMENT,
    product_id bigint NOT NULL,
    customer_id bigint NOT NULL,
    quantity int NOT NULL,
    price double precision NOT NULL,
    sale_date timestamp NOT NULL,
    
    PRIMARY KEY (sale_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

-- DATA

INSERT INTO customer (name, address) VALUES ('Kis Attila', '1000 Tesztváros, Teszt utca 1');
INSERT INTO customer (name, address) VALUES ('Nagy Gábor', '1000 Tesztváros, Teszt utca 2');
INSERT INTO customer (name, address) VALUES ('Kovács Béla', '1000 Tesztváros, Teszt utca 3');

INSERT INTO product (name, description, stock_quantity, sale_price) VALUES ('HDD', 'Hard Disk Drive', 10, 1000);
INSERT INTO product (name, description, stock_quantity, sale_price) VALUES ('CPU', 'Central Processing Unit', 10, 2000);
INSERT INTO product (name, description, stock_quantity, sale_price) VALUES ('VGA', 'Video Graphics Adapter', 10, 3000);
