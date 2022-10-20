package com.sakamaya.booky.dao.interfaces;

import java.util.List;

public interface IDAO<T> {
    public boolean save(T t);
    public boolean update(T t);
    public boolean delete(int id);
    public T find(int id);
    public List<T> findAll(String key, Object value);
    public List<T> getAll();
    public int count();
}
