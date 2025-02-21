-- V1__create_customer_and_order_tables.sql
CREATE TABLE customer
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE orders
(
    id          SERIAL PRIMARY KEY,
    product_id  BIGINT   NOT NULL REFERENCES product (id),
    amount      DECIMAL(10, 2) NOT NULL,
    customer_id BIGINT         NOT NULL REFERENCES customer (id)
);