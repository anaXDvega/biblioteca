package com.ceiba.biblioteca.infrastructure.repository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Map;

@Repository
public interface DatosPrestamoRepository {
    @Transactional
    Map<String, String> BuscarDatosPrestamo(long id, long usuario);
}
