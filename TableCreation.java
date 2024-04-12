import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation {
    static String url = "jdbc:mysql://localhost:3306/inventory_management_system";
    static String user = "root";
    static String password = "kowshik0105";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "CREATE TABLE product (" +
                    "id VARCHAR(20) PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "cost INT NOT NULL, " +
                    "quantity INT NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Table 'product' created successfully.");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
