package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.ports.repository.GetDatosUser;
import com.ceiba.biblioteca.domain.ports.repository.GetTypes;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;

public class GetUserImpl implements GetUser{
    private GetDatosUser getDatosUserUser;

    public GetUserImpl(GetDatosUser getDatosUserUser) {
        this.getDatosUserUser = getDatosUserUser;
    }

    @Override
    public Usuarios listarUsuariosConParametros(long id) {
        return getDatosUserUser.findByusuaId(id);
    }
}
