CREATE DATABASE Bookstore_bh;

--drop table books;
--drop table order_items;
--drop table orders;
--drop table users;


CREATE TABLE IF NOT EXISTS books
(
    id      BIGSERIAL   NOT NULL PRIMARY KEY,
    name    VARCHAR(64) NOT NULL UNIQUE,
    author  VARCHAR(64),
    isbn    VARCHAR(17),
    date    DATE,
    cost    NUMERIC,
    deleted BOOLEAN     NOT NULL DEFAULT FALSE
);


CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL   NOT NULL PRIMARY KEY,
    first_name VARCHAR(64) NOT NULL UNIQUE,
    last_name  VARCHAR(64),
    role       VARCHAR(64),
    password   VARCHAR(16),
    deleted    BOOLEAN     NOT NULL DEFAULT FALSE

);

CREATE TABLE orders
(
    id         BIGSERIAL PRIMARY KEY,
    status     VARCHAR(128)            NOT NULL,
    user_id    BIGINT REFERENCES users NOT NULL,
    total_cost NUMERIC(8, 2)           NOT NULL,
    deleted    BOOLEAN     NOT NULL DEFAULT FALSE
);

CREATE TABLE order_items
(
    id       BIGSERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES orders NOT NULL,
    book_id  BIGINT REFERENCES books  NOT NULL,
    quantity INT2                     NOT NULL,
    price    NUMERIC(6, 2)            NOT NULL
);