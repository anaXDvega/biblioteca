package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.ports.repository.GetPortRegistration;
import com.ceiba.biblioteca.infrastructure.entity.Prestamos;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class LibrosPrestadosImpl implements LibrosPrestados{

    private GetPortRegistration getPortRegistration;
    public LibrosPrestadosImpl(GetPortRegistration getPortRegistration) {
        this.getPortRegistration = getPortRegistration;
    }

    @Override
    public List<Prestamos> listarLibrosPrestados() {
        return getPortRegistration.listaLibrosPrestados();
    }

    @Override
    public Map<String, String> listarLibrosPrestadosConParametros(long idLibro) {
        Prestamos prestamo = getPortRegistration.findBypresCons(idLibro);
        return null;
    }

    @Override
    public Prestamos listarLibrosPrestadosConParametros(String idLibro, String IdUsuario) {

        return getPortRegistration.findByprespresIsbnAndIdUsuario( idLibro,  IdUsuario);
    }

    @Override
    public Prestamos registrarPrestamo(String idLibro, String IdUsuario) {

        Prestamos prestamos = getPortRegistration.findByprespresIsbnAndIdUsuario( idLibro,  IdUsuario);
        prestamos.setPresFechaPrestamo(new Date());
        getPortRegistration.save(prestamos);
        return prestamos;
    }


}
