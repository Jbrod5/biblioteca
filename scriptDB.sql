DROP DATABASE IF EXISTS biblioteca_database; 
CREATE DATABASE biblioteca_database; 
USE biblioteca_database;

-- Tablas de usuario -----------------------------------------
CREATE TABLE USUARIO(
    username VARCHAR(45) NOT NULL, 
    nombre VARCHAR(45) NOT NULL,
    tipo int NOT NULL,
    suspendido TINYINT(1),
    
    password VARCHAR(40) NOT NULL,
    PRIMARY KEY(username)
);

CREATE TABLE CLIENTE(
    username VARCHAR(45) NOT NULL,
    correo VARCHAR(45) NOT NULL,
    premium TINYINT(1),

    
    CONSTRAINT FK_CLIENTE_TO_USUARIO FOREIGN KEY(username) 
        REFERENCES USUARIO(username),
    PRIMARY KEY(username)
);

-- Tablas de biblioteca/libros --------------------------------

CREATE TABLE LIBROS(
    isbn VARCHAR(45) NOT NULL, 
    autor VARCHAR(45) NOT NULL,
    titulo VARCHAR(45) NOT NULL,
    editorial VARCHAR(45) NOT NULL, 
    costo INT NOT NULL,
    cantidad INT NOT NULL,

    PRIMARY KEY(isbn)
);

-- pendiente de aprobar ---------------------------------------------
CREATE TABLE INVENTARIO_LIBROS(
    isbn VARCHAR(45) NOT NULL,
    cantidad INT NOT NULL,

    CONSTRAINT FK_INVENTARIOLIBROS_TO_LIBROS FOREIGN KEY(isbn) 
        REFERENCES LIBROS(isbn),
    PRIMARY KEY(isbn)

);
-- -------------------------------------------------------------------

CREATE TABLE BIBLIOTECAS(
    id INT NOT NULL AUTO_INCREMENT,
    direccion VARCHAR(100),

    PRIMARY KEY(id)
);

CREATE TABLE INVENTARIO_BIBLIOTECA (
    id INT NOT NULL AUTO_INCREMENT, 
    cantidad_disponible INT NOT NULL,
    id_biblioteca INT NOT NULL,
    isbn VARCHAR(45) NOT NULL,

    CONSTRAINT FK_INVENTARIOBIBLIOTECA_TO_BIBLIOTECA FOREIGN KEY(id_biblioteca)
        REFERENCES BIBLIOTECAS(id),
    CONSTRAINT FK_INVENTARIOBIBLIOTECA_TO_LIBROS FOREIGN KEY(isbn)
        REFERENCES LIBROS(isbn),
    PRIMARY KEY(id)
);


-- Pruebas ---------------------------------------------

INSERT INTO USUARIO SET 
    username = "admin",
    nombre = "Administrador",
    tipo = 0, 
    password = "admin"
;

INSERT INTO BIBLIOTECAS SET
    direccion = "12 av 2 a"; 
;

INSERT INTO BIBLIOTECAS SET
    direccion = "p sherman "; 
;    

INSERT INTO BIBLIOTECAS SET
    direccion = "calle wallaby"; 
;


INSERT INTO BIBLIOTECAS SET
    direccion = "4 - 2 sidney"; 
;