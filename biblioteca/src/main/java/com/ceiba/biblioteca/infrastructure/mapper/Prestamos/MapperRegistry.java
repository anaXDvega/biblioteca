package com.ceiba.biblioteca.infrastructure.mapper.Prestamos;

import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperRegistry {
    public Prestamos mapToEntity(Prestamos prestamos) {
        return new Prestamos(prestamos.getPresCons(), prestamos.getPresIsbn(),
                prestamos.getPresIdUsuario(), prestamos.getPresFechaPrestamo(),
                prestamos.getPresFechaEntrega());
    }
    public Prestamos mapToDomain(Prestamos prestamos){
    return new Prestamos(prestamos.getPresCons(), prestamos.getPresIsbn(), prestamos.getPresIdUsuario(), prestamos.getPresFechaPrestamo(), prestamos.getPresFechaEntrega());
    }

    public List<Prestamos> mapToDomain(List<Prestamos> all) {
        List<Prestamos> listaRegistro = new ArrayList<>();
        all.forEach(prestamos -> {
            Prestamos Prestamos = new Prestamos(prestamos.getPresCons(), prestamos.getPresIsbn(), prestamos.getPresIdUsuario(), prestamos.getPresFechaPrestamo(), prestamos.getPresFechaEntrega());
            listaRegistro.add(Prestamos);

        });
        return listaRegistro;
    }
}
