package com.fujitsu.internship.dao.pg;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class creating connection to PostgreSQL Database
 * @author Filipp Zaripov
 */

//TODO:Make connector singleton

public class PostgreSQLConnector {
    private static Logger log = LoggerFactory.getLogger(PostgreSQLConnector.class);
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

        }catch (ClassNotFoundException e){
            //TODO: "change to: pease check driver"
            log.error("ClassNotFound Exception in PostgreSQLConnector class", e);
        }catch (SQLException e){
            //TODO:Throw exception higher
            log.error("SQL Exception in PostgreSQLConnector class", e);
        }
    return connection;
    }
}
