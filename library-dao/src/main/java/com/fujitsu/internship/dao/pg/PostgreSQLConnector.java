package com.fujitsu.internship.dao.pg;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import com.fujitsu.internship.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class creating connection to PostgreSQL Database
 *
 * @author Filipp Zaripov
 */

public class PostgreSQLConnector {
    private static Logger log = LoggerFactory.getLogger(PostgreSQLConnector.class);
    private static volatile PostgreSQLConnector connector;

    private PostgreSQLConnector() {
    }

    /**
     * creates and returns connection to Database
     *
     * @return connection to PostgreSQL Library Database
     */
    public static PostgreSQLConnector getConnector() {
        PostgreSQLConnector localConnector = connector;
        if (localConnector == null) {
            synchronized (PostgreSQLConnector.class) {
                localConnector = connector;
                if (localConnector == null) {
                    connector = localConnector = new PostgreSQLConnector();
                }
            }
        }
        return localConnector;
    }

    public Connection getConnection(){
        Connection connection = null;
        Properties prop = new Properties();
        InputStream input = null;
        try {
            prop.load(getClass().getResourceAsStream("/jdbc.properties"));
            Class.forName(prop.getProperty("database.driver"));
            String url = prop.getProperty("database.url");
            String login = prop.getProperty("database.login");
            String password = prop.getProperty("database.password");
            connection = DriverManager.getConnection(url, login, password);

        } catch (ClassNotFoundException e) {
            log.error("Please check database driver", e);
        } catch (IOException e) {
            log.error("Please check jdbc.properties file", e);
        } catch (SQLException e) {
            throw new DataAccessException("Could not connect to PostgreSQL DB", e);
        } finally {
            if(input != null){
                try {
                    input.close();
                }catch (IOException e){
                    throw new DataAccessException("Exception while closing connection to jdbc.properties", e);
                }
            }
        }
        return connection;
    }
}
