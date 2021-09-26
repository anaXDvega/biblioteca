package com.ceiba.biblioteca.aplication.query;

import com.ceiba.biblioteca.domain.GetDatosLibrosPrestados;
import com.ceiba.biblioteca.domain.LibrosPrestados;
import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class QueryAllPrestamos {

    @Autowired
    LibrosPrestados librosPrestados;


    @Autowired
    GetDatosLibrosPrestados GetDatosLibrosPrestados;

    public List<Prestamos> execute() {
        return librosPrestados.listarLibrosPrestados();
    }
    public Map<String, String>  consultarPrestamo(long idLibro) {
        return GetDatosLibrosPrestados.listarLibrosPrestadosConParametros(idLibro);
    }
    public Prestamos consultarConParametros(String idLibro, String IdUsuario) {
        return librosPrestados.listarLibrosPrestadosConParametros(idLibro, IdUsuario);
    }
   public Map<String, String> consultarPrestamosConParametros(String idLibro, String IdUsuario, String tipoUsuario) {
      return GetDatosLibrosPrestados.BuscarDatosPrestamo(idLibro, IdUsuario, tipoUsuario);
    }

}
