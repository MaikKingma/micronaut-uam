DROP TABLE IF EXISTS account_order;

CREATE TABLE account_order (
    username VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL
);