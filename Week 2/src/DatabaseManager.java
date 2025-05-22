import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:armstrong.db";

    public static void initializeDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS results (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "number INTEGER NOT NULL," +
                         "is_armstrong BOOLEAN NOT NULL," +
                         "checked_at DATETIME DEFAULT CURRENT_TIMESTAMP)";
            stmt.executeUpdate(sql);
        }
    }

    public static void saveResult(int number, boolean isArmstrong) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO results (number, is_armstrong) VALUES (?, ?)")) {
            pstmt.setInt(1, number);
            pstmt.setBoolean(2, isArmstrong);
            pstmt.executeUpdate();
        }
    }
}
