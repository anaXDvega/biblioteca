package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserTypesRepository extends CrudRepository<TiposUsuarios, Long> {
    @Transactional
    List<TiposUsuarios> findAll();

    @Transactional
    Optional<TiposUsuarios> findBytipoCons(long id);
}
