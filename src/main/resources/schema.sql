DROP TABLE IF EXISTS "USERS";

create table "USER" (
    "id" integer identity NOT NULL primary key,
    "dni" VARCHAR(10) NOT NULL,
    "firstName" VARCHAR(45) NOT NULL,
    "lastName" VARCHAR(45) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "EMAIL" VARCHAR(100),
    "USER_TYPE" VARCHAR(45)
);

DROP TABLE IF EXISTS "ACCOUNT";

create table "ACCOUNT" (
    "id" integer identity NOT NULL primary key,
    "IBAN" VARCHAR(45) NOT NULL,
    "balance" float NOT NULL,
    "USER_TYPE" VARCHAR(45)
);

DROP TABLE IF EXISTS "ACCOUNT_USER";

create table "ACCOUNT_USER" (
                         "id" integer identity primary key,
                         "A_ID" number NOT NULL,
                         "U_ID" number NOT NULL
);

DROP TABLE IF EXISTS "TRANSACTION";

create table "TRANSACTION" (
                              "id" integer identity primary key,
                              "origin_acc" integer NOT NULL,
                              "destination_acc" integer NOT NULL,
                              "amount" integer NOT NULL,
                              "DATE" DATE NOT NULL
);

DROP TABLE IF EXISTS "FEES";

create table "FEES" (
                             "id" integer identity primary key,
                             "USER_TYPE" VARCHAR(45) NOT NULL,
                             "fee_amount" integer NOT NULL,
                             "COMMENT" VARCHAR(100) NOT NULL

);