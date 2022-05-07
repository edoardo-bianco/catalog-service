package org.dadus.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException(String isbn) {
        super(String.format("A book with ISBN %s already exists.", isbn));
    }
    
}
