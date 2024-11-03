package pertemuan_7;

// db/MySqlConnection.java
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pp2_membership";
    private static final String DB_USER = "pp2_membership"; 
    private static final String DB_PASS = ""; 
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
