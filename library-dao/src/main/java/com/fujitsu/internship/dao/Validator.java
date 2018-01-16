package com.fujitsu.internship.dao;

import com.fujitsu.internship.dao.pg.PostgreSQLConnector;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    PostgreSQLConnector connector = PostgreSQLConnector.getConnector();

    /**
     * validates name of the category by regular expression
     *
     * @param category_name name of the book category
     * @return true if valid, else - false
     */
    private boolean categoryNameValidate(String category_name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+");
        Matcher m = pattern.matcher(category_name);

        return m.matches();
    }

    /**
     * validates book name by regular expression
     *
     * @param book_name name of the book
     * @return true if valid, else - false
     */
    private boolean bookNameValidate(String book_name) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s\\?\\!\\.]+");
        Matcher m = pattern.matcher(book_name);

        return m.matches();
    }

    /**
     * Validates input parameters before creating new book
     *
     * @param book_name name of the book
     * @param category  name of the book category
     * @return true if valid, else - false
     */
    public boolean validateNewBookField(String book_name, String category) {
        Connection connection = connector.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT category_name FROM books_cat WHERE category_name=?");
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            String category_name = null;
            while (rs.next()) {
                category_name = rs.getString("category_name");
            }
            try {
                if (!category_name.equals(null) && categoryNameValidate(category_name) && bookNameValidate(book_name)) {
                    return true;
                }
            } catch (NullPointerException e) {
                throw new DataAccessException("Category name is not correct", e);
            }
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while validate new book data", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                 throw new DataAccessException("SQL Exception while close connection while validate new book data", e);
            }
        }
        return false;
    }

    /**
     * Validates if entered id is correct before execute SQL request
     *
     * @param idFromField id entered by user
     * @return true if valid, else - false
     */
    public boolean isIDCorrect(String idFromField) {
        Connection connection = connector.getConnection();
        if (StringUtils.isNumeric(idFromField)) {
            Long id = Long.parseLong(idFromField);
            try {
                if (id > 0 && id < 9223372036854775807L) {
                    try {
                        PreparedStatement stmt = connection.prepareStatement("SELECT id FROM books WHERE id = ?");
                        stmt.setLong(1, id);
                        ResultSet rs = stmt.executeQuery();
                        long idFromBookDB = -1;
                        if (!rs.isBeforeFirst()) {
                            return false;
                        } else {
                            while (rs.next()) {
                                idFromBookDB = rs.getLong("id");
                            }
                            if (idFromBookDB == id) {
                                return true;
                            }
                        }
                    } catch (SQLException e) {
                        throw new DataAccessException("SQL Exception while checking ID", e);
                    }
                } else {
                    return false;
                }
            } catch (NullPointerException e) {
                throw new DataAccessException("ID for deletion is null!", e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DataAccessException("SQL Exception while close connection while validate ID of the book", e);
                }
            }
        }
        return false;
    }
}
