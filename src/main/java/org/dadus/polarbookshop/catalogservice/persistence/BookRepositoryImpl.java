package org.dadus.polarbookshop.catalogservice.persistence;

import org.dadus.polarbookshop.catalogservice.domain.Book;
import org.dadus.polarbookshop.catalogservice.domain.BookRepository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class BookRepositoryImpl implements BookRepository {
    private static final Map<String, Book> books = new ConcurrentHashMap<>();
    
    @Override
    public Collection<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existsByIsbn(isbn)? Optional.of(books.get(isbn)): Optional.empty();
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return Objects.nonNull(books.get(isbn));
    }

    @Override
    public Book save(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
