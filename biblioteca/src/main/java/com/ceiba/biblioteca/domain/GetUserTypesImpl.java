package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.ports.repository.GetTypes;
import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;

import java.util.List;

public class GetUserTypesImpl implements GetUserTypes{

    private GetTypes getTypes;

    public GetUserTypesImpl(GetTypes getTypes) {
        this.getTypes = getTypes;
    }

    @Override
    public List<TiposUsuarios> listarTipos() {
        return getTypes.findByAll();
    }

    @Override
    public TiposUsuarios listarTiposConParametros(long tipo) {
        return getTypes.findByTipoCons(tipo);
    }
}
