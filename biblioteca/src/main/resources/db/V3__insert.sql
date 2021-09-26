INSERT INTO Bi_Tipos_Usuarios VALUES(1, 'Usuario Invitado', '7');
INSERT INTO Bi_Tipos_Usuarios VALUES(3, 'Usuario Empleado de la biblioteca', '8');
INSERT INTO Bi_Tipos_Usuarios VALUES(2, 'Usuario Afiliado', '10');
INSERT INTO Bi_Estado_Libros VALUES(1, 'Activo');
INSERT INTO Bi_Estado_Libros VALUES(2, 'Prestado');
INSERT INTO Bi_Estado_Libros VALUES(3, 'Inactivo');
INSERT INTO Bi_libros VALUES(1, 'el coronel no tiene quien le escriba',3, 1);
INSERT INTO Bi_libros VALUES(2, 'Juan salvador gaviota',4, 1);
INSERT INTO Bi_usuarios VALUES(2, 1193468392, 'Ana Vega', 2, 1);
INSERT INTO Bi_usuarios VALUES(3, 11938392, 'Fabiola', 3, 1);

INSERT INTO BI_PRESTAMOS  VALUES(1, 1, 1, '1995-01-29','1995-01-29');
INSERT INTO BI_PRESTAMOS  VALUES(2, 1, 3, '1995-01-29','1995-01-29');

COMMIT;