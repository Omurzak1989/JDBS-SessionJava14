package org.example;

import org.example.model.Author;
import org.example.model.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.impl.AuthorServiceImpl;
import org.example.service.impl.BookServiceImpl;

import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AuthorService authorService= new AuthorServiceImpl();
        BookService bookService= new BookServiceImpl();

        authorService.createTableAuthor();
        authorService.saveAuthor(new Author("Chyngyz","Aitmatov","chyngyz@gmail.com","KG",LocalDate.of(1928,12,12)));
        authorService.saveAuthor(new Author("Tologon","Kasymbekov","tologon@gmail.com","KG",LocalDate.of(1931,1,15)));


        bookService.createTableBook();
        bookService.saveBook(new Book("Djamila",1958,"KG",150,1L));
        bookService.saveBook(new Book("Syngan kylych",1966,"KG",170,2L));

        List<Author> authors=authorService.getAllAuthors();
        authors.forEach(System.out::println);

        List<Book> books=bookService.sortedBookByPrice();
        books.forEach(System.out::println);

        authorService.updateAuthor(1L,new Author(1L,"Chyngyz","Aitmatov","chyngyz@update.com","KG",LocalDate.of(1928,12,12)));
        bookService.saveBook(new Book("Dlamila",1958,"KG",120,1L));


        Author author=authorService.getById(1L);
        System.out.println("Author: " + author);
        List<Book> booksByAuthor= bookService.getAllBookByAuthorID(1L);
        booksByAuthor.forEach(book -> System.out.println("Book: " + book));


        bookService.deleteBooksFromAuthor(1L);
        authorService.dropTableAuthor();
        bookService.dropTableBook();




    }
}
