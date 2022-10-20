package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.Promotion;
import com.sakamaya.booky.model.enums.RoomTypes;

import java.util.Date;
import java.util.List;

public interface IPromotionDAO extends IDAO<Promotion> {
    Promotion findActivePromotionForTypeInDate(RoomTypes type, Date date);
    List<Promotion> findAllActivePromotionsInDate(Date date);
}
