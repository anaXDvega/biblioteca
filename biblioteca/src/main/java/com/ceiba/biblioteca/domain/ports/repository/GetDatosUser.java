package com.ceiba.biblioteca.domain.ports.repository;

import com.ceiba.biblioteca.infrastructure.entity.Usuarios;

public interface GetDatosUser {

    Usuarios findByusuaId(long id);
    Usuarios findByusuaCons(long id);

}
