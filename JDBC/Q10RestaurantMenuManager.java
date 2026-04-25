import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q10RestaurantMenuManager {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addMenuItem(connection, 1, "Paneer Roll", 180);
            addMenuItem(connection, 2, "Special Thali", 260);
            showItemsBelowPrice(connection, 200);
            updatePrice(connection, 2, 240);
            deleteItem(connection, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS menu(id INT PRIMARY KEY, itemName VARCHAR(50), price DOUBLE)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addMenuItem(Connection connection, int id, String itemName, double price) throws SQLException {
        String sql = "INSERT INTO menu(id, itemName, price) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, itemName);
            ps.setDouble(3, price);
            ps.executeUpdate();
        }
    }

    private static void showItemsBelowPrice(Connection connection, double price) throws SQLException {
        String sql = "SELECT * FROM menu WHERE price < ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, price);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("itemName") + " " + rs.getDouble("price"));
                }
            }
        }
    }

    private static void updatePrice(Connection connection, int id, double newPrice) throws SQLException {
        String sql = "UPDATE menu SET price = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void deleteItem(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM menu WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}