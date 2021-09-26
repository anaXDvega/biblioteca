package com.ceiba.biblioteca.infrastructure.mapper.Books;

import com.ceiba.biblioteca.infrastructure.entity.Libros;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MapperBorrowedBooks {
    public static Libros mapToEntity(Libros libros){
        return new Libros(libros.getLibCons(), libros.getLibDesc(), libros.getLibCant(), libros.getLibEsta());
    }
    public static Libros mapToDomain(Libros libros){
        return new Libros(libros.getLibCons(), libros.getLibDesc(), libros.getLibCant(), libros.getLibEsta());
    }

    public List<Libros> mapToDomain(List<Libros> all) {
        List<Libros> listaLibrosPrestados = new ArrayList<>();
        all.forEach(libros -> {
            Libros Libros = new Libros(libros.getLibCons(), libros.getLibDesc(), libros.getLibCant(), libros.getLibEsta());

            listaLibrosPrestados.add(Libros);

        });
        return listaLibrosPrestados;
    }
}
