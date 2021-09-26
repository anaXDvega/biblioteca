package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.infrastructure.entity.Libros;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;

public interface GetBorrowedBooks {
    Libros listarLibrosPrestadosPorId(long id);
}
