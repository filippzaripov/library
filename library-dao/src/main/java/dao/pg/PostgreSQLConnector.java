package dao.pg;

import java.sql.*;
import java.util.ArrayList;
import org.postgresql.Driver;

public class PostgreSQLConnector {

    private Connection connection = null;

    public Connection getConnection(){

        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Library";
            String login = "db_admin";
            String password = "admin";
            connection  = DriverManager.getConnection(url, login, password);

        }catch (Exception e){
            e.printStackTrace();
        }
    return connection;
    }
}
