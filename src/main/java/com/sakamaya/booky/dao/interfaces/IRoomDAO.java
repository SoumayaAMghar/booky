package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.Room;

import java.util.List;

public interface IRoomDAO extends IDAO<Room> {
    Room findByNumber(String number);

    List<Room> findAllByType(String type);
}
