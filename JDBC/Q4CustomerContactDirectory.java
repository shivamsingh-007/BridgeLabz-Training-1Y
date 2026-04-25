import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q4CustomerContactDirectory {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addCustomer(connection, 1, "Aarav", "9876543210");
            addCustomer(connection, 2, "Aarti", "9123456780");
            searchByName(connection, "Aar");
            updatePhone(connection, 1, "9999999999");
            removeCustomer(connection, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS customers(id INT PRIMARY KEY, name VARCHAR(50), phone VARCHAR(15))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addCustomer(Connection connection, int id, String name, String phone) throws SQLException {
        String sql = "INSERT INTO customers(id, name, phone) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.executeUpdate();
        }
    }

    private static void searchByName(Connection connection, String keyword) throws SQLException {
        String sql = "SELECT * FROM customers WHERE name LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("phone"));
                }
            }
        }
    }

    private static void updatePhone(Connection connection, int id, String newPhone) throws SQLException {
        String sql = "UPDATE customers SET phone = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newPhone);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void removeCustomer(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}