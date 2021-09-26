package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.ports.repository.GetBooks;
import com.ceiba.biblioteca.infrastructure.entity.Libros;

public class GetBorrowedBooksImpl implements GetBorrowedBooks {

   private GetBooks getBooks;

    public GetBorrowedBooksImpl(GetBooks getBooks) {
        this.getBooks = getBooks;
    }

    @Override
    public Libros listarLibrosPrestadosPorId(long id) {
        return getBooks.findBylibCons(id);
    }
}
