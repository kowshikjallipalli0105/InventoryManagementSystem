import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class InventoryManagementSystem {
    static Connection con;

    public static Connection dbConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/inventory_management_system";
            String user = "root";
            String password = "kowshik0105";
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Connection Established");
            }
        } catch (SQLException e) {
            System.out.println(e);
            con = null;
        }
        return con;
    }

    public static void main(String[] args) {
        con = dbConnection();
        if (con != null) {
            landingpage.initializeGUI(con);
        } else {
            System.out.println("Failed to establish connection.");
            
        }
    }
}
