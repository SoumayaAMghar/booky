package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.Extra;

import java.util.List;

public interface IExtraDAO extends IDAO<Extra> {
    List<Extra> findAllByReservationId(int reservationId);
}
