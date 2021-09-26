package com.ceiba.biblioteca.domain.ports.repository;

import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;

import java.util.List;

public interface GetTypes {
    List<TiposUsuarios> findByAll();

    TiposUsuarios findByTipoCons(long id);

}
