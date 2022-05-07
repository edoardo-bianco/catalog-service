package org.dadus.catalogservice.domain;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String isbn) {
        super(String.format("The book with ISBN %s was not found.", isbn));
    }
    
}
