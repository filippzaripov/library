package dao.pg;

import java.sql.*;
import java.util.ArrayList;
import org.postgresql.Driver;

/**
 * This class creating connection to PostgreSQL Database
 * @author Filipp Zaripov
 */
public class PostgreSQLConnector {
    /** This field is connection to database */
    private Connection connection = null;

    /**
     * This method creates and returns connection to Database
     * @return connection to PostgreSQL Library Database
     */
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
