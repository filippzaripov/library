package com.fujitsu.internship.dao;

import com.fujitsu.internship.model.User;

import java.util.List;

/**
 * interface to manipulate with users
 *
 * @see com.fujitsu.internship.dao.GenericDAO
 * Each method throws DataAccessException
 */
public interface UserDao extends GenericDAO<User> {

    /**
     * @return all users from storage
     */
    List<User> getAll() ;

    /**
     * finds user in storage by name
     *
     * @param name name of user that should be found
     * @return user object {@code null} if wasn't found
     */
    User findByName(String name) ;
}
