package com.fujitsu.internship.dao.pg;

import com.fujitsu.internship.dao.CategoriesDAO;
import com.fujitsu.internship.dao.DataAccessException;
import com.fujitsu.internship.model.BookCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLCategoriesDAO implements CategoriesDAO {
    protected PostgreSQLConnector connector = PostgreSQLConnector.getConnector();

    @Override
    public List<BookCategory> getAllCategories() {
        List<BookCategory> bookCategoryList = new ArrayList();
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT category_name FROM books_cat ORDER BY id");
        ) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookCategoryList.add(new BookCategory(rs.getString("category_name")));
            }
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while get all books", e);
        }
        return bookCategoryList;
    }

    @Override
    public BookCategory create(BookCategory entity) {
        return null;
    }

    @Override
    public BookCategory get(Long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
