package org.example.dao.impl;

import org.example.config.JDBCConfig;
import org.example.dao.BookDao;
import org.example.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
    private final Connection connection= JDBCConfig.getConnection();
    @Override
    public void createTableBook() {
        String sql = """
                CREATE TABLE IF NOT EXISTS books(
                id serial primary key,
                name varchar,
                country varchar,
                publisher_year int,
                price int,
                author_id int references authors(id)
                """;
        try (Statement statement=connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully created books");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String saveBook(Book book) {
        String sql= """
                INSERT INTO books(name,country,publisher_year,price,author_id)
                VALUES(?,?,?,?,?)
                """;
        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getCountry());
            preparedStatement.setInt(3,book.getPublicationYear());
            preparedStatement.setInt(4,book.getPrice());
            preparedStatement.setLong(5,book.getAuthorId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return book.getName() +" "+"Successfully saved to database";
    }

    @Override
    public List<Book> getAllBookByAuthorID(Long authorId) {
        String sql = "select * from books where author_id=?";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setLong(1,authorId);
            ResultSet resultSet=preparedStatement.executeQuery(sql);
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setCountry(resultSet.getString("country"));
                book.setPublicationYear(resultSet.getInt("publisher_year"));
                book.setPrice(resultSet.getInt("price"));
                book.setAuthorId(resultSet.getLong("author_id"));
                books.add(book);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public List<Book> sortedBookByPrice() {
        String sql ="select * from books order by price";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setCountry(resultSet.getString("country"));
                book.setPublicationYear(resultSet.getInt("publisher_year"));
                book.setPrice(resultSet.getInt("price"));
                book.setAuthorId(resultSet.getLong("author_id"));
                books.add(book);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public void deleteBooksFromAuthor(Long authorId) {
        String sql = "delete from books where author_id=?";
        try (PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            preparedStatement.setLong(1,authorId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Successfully deleted "+rowsDeleted+" books");
            }else {
                System.out.println("Book not found");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dropTableBook() {
        String sql ="drop table if exists books";
        try (Statement statement=connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully dropped books table");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void cleanTableBook() {
        String sql = "clean table if exists books";
        try (Statement statement=connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully cleaned books table");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
