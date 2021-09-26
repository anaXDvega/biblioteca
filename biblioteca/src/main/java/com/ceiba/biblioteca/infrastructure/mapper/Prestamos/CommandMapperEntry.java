package com.ceiba.biblioteca.infrastructure.mapper.Prestamos;

import com.ceiba.biblioteca.infrastructure.entity.Prestamos;

public class CommandMapperEntry {

    public static Prestamos mapToRegistry(Prestamos prestamos) {
        return new Prestamos(prestamos.getPresCons(), prestamos.getPresIsbn(),
                prestamos.getPresIdUsuario(), prestamos.getPresFechaPrestamo(),
                prestamos.getPresFechaEntrega());
    }
}
