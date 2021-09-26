package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;

import java.util.List;

public interface GetUserTypes {
    List<TiposUsuarios> listarTipos();
    TiposUsuarios listarTiposConParametros(long tipo);
}
