import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q2ProductInventoryTracker {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            insertProduct(connection, 101, "Pen", 5);
            insertProduct(connection, 102, "Notebook", 25);
            insertProduct(connection, 103, "Marker", 8);
            displayLowStock(connection);
            addStock(connection, 101, 20);
            deleteProduct(connection, 103);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS product(pid INT PRIMARY KEY, pname VARCHAR(50), qty INT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void insertProduct(Connection connection, int pid, String pname, int qty) throws SQLException {
        String sql = "INSERT INTO product(pid, pname, qty) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pid);
            ps.setString(2, pname);
            ps.setInt(3, qty);
            ps.executeUpdate();
        }
    }

    private static void displayLowStock(Connection connection) throws SQLException {
        String sql = "SELECT * FROM product WHERE qty < 10";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("pid") + " " + rs.getString("pname") + " " + rs.getInt("qty"));
            }
        }
    }

    private static void addStock(Connection connection, int pid, int qtyToAdd) throws SQLException {
        String sql = "UPDATE product SET qty = qty + ? WHERE pid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, qtyToAdd);
            ps.setInt(2, pid);
            ps.executeUpdate();
        }
    }

    private static void deleteProduct(Connection connection, int pid) throws SQLException {
        String sql = "DELETE FROM product WHERE pid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pid);
            ps.executeUpdate();
        }
    }
}