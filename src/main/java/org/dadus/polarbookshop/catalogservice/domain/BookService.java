package org.dadus.polarbookshop.catalogservice.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Collection<Book> viewBookList(){
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn){
        return bookRepository.findByIsbn(isbn).orElseThrow(()-> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())){
            throw new BookAlreadyExistsException(book.getIsbn());
        }

        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn){
        if(!bookRepository.existsByIsbn(isbn)){
            throw new BookNotFoundException(isbn);
        }

        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(String isbn, Book book){
        Optional<Book> existingBook = bookRepository.findByIsbn(isbn);
        if (existingBook.isEmpty()){
            return addBookToCatalog(book);
        }
        Book bookToUpdate = existingBook.get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPublishingYear(book.getPublishingYear());
        bookToUpdate.setPrice(book.getPrice());

        return bookRepository.save(bookToUpdate);

    }
}
