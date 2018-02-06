package com.fujitsu.internship.dao;

import java.sql.SQLException;

/**
 * Generic interface for manipulation with any types of objects
 *
 * @param <T>
 */
public interface GenericDAO<T> {
    /**
     * creates object and adds to storage
     *
     * @param entity entity that should be created and added to storage (e.g. Database)
     * @return id of object that was created
     *
     */
    Long create(T entity);

    /**
     * retrieves object from storage by its id
     *
     * @param id of the object
     * @return object, {@code null} if wasn't found
     */
    T get(Long id);

    /**
     * deletes object from storage by its id
     *
     * @param id of the object
     * @return true if object was deleted successfully, else returns false
     */
    boolean delete(long id);

}
