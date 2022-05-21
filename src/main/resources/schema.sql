DROP TABLE IF EXISTS "USERS";

create table "USER" (
    "ID" integer identity NOT NULL primary key,
    "DNI" VARCHAR(10) NOT NULL,
    "FIRSTNAME" VARCHAR(45) NOT NULL,
    "LASTNAME" VARCHAR(45) NOT NULL,
    "PASSWORD" VARCHAR(255) NOT NULL,
    "EMAIL" VARCHAR(100),
    "USER_TYPE" VARCHAR(45)
);

DROP TABLE IF EXISTS "ACCOUNT";

create table "ACCOUNT" (
    "ID" integer identity NOT NULL primary key,
    "IBAN" VARCHAR(45) NOT NULL,
    "BALANCE" float NOT NULL,
    "USER_TYPE" VARCHAR(45)
);

DROP TABLE IF EXISTS "ACCOUNT_USER";

create table "ACCOUNT_USER" (
                         "ID" integer identity primary key,
                         "A_ID" number NOT NULL,
                         "U_ID" number NOT NULL
);

DROP TABLE IF EXISTS "TRANSACTION";

create table "TRANSACTION" (
                              "ID" integer identity primary key,
                              "ORIGIN_ACC" integer NOT NULL,
                              "DESTINATION_ACC" integer NOT NULL,
                              "AMOUNT" integer NOT NULL,
                              "DATE" DATE NOT NULL
);

DROP TABLE IF EXISTS "FEES";

create table "FEES" (
                             "ID" integer identity primary key,
                             "USER_TYPE" VARCHAR(45) NOT NULL,
                             "FEE_AMOUNT" integer NOT NULL,
                             "COMMENT" VARCHAR(100) NOT NULL

);