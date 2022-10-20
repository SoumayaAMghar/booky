package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IReservationDAO;
import com.sakamaya.booky.model.Reservation;
import com.sakamaya.booky.model.enums.ReservationStatus;

import java.util.List;

public class ReservationDAO extends BaseDAO<Reservation> implements IReservationDAO {
    public ReservationDAO() {
        super(Reservation.class);
    }

    @Override
    public List<Reservation> findAllByRoomId(int roomId) {
        return findAll("room_id", roomId);
    }

    @Override
    public List<Reservation> findAllByUserId(int userId) {
        return findAll("user_id", userId);
    }

    @Override
    public List<Reservation> findAllByStatus(ReservationStatus status) {
        return findAll("status", status.name());
    }
}
