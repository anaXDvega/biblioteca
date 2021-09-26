package com.ceiba.biblioteca.domain.ports.repository;

import java.util.Map;

public interface GetDatosPrestamo {
    Map<String, String> BuscarDatosPrestamo(String id, String cedula, String tipoUsuario);
    Map<String, String> BuscarDatosPrestamo(long id);
}
