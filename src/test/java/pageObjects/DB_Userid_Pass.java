package pageObjects;

import java.sql.*;

import utils.DBconfig;



public class DB_Userid_Pass {

	
	 
    public static String[] getLoginCredentials() {
        String[] credentials = new String[2]; // [0] = username, [1] = password
        
        String connectionUrl = DBconfig.CONNECTION_URL;  // reuse it here

        
        String query = "SELECT TOP 1 UserName, Password FROM usermaster";

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                credentials[0] = rs.getString("UserName");
                credentials[1] = rs.getString("Password");
                
                // Print to console
                System.out.println("Username: " + credentials[0]);
                System.out.println("Password: " + credentials[1]);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return credentials;
    }
    
    // You can call the method in main() to test
    public static void main(String[] args) {
        getLoginCredentials();
    }
}
