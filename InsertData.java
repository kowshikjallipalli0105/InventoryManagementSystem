import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    static String url = "jdbc:mysql://localhost:3306/inventory_management_system";
    static String user = "root";
    static String password = "kowshik0105";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            // SQL query to insert data into the product table
            String sql = "INSERT INTO product (id, name, cost, quantity) VALUES (?, ?, ?, ?)";
            
            // Create a prepared statement with placeholders for the values
            pstmt = conn.prepareStatement(sql);
            
            // Set the values for the placeholders
            pstmt.setString(1, "001"); // Example ID
            pstmt.setString(2, "Cat Food"); // Example name
            pstmt.setInt(3, 10); // Example cost
            pstmt.setInt(4, 50); // Example quantity

            // Execute the insert statement
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("No data inserted.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
