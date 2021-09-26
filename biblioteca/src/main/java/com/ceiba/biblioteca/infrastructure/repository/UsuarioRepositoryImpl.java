package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.domain.GetUser;
import com.ceiba.biblioteca.domain.ports.repository.GetDatosUser;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import com.ceiba.biblioteca.infrastructure.mapper.User.MapperUserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements GetDatosUser {
    @Autowired
    @Lazy
    private  UsuarioRepository  usuarioRepository ;
    @Autowired
    private MapperUserRegistry mapperUserRegistry;

    @Override
    public Usuarios findByusuaId(long id) {
        Usuarios registry = null;
        Optional<Usuarios> opcional = usuarioRepository.findByUsuaId(id);
        if (opcional.isPresent()) {
            registry = mapperUserRegistry.mapToDomain(opcional.get());
        }
        return registry;
    }
    @Override
    public Usuarios findByusuaCons(long id) {
        Usuarios registry = null;
        Optional<Usuarios> opcional = usuarioRepository.findByUsuaCons(id);
        if (opcional.isPresent()) {
            registry = mapperUserRegistry.mapToDomain(opcional.get());
            System.out.println(registry);
        }
        return registry;
    }
}
