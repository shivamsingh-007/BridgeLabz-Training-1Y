import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q1EmployeeSalaryManager {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addEmployee(connection, 1, "Aman", 28000);
            addEmployee(connection, 2, "Nisha", 52000);
            addEmployee(connection, 3, "Rohit", 14000);
            displaySalaryAbove(connection, 30000);
            increaseSalaryByTenPercent(connection, 1);
            removeLowSalaryEmployees(connection, 15000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS employee(id INT PRIMARY KEY, name VARCHAR(50), salary DOUBLE)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addEmployee(Connection connection, int id, String name, double salary) throws SQLException {
        String sql = "INSERT INTO employee(id, name, salary) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);
            ps.executeUpdate();
        }
    }

    private static void displaySalaryAbove(Connection connection, double amount) throws SQLException {
        String sql = "SELECT * FROM employee WHERE salary > ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("salary"));
                }
            }
        }
    }

    private static void increaseSalaryByTenPercent(Connection connection, int id) throws SQLException {
        String sql = "UPDATE employee SET salary = salary * 1.10 WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private static void removeLowSalaryEmployees(Connection connection, double amount) throws SQLException {
        String sql = "DELETE FROM employee WHERE salary < ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.executeUpdate();
        }
    }
}