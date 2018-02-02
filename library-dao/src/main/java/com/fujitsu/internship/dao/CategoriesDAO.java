package com.fujitsu.internship.dao;

import com.fujitsu.internship.model.BookCategory;

import java.util.List;

public interface CategoriesDAO extends GenericDAO<BookCategory> {
    /**
     * @return List of all book categories ordered by id or empty list if none was found
     */
    List<BookCategory> getAllCategories();
}
