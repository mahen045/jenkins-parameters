package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
public class DatabaseConnection {
    private static Connection connection = null;
    static {
        try {
            //System.out.println("Available Environment Variables:");
            //Map<String, String> env = System.getenv();
            //env.forEach((key, value) -> System.out.println(key + " = " + value));
            // Load properties from file
//            Properties properties = new Properties();
//            FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
//            properties.load(fis);
            // Get database properties
//            String url = properties.getProperty("db.url");
//            String username = properties.getProperty("db.username");
//            String password = properties.getProperty("db.password");
            String url = System.getenv("DB_URL");
            System.out.println("URL::::"+url);
            String username = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");
            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
