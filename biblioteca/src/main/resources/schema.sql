CREATE DATABASE biblioteca;
USE biblioteca;
CREATE TABLE Bi_EstadoLibros(
    estaId int(10) NOT NULL,
    PRIMARY KEY (estaId),
    estaDescripcion varchar(255) NOT NULL

);

CREATE TABLE Bi_libros(
    LibCons int(10) NOT NULL,
    PRIMARY KEY (LibCons),
    LibDesc varchar(255) NOT NULL,
    LibEsta int(10) NOT NULL
);
CREATE TABLE Bi_TiposUsuarios(
    tipoCons int(10) NOT NULL,
    PRIMARY KEY (tipoCons),
    tipodesc varchar(255) NOT NULL
);
CREATE TABLE Bi_Usuarios(
    usuacons int(10) NOT NULL,
    PRIMARY KEY (usuacons),
    usuaId int(10) NOT NULL,
    usuaNomb varchar(255),
    usuaTipo int(10) NOT NULL,
    FOREIGN KEY (usuaTipo) REFERENCES Bi_TiposUsuarios(tipoCons),
    usuaEstado  int(10) NOT NULL,
	FOREIGN KEY (usuaEstado) REFERENCES Bi_EstadoLibros(estaId)
);

CREATE TABLE Bi_Prestamos(
    Prescons int(10) NOT NULL,
    PRIMARY KEY (Prescons),
    presIsbn int(10) NOT NULL,
    FOREIGN KEY (presIsbn) REFERENCES Bi_libros(LibCons),
    presIdUsuario int(10) NOT NULL,
    FOREIGN KEY (presIdUsuario) REFERENCES Bi_Usuarios(usuacons),
    presfechaPrestamo Date,
    presFechaEntrega Date
);