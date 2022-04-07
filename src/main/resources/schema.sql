DROP TABLE IF EXISTS PEDIDOS;
CREATE TABLE PEDIDOS (
                          ID INTEGER IDENTITY PRIMARY KEY,
                          FIELD1 VARCHAR(255) NOT NULL,
                          FIELD2 NUMERIC NOT NULL,
                          MY_DATE DATE NOT NULL,
                          MY_TIME TIME NOT NULL,
                          FLAG BOOLEAN NOT NULL
);