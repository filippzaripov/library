package com.fujitsu.internship.service;

import com.fujitsu.internship.dao.CategoriesDAO;
import com.fujitsu.internship.dao.pg.PostgreSQLCategoriesDAO;
import com.fujitsu.internship.model.BookCategory;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoriesDAO categoriesDAO = new PostgreSQLCategoriesDAO();

    @Override
    public List<BookCategory> getAllBookCategories() {
        return categoriesDAO.getAllCategories();
    }
}
