import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q3LibraryBookManager {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            insertBook(connection, 1, "Clean Code", "Robert Martin", "Available");
            insertBook(connection, 2, "Effective Java", "Joshua Bloch", "Available");
            showAvailableBooks(connection);
            markBookIssued(connection, 2);
            deleteBook(connection, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS books(id INT PRIMARY KEY, title VARCHAR(100), author VARCHAR(50), status VARCHAR(10))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void insertBook(Connection connection, int id, String title, String author, String status) throws SQLException {
        String sql = "INSERT INTO books(id, title, author, status) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, status);
            ps.executeUpdate();
        }
    }

    private static void showAvailableBooks(Connection connection) throws SQLException {
        String sql = "SELECT * FROM books WHERE status = 'Available'";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("title") + " " + rs.getString("author"));
            }
        }
    }

    private static void markBookIssued(Connection connection, int id) throws SQLException {
        String sql = "UPDATE books SET status = 'Issued' WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private static void deleteBook(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}