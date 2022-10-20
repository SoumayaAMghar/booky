package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.RoomImage;

import java.util.List;

public interface IRoomImageDAO extends IDAO<RoomImage> {
    List<RoomImage> findAllByRoomId(int roomId);
}
