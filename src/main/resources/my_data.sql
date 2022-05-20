-- Insertando algunos registros para que la base de datos no este vacia

INSERT INTO USER  VALUES (1,'Jose Ramon','Porro Nieves','hola','joserra@comillas.edu','STANDARD');
INSERT INTO USER  VALUES (2,'Carlota','Ciruelos','hola','carlota@comillas.edu','STANDARD');

INSERT INTO ACCOUNT VALUES (1,'ES21000000000000000',100.5,'STANDARD');
INSERT INTO ACCOUNT VALUES (2,'ES21000000000000001',10,'STANDARD');

INSERT INTO ACCOUNT_USER  VALUES (1,1,1);

INSERT INTO TRANSACTION (id,origin_acc,destination_acc,amount) VALUES (1,1,2,6);

INSERT INTO FEES (USER_TYPE,fee_amount) VALUES ('STANDARD',5);
