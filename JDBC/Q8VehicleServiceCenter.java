import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q8VehicleServiceCenter {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addVehicle(connection, "UP32AB1234", "Ravi", "Pending");
            addVehicle(connection, "DL10CD5678", "Neha", "Completed");
            showPendingVehicles(connection);
            updateStatus(connection, "UP32AB1234", "Completed");
            deleteVehicle(connection, "UP32AB1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS vehicles(regNo VARCHAR(20) PRIMARY KEY, owner VARCHAR(50), status VARCHAR(20))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addVehicle(Connection connection, String regNo, String owner, String status) throws SQLException {
        String sql = "INSERT INTO vehicles(regNo, owner, status) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, regNo);
            ps.setString(2, owner);
            ps.setString(3, status);
            ps.executeUpdate();
        }
    }

    private static void showPendingVehicles(Connection connection) throws SQLException {
        String sql = "SELECT * FROM vehicles WHERE status = 'Pending'";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("regNo") + " " + rs.getString("owner") + " " + rs.getString("status"));
            }
        }
    }

    private static void updateStatus(Connection connection, String regNo, String status) throws SQLException {
        String sql = "UPDATE vehicles SET status = ? WHERE regNo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setString(2, regNo);
            ps.executeUpdate();
        }
    }

    private static void deleteVehicle(Connection connection, String regNo) throws SQLException {
        String sql = "DELETE FROM vehicles WHERE regNo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, regNo);
            ps.executeUpdate();
        }
    }
}