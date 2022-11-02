DROP TABLE IF EXISTS account;

CREATE TABLE account
(
    username  VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname  VARCHAR(255) NOT NULL
);