package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Дерекқорға қосылу параметрлері (мысалы, PostgreSQL немесе MySQL)
    private static final String URL = "jdbc:postgresql://localhost:5432/library_db";
    private static final String USER = "postgres"; // Мұнда "your_username" болмауы керек
    private static final String PASSWORD = "Amswer"; // Мұнда "your_password" болмауы керек

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD); //
    }
}
