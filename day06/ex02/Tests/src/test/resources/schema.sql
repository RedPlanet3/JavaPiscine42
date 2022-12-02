
create schema if not exists chat;

CREATE TABLE Product (
    identifier INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(50) NULL,
	price INT NULL
);

