package com.fujitsu.internship.service;

import com.fujitsu.internship.dao.DataAccessException;
import com.fujitsu.internship.dao.pg.PostgreSQLConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * That class is use to validate all data that user enter in form before making database query.
 *
 * @author Filipp Zaripov
 */
public class Validator {
    private static Logger log = LoggerFactory.getLogger(Validator.class);
    /**
     * connector that uses to connect to Database
     */
    protected PostgreSQLConnector connector = PostgreSQLConnector.getConnector();

    /**
     * validates name of the category by regular expression
     *
     * @param category_name name of the book category
     * @return true if valid, else - false
     */
    /*private boolean categoryNameValidate(String category_name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+");
        Matcher m = pattern.matcher(category_name);
        return m.matches();
    }*/

    /**
     * validates book name by regular expression
     *
     * @param bookName name of the book
     * @return true if valid, else - false
     */
    private boolean bookNameValidate(String bookName) {
       /* Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s\\?\\!\\.]+");
        Matcher m = pattern.matcher(bookName);
        return m.matches();*/
        return true;
    }

    /**
     * Validates input parameters before creating new book
     *
     * @param bookName name of the book
     * @param category name of the book category
     * @return true if valid, else - false
     */
    public boolean validateNewBookField(String bookName, String category) {

        if (bookNameValidate(bookName)) {
            return true;
        }else{
            return false;
        }

    }

    /**
     * Validates if entered id is correct before execute SQL request and search if book with this id exists
     *
     * @param idFromField id entered by user
     * @return true if valid, else - false
     */
    public boolean isIDCorrect(Long idFromField) {
        try (Connection connection = connector.getConnection()) {
            if (idFromField > 0 && idFromField < 9223372036854775807L) {
                try {
                    PreparedStatement stmt = connection.prepareStatement("SELECT id FROM books WHERE id = ?");
                    stmt.setLong(1, idFromField);
                    ResultSet rs = stmt.executeQuery();
                    long idFromBookDB = -1;
                    if (rs.next()) {
                        idFromBookDB = rs.getLong("id");
                        if (idFromBookDB == idFromField) {
                            return true;
                        }
                    } else {
                        return false;
                    }
                } catch (SQLException e) {
                    throw new DataAccessException("SQL Exception while checking ID", e);
                }
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while close connection while validate ID of the book", e);
        }

        return false;
    }
}
