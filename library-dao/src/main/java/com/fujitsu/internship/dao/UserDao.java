package com.fujitsu.internship.dao;

import com.fujitsu.internship.model.User;

import java.util.List;

/**
 * interface to manipulate with users
 *
 * @see com.fujitsu.internship.dao.GenericDAO
 */
public interface UserDao extends GenericDAO<User>{
    @Override
    User create(User entity);

    @Override
    User get(Long id);

    @Override
    boolean delete(long id);

    List<User> getAll();
}
