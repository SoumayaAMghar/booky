package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.Reservation;
import com.sakamaya.booky.model.enums.ReservationStatus;

import java.util.List;

public interface IReservationDAO extends IDAO<Reservation> {
    List<Reservation> findAllByRoomId(int roomId);

    List<Reservation> findAllByUserId(int userId);

    List<Reservation> findAllByStatus(ReservationStatus status);
}
