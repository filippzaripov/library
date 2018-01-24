package com.fujitsu.internship.dao;

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
     * @return object that was created, {@code null} if object wasn't created and added to storage
     */
    T create(T entity);

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
