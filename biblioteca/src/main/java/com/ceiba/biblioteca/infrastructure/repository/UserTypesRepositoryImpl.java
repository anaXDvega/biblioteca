package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.domain.ports.repository.GetTypes;
import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;
import com.ceiba.biblioteca.infrastructure.mapper.TypesUSer.MapperTypesUserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserTypesRepositoryImpl implements GetTypes {

    @Autowired
    @Lazy
    private  UserTypesRepository  userTypesRepository ;

    @Autowired
    private MapperTypesUserRegistry mapperTypesUserRegistry;

    @Override
    public List<TiposUsuarios> findByAll() {
     return  userTypesRepository.findAll();
    }

    @Override
    public TiposUsuarios findByTipoCons(long id) {
        TiposUsuarios registry = null;
        Optional<TiposUsuarios> opcional = userTypesRepository.findBytipoCons(id);
        if (opcional.isPresent()) {
         registry = mapperTypesUserRegistry.mapToDomain(opcional.get());
        }
        return registry;
    }
}
