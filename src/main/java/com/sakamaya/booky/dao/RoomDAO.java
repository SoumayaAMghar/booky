package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IRoomDAO;
import com.sakamaya.booky.model.Room;
import com.sakamaya.booky.model.enums.RoomTypes;

import java.util.List;

public class RoomDAO extends BaseDAO<Room> implements IRoomDAO {
    public RoomDAO() {
        super(Room.class);
    }

    @Override
    public Room findByNumber(String number) {
        return find("number", number);
    }

    @Override
    public List<Room> findAllByType(RoomTypes type) {
        return findAll("type", type.name());
    }
}
