package org.example.service.impl;

import org.example.dao.BookDao;
import org.example.dao.impl.BookDaoImpl;
import org.example.model.Book;
import org.example.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();
    @Override
    public void createTableBook() {
        bookDao.createTableBook();
    }

    @Override
    public String saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    @Override
    public List<Book> getAllBookByAuthorID(Long authorId) {
        return bookDao.getAllBookByAuthorID(authorId);
    }

    @Override
    public List<Book> sortedBookByPrice() {
        return bookDao.sortedBookByPrice();
    }

    @Override
    public void deleteBooksFromAuthor(Long authorId) {
        bookDao.deleteBooksFromAuthor(authorId);

    }

    @Override
    public void dropTableBook() {
        bookDao.dropTableBook();
    }

    @Override
    public void cleanTableBook() {
     bookDao.cleanTableBook();
    }
}
