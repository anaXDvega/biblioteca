package com.ceiba.biblioteca.infrastructure.mapper.User;

import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperUserRegistry {
    public static Usuarios mapToEntity(Usuarios usuarios) {
        return new Usuarios( usuarios.getUsuaCons(), usuarios.getUsuaId(), usuarios.getUsuaNomb(), usuarios.getUsuaEstado(), usuarios.getUsuaTipo());
    }
    public Usuarios mapToDomain(Usuarios usuarios) {
        return new Usuarios(usuarios.getUsuaCons(), usuarios.getUsuaId(), usuarios.getUsuaNomb(), usuarios.getUsuaEstado(), usuarios.getUsuaTipo());
    }
    public List<Usuarios> mapToDomain(List<Usuarios> all) {
        List<Usuarios> listaRegistro = new ArrayList<>();
        all.forEach(usuarios -> {
            Usuarios Usuarios =new Usuarios(usuarios.getUsuaCons(), usuarios.getUsuaId(), usuarios.getUsuaNomb(), usuarios.getUsuaEstado(), usuarios.getUsuaTipo());

            listaRegistro.add(Usuarios);

        });
        return listaRegistro;
    }

}
