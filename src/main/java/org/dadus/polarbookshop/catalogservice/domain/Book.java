package org.dadus.polarbookshop.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Year;

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String author;
    private Year publishingYear;
    private Double price;
}
