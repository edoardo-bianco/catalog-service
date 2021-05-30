package org.dadus.polarbookshop.catalogservice.web;

import lombok.RequiredArgsConstructor;
import org.dadus.polarbookshop.catalogservice.domain.Book;
import org.dadus.polarbookshop.catalogservice.domain.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public Iterable<Book> get() {
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }

    @PutMapping("{isbn}")
    public Book put(@PathVariable String isbn, @RequestBody Book book) {
        return bookService.editBookDetails(isbn, book);
    }

}
