package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IUserDAO;
import com.sakamaya.booky.model.User;

public class UserDAO extends BaseDAO<User> implements IUserDAO {

    public UserDAO() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        return find("username", username);
    }

    @Override
    public User findByCIN(String cin) {
        return find("cin", cin);
    }
}
