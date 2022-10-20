package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.Rate;
import com.sakamaya.booky.model.enums.RoomTypes;

import java.util.Date;
import java.util.List;

public interface IRateDAO extends IDAO<Rate> {
    List<Rate> findAllByRoomType(RoomTypes roomType);
    Rate findRateForDate(RoomTypes roomType, Date date);
}
