package org.example.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    private Long id;
    private String name;
    private String country;
    private int publicationYear;
    private int price;
    private Long authorId;

    public Book(String name, int publicationYear, String country, int price, Long authorId) {
        this.name = name;
        this.publicationYear = publicationYear;
        this.country = country;
        this.price = price;
        this.authorId = authorId;
    }
}
