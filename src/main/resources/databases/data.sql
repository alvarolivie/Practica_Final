INSERT INTO PEDIDO VALUES (1, 'alvarolivie@gmail.com','Alvaro Olivie', '670986614', 10, 1, '2022-10-31', 'CENA', 'Madrid', 'velazquez 112', 0.0, 'PENDIENTE');
INSERT INTO PEDIDO VALUES (2, 'aledelarica@gmail.com','Ale', '654986614', 20, 2, '2022-10-20', 'COMIDA', 'Santander', 'calle 3, piso 2', 0.0, 'RECHAZADA');
INSERT INTO PEDIDO VALUES (3, 'BrunoSanJuan@gmail.com','B.S.J', '671234514', 40, 3, '2022-8-31', 'CENA', 'Madrid', 'serrano 41', 45.20, 'ACEPTADA');

INSERT INTO USER VALUES('alvaro', '$2y$10$6MKdJIP31RsHkp9XwGXX8ew8N8cN9wtEf3qRrDIm6fsFcYXN3LXpW');
INSERT INTO USER VALUES('aleja', '$2y$10$XKHIuEMxTGKk5bCq7R.tn.UolCFuz4rXt.1cUVdsqnj7clAPLLqTe');
INSERT INTO USER VALUES('bruno', '$2y$10$neImUnDSYLZnuqeztYEc8emyhliHeN7q.FHw7dJ0ij3LktX0j5G4K');
INSERT INTO USER VALUES('truñez', '$2y$10$WrR0Uk6apY1./saqsL72yuE.hYm7uoAzdI959kSd6oxaRDz9oAnpW');

INSERT INTO ROLE VALUES(1,'VerDatos', 'El usuario solo puede ver los datos de los pedidos');
INSERT INTO ROLE VALUES(2, 'AceptarRechazar', 'El usuario puede aceptar o rechazar los distintos pedidos');
INSERT INTO ROLE VALUES(3,'EditarDatos', 'El usuario puede editar los datos de cada pedido');
INSERT INTO ROLE VALUES(4,'AñadirPedido', 'El usuario puede crear un pedido nuevo');

INSERT INTO USER_ROLE VALUES('alvaro', 1);
INSERT INTO USER_ROLE VALUES('alvaro', 2);
INSERT INTO USER_ROLE VALUES('alvaro', 3);
INSERT INTO USER_ROLE VALUES('aleja', 1);
INSERT INTO USER_ROLE VALUES('aleja', 2);
INSERT INTO USER_ROLE VALUES ('aleja', 4);
INSERT INTO USER_ROLE VALUES('bruno', 1);
INSERT INTO USER_ROLE VALUES('truñez', 1);
INSERT INTO USER_ROLE VALUES('truñez', 2);
INSERT INTO USER_ROLE VALUES ('truñez', 4);
INSERT INTO USER_ROLE VALUES ('truñez', 3);

INSERT INTO ARROCES VALUES(1,'Arroz clasico El Peroli','Este arroz fue un éxito desde el primer dia que lo hicimos con amigos. Es un arroz con secreto ibérico y morcilla con un poco de miel. Una mezcla rara que sorprende','80 gr arroz, 50 gr secreto iberico, 50 gr morcilla, 20 ml miel, 75 ml vino tinto, 100 gr sofrito');
INSERT INTO ARROCES VALUES(2,'Arroz a la Mar','Siempre decimos que lo importante es el producto, en este arroz es necesario. Con estos arroces solemos bajar al puerto de pedreña donde vemos que han cogido ese dia y elegimos en el momento','80 gr arroz, 100 gr marisco variado, 75 ml vino blanco, 100 ml caldo de pescado/carabinero, 50 gr sofrito');
INSERT INTO ARROCES VALUES(3,'Arroz del campo','Este arroz es el mismo arroz que tomas un dia de primavera en el campo. LLeva verduras variadas y una pieza de carne como liebre o conejo. Un arroz un poco mas tradicional.','80 gr arroz, 100 gr sofrito, 100 ml caldo de pollo, 50 gr conejo');