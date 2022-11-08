package org.example.db.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static java.sql.Connection conn;

    private static void registerDriver() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not found");
        }
       // System.out.println("Driver is registered");
    }

    private static java.sql.Connection create() {
        registerDriver();
        try {
           conn = DriverManager.getConnection("jdbc:postgresql://localhost/javadb?user=postgres&password=root&ssl=false;");


         //   System.out.println("We are connected");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public static java.sql.Connection getConnection() {
        if (conn == null) {
            return create();
        }
        return conn;
    }

    public static void close(){
        if(conn!= null){
            try{
                conn.close();
                conn= null;
            }catch (SQLException e) {
                System.out.println("Error while closing connection");
            }
        }
    }

}
