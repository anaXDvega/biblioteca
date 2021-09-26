package com.ceiba.biblioteca.infrastructure.repository;


import com.ceiba.biblioteca.infrastructure.entity.Libros;
import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Repository
public interface BorrowedBookRepository extends CrudRepository<Libros, Long> {


    @Transactional
    Optional<Libros> findByLibCons(long id);
}
