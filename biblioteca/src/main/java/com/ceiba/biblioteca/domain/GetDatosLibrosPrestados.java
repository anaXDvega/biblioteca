package com.ceiba.biblioteca.domain;

import java.util.Map;

public interface GetDatosLibrosPrestados {
    Map<String, String> BuscarDatosPrestamo(String idLibro, String IdUsuario, String tipoUsuario);
    Map<String, String> listarLibrosPrestadosConParametros(long idLibro);
}
