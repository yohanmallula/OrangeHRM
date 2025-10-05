package pageObjects;

import org.testng.annotations.Test;
import java.sql.*;

public class DatabaseTest {

    @Test
    public void fetchDataFromDatabase() {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-MQLPV38\\SQLEXPRESS:1433;" +
                "databaseName=master;" +
                "integratedSecurity=false;" +
                "encrypt=false;" +
                "trustServerCertificate=true;" +
                "user=testuser;" +
                "password=Test@123;";

        // Only select the ProductName
        String query = "SELECT ProductName FROM dbo.Orders WHERE ProductName = ?";

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "Wireless Mouse");

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Column name: ProductName");
                while (rs.next()) {
                    String productName = rs.getString("ProductName");
                    System.out.println(productName);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

      /*  try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Connected successfully and executing query...");
            
            

            while (rs.next()) {
                int orderId = rs.getInt("OrderID");
                int customerId = rs.getInt("CustomerID");
                String productName = rs.getString("ProductName");
                int quantity = rs.getInt("Quantity");
                double price = rs.getDouble("Price");
                Timestamp orderDate = rs.getTimestamp("OrderDate");
                String shippingAddress = rs.getString("ShippingAddress");
                String status = rs.getString("Status");
                String paymentMethod = rs.getString("PaymentMethod");

                // Print row data
                System.out.println("OrderID: " + orderId + ", CustomerID: " + customerId + 
                                   ", Product: " + productName + ", Quantity: " + quantity + 
                                   ", Price: " + price + ", OrderDate: " + orderDate + 
                                   ", ShippingAddress: " + shippingAddress + 
                                   ", Status: " + status + ", PaymentMethod: " + paymentMethod);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } */
    }
}
