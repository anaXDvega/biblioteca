CREATE TABLE Bi_Tipos_Usuarios(
    tipocons int(10) NOT NULL,
    PRIMARY KEY (tipoCons),
    tipodesc varchar(255) NOT NULL,
    tipocantdiashabiles int(10) NOT NULL
);


CREATE TABLE Bi_Estado_Libros(
    esta_Id int(10) NOT NULL,
    esta_Descripcion varchar(255) NOT NULL
);


CREATE TABLE Bi_Usuarios(
    usuacons int(10) NOT NULL,
    PRIMARY KEY (usuacons),
    usuaId int(10) NOT NULL,
    usuaNomb varchar(255),
    usuaTipo int(10) NOT NULL,
    usuaEstado  int(10) NOT NULL
);
INSERT INTO Bi_Usuarios VALUES(1, 119346982, 'Ana Vega', 1, 1);

CREATE TABLE Bi_libros(
    Libcons int(10) NOT NULL,
    PRIMARY KEY (LibCons),
    Libdesc varchar(255) NOT NULL,
    Libcant int(10) NOT NULL,
    Libesta int(10) NOT NULL
);



CREATE TABLE Bi_Prestamos(
    Prescons int(10) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (Prescons),
    presisbn int(10) NOT NULL,
    presidusuario int(10) NOT NULL,
    presfechaprestamo Date,
    presfechaentrega Date
);





