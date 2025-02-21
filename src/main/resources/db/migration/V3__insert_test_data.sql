

INSERT INTO product (name, price)
VALUES ('Samsung', 10000),
       ('Lenovo', 8000),
       ('LG', 6000);

INSERT INTO customer (name, email)
VALUES ('John Doe', 'john@example.com'),
       ('Jane Smith', 'jane@example.com');

INSERT INTO orders (product_id, amount, customer_id)
VALUES (1, 1200.00, 1),
       (2, 800.00, 1),
       (3, 500.00, 2);