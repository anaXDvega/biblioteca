package com.ceiba.biblioteca.domain.ports.repository;

import com.ceiba.biblioteca.infrastructure.entity.Prestamos;

import java.util.List;
import java.util.Map;

public interface GetPortRegistration {
    Prestamos save(Prestamos prestamos);
    Prestamos findBypresCons(long id);
    Prestamos findByprespresIsbnAndIdUsuarioLong(Long id, Long cedula);
    Prestamos findByprespresIsbnAndIdUsuario(String id, String cedula);
    List<Prestamos> listaLibrosPrestados();
}
