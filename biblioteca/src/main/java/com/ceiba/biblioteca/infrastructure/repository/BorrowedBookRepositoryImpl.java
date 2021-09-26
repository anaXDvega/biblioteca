package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.domain.ports.repository.GetBooks;
import com.ceiba.biblioteca.infrastructure.entity.Libros;
import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;
import com.ceiba.biblioteca.infrastructure.mapper.Books.MapperBorrowedBooks;
import com.ceiba.biblioteca.infrastructure.mapper.TypesUSer.MapperTypesUserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class BorrowedBookRepositoryImpl implements GetBooks {
    @Autowired
    @Lazy
    private  BorrowedBookRepository borrowedBookRepository ;

    @Autowired
    private MapperBorrowedBooks mapperBorrowedBooks;

    @Override
    public Libros findBylibCons(long id) {
        Libros registry = null;
        Optional<Libros> opcional = borrowedBookRepository.findByLibCons(id);
        if (opcional.isPresent()) {
            registry = mapperBorrowedBooks.mapToDomain(opcional.get());
            System.out.println(registry);
        }
        return registry;

    }
}
