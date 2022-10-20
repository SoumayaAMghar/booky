package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.User;

public interface IUserDAO extends IDAO<User> {
    User findByUsername(String username);

    User findByCIN(String cin);
}
