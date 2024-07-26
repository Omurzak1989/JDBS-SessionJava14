package org.example.service.impl;

import org.example.dao.AuthorDao;
import org.example.dao.impl.AuthorDaoImpl;
import org.example.model.Author;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao=new AuthorDaoImpl();
    @Override
    public void createTableAuthor() {
        authorDao.createTableAuthor();

    }

    @Override
    public String saveAuthor(Author author) {
        return  authorDao.saveAuthor(author);

    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }

    @Override
    public Author getById(Long authorId) {
        return authorDao.getById(authorId);
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        return authorDao.updateAuthor(authorId, newAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorDao.deleteAuthor(authorId);

    }

    @Override
    public void dropTableAuthor() {
        authorDao.dropTableAuthor();

    }

    @Override
    public void cleanTableAuthor() {
        authorDao.cleanTableAuthor();

    }

    @Override
    public List<Author> sortByDateOfBirth() {
        return authorDao.sortByDateOfBirth();
    }
}
