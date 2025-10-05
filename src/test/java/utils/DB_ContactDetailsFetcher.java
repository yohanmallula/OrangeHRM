package utils;

import java.sql.*;

public class DB_ContactDetailsFetcher {
	
	
    public static class ContactDetails {
        public int contactId;
        public String street1;
        public String street2;
        public String city;
        public String state;
        public String zip;
        public String home;
        public String mobile;
        public String workEmail;
        public String otherEmail;
    }

    public static ContactDetails fetchFirstContactDetails() {
        String connectionUrl = DBconfig.CONNECTION_URL;
        String query = "SELECT TOP 1 * FROM ContactDetails";

        ContactDetails details = new ContactDetails();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try (Connection conn = DriverManager.getConnection(connectionUrl);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                if (rs.next()) {
                    details.contactId = rs.getInt("ContactID");
                    details.street1 = rs.getString("Street1");
                    details.street2 = rs.getString("Street2");
                    details.city = rs.getString("City");
                    details.state = rs.getString("StateProvince");
                    details.zip = rs.getString("ZipPostalCode");
                    details.home = rs.getString("Home");
                    details.mobile = rs.getString("Mobile");
                    details.workEmail = rs.getString("WorkEmail");
                    details.otherEmail = rs.getString("OtherEmail");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return details;
    }
}

