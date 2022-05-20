-- Insertando algunos registros para que la base de datos no este vacia

INSERT INTO USER (id,firstName,lastName,password,EMAIL,USER_TYPE) VALUES (1,'Jose Ramon','Porro Nieves','hola','joserra@comillas.edu','STANDARD');
INSERT INTO USER (id,firstName,lastName,password,EMAIL,USER_TYPE) VALUES (2,'Carlota','Ciruelos','hola','carlota@comillas.edu','STANDARD');

INSERT INTO ACCOUNT (id,IBAN,balance,USER_TYPE) VALUES (1,'ES21000000000000000',100.5,'STANDARD');
INSERT INTO ACCOUNT (id,IBAN,balance,USER_TYPE) VALUES (2,'ES21000000000000001',10,'STANDARD');

INSERT INTO ACCOUNT_USER (id,account_id,user_id) VALUES (1,1,1);

INSERT INTO TRANSACTION (id,origin_acc,destination_acc,amount) VALUES (1,1,2,6);

INSERT INTO FEES (USER_TYPE,fee_amount) VALUES ('STANDARD',5);
