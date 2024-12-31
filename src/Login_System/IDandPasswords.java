package Login_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> logininfo = new HashMap<String, String>();

    protected static String url = "jdbc:postgresql://localhost:5432/users";
    protected static String userName = "postgres";
    protected static String password = "P@ssw0rd()SQL";

    IDandPasswords() {
//        logininfo.put("admin", "admin");
//        logininfo.put("Nimith", "P@ssw0rd()");

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
