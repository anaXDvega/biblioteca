package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.infrastructure.entity.Prestamos;

import java.util.List;
import java.util.Map;

public interface LibrosPrestados {

    List<Prestamos> listarLibrosPrestados();
    Map<String, String>  listarLibrosPrestadosConParametros(long idLibro);
    Prestamos listarLibrosPrestadosConParametros(String idLibro, String IdUsuario);
    Prestamos registrarPrestamo(String idLibro, String IdUsuario);

}
