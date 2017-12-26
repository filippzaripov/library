package com.fujitsu.internship;

import java.sql.*;

import org.postgresql.*;
import org.postgresql.Driver;

public class PostgreSQLConnector {

    public static Connection connection = null;

    public static void main(String[] args) {
        PostgreSQLConnector.getConnection();
    }

    public static final void getPostgreSQLDriver() throws Exception{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Library";
        String login = "db_admin";
        String password = "admin";
    }
    public static final Connection getConnection(){

        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Library";
            String login = "db_admin";
            String password = "admin";

            connection  = DriverManager.getConnection(url, login, password);
            /*try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM books WHERE ID = " + 1);
                //System.out.println(rs);
                System.out.println("ID" + " | " + "NAME");
                while (rs.next()){
                    String str = rs.getString("ID") + " | " + rs.getString("name");
                    System.out.println(str);
                }
                rs.close();
                stmt.close();
            }  finally {
                connection.close();
            }*/

        }catch (Exception e){
            e.printStackTrace();
        }
    return connection;
    }

}
