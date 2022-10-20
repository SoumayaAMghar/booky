package com.sakamaya.booky.dao.interfaces;

import java.util.List;

public interface IDAO<T> {
    boolean save(T t);

    boolean update(T t);

    boolean delete(int id);

    T find(int id);

    List<T> findAll(String key, Object value);

    List<T> getAll();

    int count();
}
