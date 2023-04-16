package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static Connection getSqlConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://HICHUNHA\\SQLEXPRESS:1433;encrypt=true;database=SV;trustServerCertificate= true;";
        String userName = "sa";
        String password = "hehe0000";
        Connection con = DriverManager.getConnection(connectionUrl, userName, password);
        return con;

    }
}

