package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.infrastructure.entity.Usuarios;

public interface GetUser {
    Usuarios listarUsuariosConParametros(long tipo);
}
