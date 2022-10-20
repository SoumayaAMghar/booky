package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IRoomImageDAO;
import com.sakamaya.booky.model.RoomImage;

import java.util.List;

public class RoomImageDAO extends BaseDAO<RoomImage> implements IRoomImageDAO {
    public RoomImageDAO() {
        super(RoomImage.class);
    }

    public List<RoomImage> findAllByRoomId(int roomId) {
        return findAll("roomId", roomId);
    }
}
