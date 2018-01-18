package com.fujitsu.internship.dao.pg;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import com.fujitsu.internship.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;

/**
 * This class creating connection to PostgreSQL Database
 *
 * @author Filipp Zaripov
 */

public class PostgreSQLConnector {
    private static Logger log = LoggerFactory.getLogger(PostgreSQLConnector.class);
    private static volatile PostgreSQLConnector connector;
    private String url;
    private String login;
    private String password;

    /**
     * Initialise JDBC driver
     */
    private PostgreSQLConnector() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("/jdbc.properties"));
            Class.forName(prop.getProperty("database.driver"));
            this.url = prop.getProperty("database.url");
            this.login = prop.getProperty("database.login");
            this.password = prop.getProperty("database.password");
        } catch (IOException e) {
            log.error("Please check jdbc.properties file", e);
            throw new DataAccessException("Please check database driver", e);
        } catch (ClassNotFoundException e) {
            log.error("Please check database driver", e);
            throw new DataAccessException("Please check database driver", e);
        }
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

    /**
     * @return connection to Database. All unused connections should be closed.
     * @throws SQLException if connection wasn't successful
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, login, password);
            return connection;
        }catch(SQLException e){
            throw new DataAccessException("Could not connect to PostgreSQL DB", e);
        }
    }
}
