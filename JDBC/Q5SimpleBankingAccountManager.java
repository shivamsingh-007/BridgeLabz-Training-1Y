import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q5SimpleBankingAccountManager {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            addAccount(connection, 1001, "Rahul", 12000);
            addAccount(connection, 1002, "Sneha", 8000);
            showHighBalanceAccounts(connection, 10000);
            updateBalance(connection, 1001, 2000);
            closeAccount(connection, 1002);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS accounts(accNo INT PRIMARY KEY, name VARCHAR(50), balance DOUBLE)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addAccount(Connection connection, int accNo, String name, double balance) throws SQLException {
        String sql = "INSERT INTO accounts(accNo, name, balance) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, accNo);
            ps.setString(2, name);
            ps.setDouble(3, balance);
            ps.executeUpdate();
        }
    }

    private static void showHighBalanceAccounts(Connection connection, double minBalance) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE balance > ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, minBalance);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("accNo") + " " + rs.getString("name") + " " + rs.getDouble("balance"));
                }
            }
        }
    }

    private static void updateBalance(Connection connection, int accNo, double amountChange) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE accNo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, amountChange);
            ps.setInt(2, accNo);
            ps.executeUpdate();
        }
    }

    private static void closeAccount(Connection connection, int accNo) throws SQLException {
        String sql = "DELETE FROM accounts WHERE accNo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, accNo);
            ps.executeUpdate();
        }
    }
}