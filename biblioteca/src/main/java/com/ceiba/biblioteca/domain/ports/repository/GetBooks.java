package com.ceiba.biblioteca.domain.ports.repository;

import com.ceiba.biblioteca.infrastructure.entity.Libros;

public interface GetBooks {
    Libros findBylibCons(long id);
}
