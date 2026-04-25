import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q12BookstoreSalesTracking {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            insertSale(connection, 1, "Java Basics", 2, 399.0);
            insertSale(connection, 2, "SQL Guide", 1, 299.0);
            showSalesWithQuantityAboveOne(connection);
            updateQuantity(connection, 2, 3);
            deleteSale(connection, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS sales(id INT PRIMARY KEY, bookName VARCHAR(100), quantity INT, price DOUBLE)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void insertSale(Connection connection, int id, String bookName, int quantity, double price) throws SQLException {
        String sql = "INSERT INTO sales(id, bookName, quantity, price) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, bookName);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.executeUpdate();
        }
    }

    private static void showSalesWithQuantityAboveOne(Connection connection) throws SQLException {
        String sql = "SELECT * FROM sales WHERE quantity > 1";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("bookName") + " " + rs.getInt("quantity") + " " + rs.getDouble("price"));
            }
        }
    }

    private static void updateQuantity(Connection connection, int id, int quantity) throws SQLException {
        String sql = "UPDATE sales SET quantity = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void deleteSale(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM sales WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}