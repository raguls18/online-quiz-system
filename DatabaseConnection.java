
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Make sure you have the MySQL JDBC driver in your classpath
            String url = "jdbc:mysql://localhost:3306/quiz_system";
            String username = "root";
            String password = "1234567890"; // change with your MySQL password

            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

