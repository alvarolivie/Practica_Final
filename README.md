# Practica_Final

##FrontEnd

La página esta dividida en dos secciones de cara al usuario. Tienes lo que ve el cliente que es una página
página con multiples vistas donde puede llegar hasta la página de solicitar un pedido y la otra cara es un gestor de 
pedidos para el dueño de la empresa.

###Cliente
El cliente tiene multiples vistas para aprender sobre la empresa. Estas se pueden navegar mediante la barra de navegacion
en la parte superior de la página. Una vez entra en solicitar un pedido, podra elegir entre 
tres opciones. Tras elegir una de esas tres opciones se le cargará la primera parte del formulario. Este formulario varia
en funcion de la opcion elegida. Se va validando el formulario para que cuando el usuario mande el pedido, este no falle. 
Se confirma si se ha mandado el pedido y se vuelve a una página de inicio.

###Dueño

El dueño puede acceder a una página desde la pantalla inicial donde podra identificarse, hay multiples usuarios disponibles,
cada uno con unos permisos distintos. Una vez identificado el usuario, este podra ver la tabla de pedidos. Si sus permisos 
se lo permiten, podra editar, aceptar/rechazar y añadir pedidos. 

Los usuarios disponibles son los siguientes:
- alvaro, alvaro123
- aleja, ale123456
- bruno, bruno1234

##BackEnd

El backend empieza con 5 tablas relacionadas entre sí. Tenemos la tabla de pedidos que se relaciona mediante la columna arroz con
la tabla Arroces que a su vez contiene la informacion sobre los arroces que hacemos. La tabla User guarda el usuario y la contraseña
y se relaciona con una tabla intermedia User_Roles mediante el nombre de usuario. Esta tabla intermedia también se relaciona mediante 
el role_id con la última tabla Role que guarda los distintos roles. La tabla intermedia es necesaria, ya que es una relacion Many to Many
que hace uso de esta tabla intermedia para funcionar. Las Tablas tienen su contrapartida en java, en el paquete model donde se han descrito
las distintas clases a usar.

Estas Tablas se relacionan usando JDBC con la capa repository. Esta capa es capaz de hacer query's a la base de datos y devolver la informacion
de una manera en la cual java pueda trabajar con ella.

La capa service se encarga de gestionar los datos entre los endpoints y la base de datos que hace uso de la capa repository. Esta
capa se encarga de poner los datos limpios, recoger los datos buscados y devolverlos de una manera en la que la capa controller
pueda mandarlos de vuelta al usuario.

La capa controller es la última en el modelo y es la que registra los endpoints que vamos a poder usar. Cada recurso tiene su propio
controller para distinguir asi mejor cada endpoint. El controller para el cliente solo tiene un metodo que manda un pedido nuevo, en 
cambio el controller del Owner tiene muchos más, ya que tiene más necesidades. 

Estos endpoint están asegurados mediante Spring Security. Hemos añadido un control de acceso a todos los endpoints menos al de cliente.
También hemos restringido el acceso a la página que gestiona los pedidos. Para asegurarnos de que la contraseña es segura, la hemos 
encriptado usando bcrypt. 

