import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q9OnlineCourseEnrollmentSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addEnrollment(connection, 1, "Ishita", "Java");
            addEnrollment(connection, 2, "Dev", "Python");
            showEnrollmentsForCourse(connection, "Java");
            updateCourse(connection, 1, "Spring Boot");
            deleteEnrollment(connection, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS enrollments(id INT PRIMARY KEY, student VARCHAR(50), course VARCHAR(50))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addEnrollment(Connection connection, int id, String student, String course) throws SQLException {
        String sql = "INSERT INTO enrollments(id, student, course) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, student);
            ps.setString(3, course);
            ps.executeUpdate();
        }
    }

    private static void showEnrollmentsForCourse(Connection connection, String course) throws SQLException {
        String sql = "SELECT * FROM enrollments WHERE course = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, course);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("student") + " " + rs.getString("course"));
                }
            }
        }
    }

    private static void updateCourse(Connection connection, int id, String newCourse) throws SQLException {
        String sql = "UPDATE enrollments SET course = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newCourse);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void deleteEnrollment(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM enrollments WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}