DROP TABLE IF EXISTS USERS;

create table USER (
    id integer identity primary key,
    firstName VARCHAR(45) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(100),
    USER_TYPE VARCHAR(45)
);

create table ACCOUNT (
    id integer identity primary key,
    IBAN VARCHAR(45) NOT NULL,
    balance float NOT NULL,
    USER_TYPE VARCHAR(45)
);

create table ACCOUNT_USER (
                         id integer identity primary key,
                         account_id integer,
                         user_id integer NOT NULL
);

create table TRANSACTION (
                              id integer identity primary key,
                              origin_acc integer NOT NULL,
                              destination_acc integer NOT NULL,
                              amount integer NOT NULL
);

create table FEES (
                             USER_TYPE VARCHAR(45) primary key,
                             fee_amount float NOT NULL
);