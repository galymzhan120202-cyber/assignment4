package repository;

import model.*;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public void create(BookBase book) {
        String sql = "INSERT INTO books (name, author_name, type) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getName());
            stmt.setString(2, book.getAuthor().getFullName());
            stmt.setString(3, book.getBookType());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookBase> getAll() {
        List<BookBase> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String authorName = rs.getString("author_name");
                String type = rs.getString("type");


                Author author = new Author(authorName);


                BookBase book;
                if ("Digital E-Book".equalsIgnoreCase(type)) {

                    book = new EBook(id, name, author, 0.0, 0.0);
                } else {

                    book = new PhysicalBook(id, name, author, 0);
                }

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override public BookBase getById(int id) { return null; }
    @Override public void update(int id, BookBase book) {}
    @Override public void delete(int id) {}
}