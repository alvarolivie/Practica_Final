INSERT INTO PEDIDO VALUES (1, 'alvarolivie@gmail.com','Alvaro Olivie', '670986614', 10, 1, '2022-10-31', 'CENA', 'Madrid', 'velazquez 112', 0.0, 'PENDIENTE');
INSERT INTO PEDIDO VALUES (2, 'aledelarica@gmail.com','Ale', '654986614', 20, 2, '2022-10-20', 'COMIDA', 'Santander', 'calle 3, piso 2', 0.0, 'RECHAZADA');
INSERT INTO PEDIDO VALUES (3, 'BrunoSanJuan@gmail.com','B.S.J', '671234514', 40, 3, '2022-8-31', 'CENA', 'Madrid', 'serrano 41', 45.20, 'ACEPTADA');

INSERT INTO USER VALUES('alvaro', 'alvaro123');
INSERT INTO USER VALUES('aleja', 'ale123456');
INSERT INTO USER VALUES('bruno', 'bruno1234');

INSERT INTO ROLE VALUES(1,'VerDatos', 'El usuario solo puede ver los datos de los pedidos');
INSERT INTO ROLE VALUES(2, 'AceptarRechazar', 'El usuario puede aceptar o rechazar los distintos pedidos');
INSERT INTO ROLE VALUES(3,'EditarDatos', 'El usuario puede editar los datos de cada pedido');

INSERT INTO USER_ROLE VALUES('alvaro', 1);
INSERT INTO USER_ROLE VALUES('alvaro', 2);
INSERT INTO USER_ROLE VALUES('alvaro', 3);
INSERT INTO USER_ROLE VALUES('aleja', 1);
INSERT INTO USER_ROLE VALUES('aleja', 2);
INSERT INTO USER_ROLE VALUES('bruno', 1);