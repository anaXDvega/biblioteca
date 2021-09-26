package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuarios, Long> {
    @Transactional
    Optional<Usuarios> findByUsuaId(long id);

    @Transactional
    Optional<Usuarios> findByUsuaCons(long cedula);
}
