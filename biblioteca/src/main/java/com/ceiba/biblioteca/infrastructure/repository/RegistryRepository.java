package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface  RegistryRepository extends CrudRepository<Prestamos, Long>  {

    @Transactional
   Optional<Prestamos> findByPresCons(Long Long);

    @Transactional
    Optional<Prestamos> findByPresIsbnAndPresIdUsuario(Long id, Long usuario);

    @Transactional
    List<Prestamos> findAll();


}
