import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q6MovieTicketBookingSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addMovie(connection, 1, "Inception", 100);
            addMovie(connection, 2, "Avatar", 0);
            showAvailableMovies(connection);
            bookTicket(connection, 1, 2);
            deleteMovie(connection, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS movies(id INT PRIMARY KEY, name VARCHAR(50), seats INT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addMovie(Connection connection, int id, String name, int seats) throws SQLException {
        String sql = "INSERT INTO movies(id, name, seats) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, seats);
            ps.executeUpdate();
        }
    }

    private static void showAvailableMovies(Connection connection) throws SQLException {
        String sql = "SELECT * FROM movies WHERE seats > 0";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("seats"));
            }
        }
    }

    private static void bookTicket(Connection connection, int id, int seatsToBook) throws SQLException {
        String sql = "UPDATE movies SET seats = seats - ? WHERE id = ? AND seats >= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, seatsToBook);
            ps.setInt(2, id);
            ps.setInt(3, seatsToBook);
            ps.executeUpdate();
        }
    }

    private static void deleteMovie(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}