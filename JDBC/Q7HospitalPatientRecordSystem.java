import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q7HospitalPatientRecordSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            insertPatient(connection, 1, "Kiran", "Flu");
            insertPatient(connection, 2, "Meena", "Diabetes");
            showPatientsByDisease(connection, "Flu");
            updateDisease(connection, 1, "Recovered");
            deletePatient(connection, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS patients(id INT PRIMARY KEY, name VARCHAR(50), disease VARCHAR(50))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void insertPatient(Connection connection, int id, String name, String disease) throws SQLException {
        String sql = "INSERT INTO patients(id, name, disease) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, disease);
            ps.executeUpdate();
        }
    }

    private static void showPatientsByDisease(Connection connection, String disease) throws SQLException {
        String sql = "SELECT * FROM patients WHERE disease = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, disease);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("disease"));
                }
            }
        }
    }

    private static void updateDisease(Connection connection, int id, String disease) throws SQLException {
        String sql = "UPDATE patients SET disease = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, disease);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void deletePatient(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}