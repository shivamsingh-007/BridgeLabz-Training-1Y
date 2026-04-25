import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q13SimpleToDoTaskManager {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addTask(connection, 1, "Complete JDBC assignment", "Pending");
            addTask(connection, 2, "Submit project", "Pending");
            showPendingTasks(connection);
            markCompleted(connection, 1);
            removeCompletedTasks(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS tasks(id INT PRIMARY KEY, title VARCHAR(100), status VARCHAR(20))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addTask(Connection connection, int id, String title, String status) throws SQLException {
        String sql = "INSERT INTO tasks(id, title, status) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, status);
            ps.executeUpdate();
        }
    }

    private static void showPendingTasks(Connection connection) throws SQLException {
        String sql = "SELECT * FROM tasks WHERE status = 'Pending'";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("title") + " " + rs.getString("status"));
            }
        }
    }

    private static void markCompleted(Connection connection, int id) throws SQLException {
        String sql = "UPDATE tasks SET status = 'Completed' WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private static void removeCompletedTasks(Connection connection) throws SQLException {
        String sql = "DELETE FROM tasks WHERE status = 'Completed'";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }
}