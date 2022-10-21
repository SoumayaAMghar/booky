package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.Room;
import com.sakamaya.booky.model.enums.RoomTypes;

import java.util.List;

public interface IRoomDAO extends IDAO<Room> {
    Room findByNumber(String number);

    List<Room> findAllByType(RoomTypes type);
}
