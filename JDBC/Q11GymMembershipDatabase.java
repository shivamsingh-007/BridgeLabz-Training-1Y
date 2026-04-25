import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q11GymMembershipDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addMember(connection, 1, "Ankit", "Premium", 12);
            addMember(connection, 2, "Riya", "Basic", 3);
            listPremiumMembers(connection);
            extendMembership(connection, 2, 6);
            removeExpiredMemberships(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS members(id INT PRIMARY KEY, name VARCHAR(50), type VARCHAR(20), months INT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addMember(Connection connection, int id, String name, String type, int months) throws SQLException {
        String sql = "INSERT INTO members(id, name, type, months) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, type);
            ps.setInt(4, months);
            ps.executeUpdate();
        }
    }

    private static void listPremiumMembers(Connection connection) throws SQLException {
        String sql = "SELECT * FROM members WHERE type = 'Premium'";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("type") + " " + rs.getInt("months"));
            }
        }
    }

    private static void extendMembership(Connection connection, int id, int extraMonths) throws SQLException {
        String sql = "UPDATE members SET months = months + ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, extraMonths);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void removeExpiredMemberships(Connection connection) throws SQLException {
        String sql = "DELETE FROM members WHERE months <= 0";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }
}