package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.ports.repository.GetDatosPrestamo;

import java.util.Map;

public class GetDatosLibrosPrestadosImpl implements GetDatosLibrosPrestados{

    private GetDatosPrestamo getDatosPrestamo;

    public GetDatosLibrosPrestadosImpl(GetDatosPrestamo getDatosPrestamo) {
        this.getDatosPrestamo = getDatosPrestamo;
    }

    @Override
    public Map<String, String> BuscarDatosPrestamo(String idLibro, String IdUsuario, String tipoUsuario) {

        return getDatosPrestamo.BuscarDatosPrestamo( idLibro,  IdUsuario, tipoUsuario);
    }

    @Override
    public Map<String, String> listarLibrosPrestadosConParametros(long idLibro) {
        return getDatosPrestamo.BuscarDatosPrestamo(idLibro);
    }
}
