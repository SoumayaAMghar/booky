package com.sakamaya.booky.visitor;

import com.sakamaya.booky.dao.*;
import com.sakamaya.booky.model.*;
import com.sakamaya.booky.model.enums.*;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeserializeVisitor implements IDeserializeVisitor {
    private static DeserializeVisitor instance;
    private UserDAO userDAO;
    private RoomDAO roomDAO;
    private ReservationDAO reservationDAO;
    private DeserializeVisitor() {}

    public static DeserializeVisitor getInstance() {
        if (instance == null) {
            instance = new DeserializeVisitor();
        }
        return instance;
    }

    public static void setDAOs(UserDAO userDAO, RoomDAO roomDAO, ReservationDAO reservationDAO) {
        getInstance().userDAO = userDAO;
        getInstance().roomDAO = roomDAO;
        getInstance().reservationDAO = reservationDAO;
    }

    @Override
    public void visit(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setUsername(resultSet.getString("username"));
        user.setCin(resultSet.getString("cin"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(UserRoles.valueOf(resultSet.getString("role")));
    }

    @Override
    public void visit(Room room, ResultSet resultSet) throws SQLException {
        room.setId(resultSet.getInt("id"));
        room.setNumber(resultSet.getInt("number"));
        room.setFloor(resultSet.getInt("floor"));
        room.setType(RoomTypes.valueOf(resultSet.getString("type")));
        room.setDescription(resultSet.getString("description"));
    }

    @Override
    public void visit(RoomImage roomImage, ResultSet resultSet) throws SQLException {
        roomImage.setId(resultSet.getInt("id"));
        roomImage.setUrl(resultSet.getString("url"));
        roomImage.setRoom(roomDAO.find(resultSet.getInt("room_id")));
    }

    @Override
    public void visit(Reservation reservation, ResultSet resultSet) throws SQLException {
        reservation.setId(resultSet.getInt("id"));
        reservation.setUser(userDAO.find(resultSet.getInt("user_id")));
        reservation.setRoom(roomDAO.find(resultSet.getInt("room_id")));
        reservation.setStartDate(resultSet.getDate("start_date"));
        reservation.setEndDate(resultSet.getDate("end_date"));
        reservation.setStatus(ReservationStatus.valueOf(resultSet.getString("status")));
    }

    @Override
    public void visit(Extra extra, ResultSet resultSet) throws SQLException {
        extra.setId(resultSet.getInt("id"));
        extra.setType(ExtraTypes.valueOf(resultSet.getString("type")));
        extra.setPrice(resultSet.getDouble("price"));
    }

    @Override
    public void visit(Payment payment, ResultSet resultSet) throws SQLException {
        payment.setId(resultSet.getInt("id"));
        payment.setDate(resultSet.getDate("date"));
        payment.setTotal(resultSet.getDouble("total"));
        payment.setType(PaymentTypes.valueOf(resultSet.getString("type")));
        payment.setReservation(reservationDAO.find(resultSet.getInt("reservation_id")));
    }

    @Override
    public void visit(Rate rate, ResultSet resultSet) throws SQLException {
        rate.setId(resultSet.getInt("id"));
        rate.setType(RoomTypes.valueOf(resultSet.getString("room_type")));
        rate.setPrice(resultSet.getDouble("price"));
        rate.setStartDate(resultSet.getDate("start_date"));
        rate.setEndDate(resultSet.getDate("end_date"));
    }

    @Override
    public void visit(Promotion promotion, ResultSet resultSet) throws SQLException {
        promotion.setId(resultSet.getInt("id"));
        promotion.setType(RoomTypes.valueOf(resultSet.getString("type")));
        promotion.setReduction(resultSet.getDouble("discount"));
        promotion.setStartDate(resultSet.getDate("start_date"));
        promotion.setEndDate(resultSet.getDate("end_date"));
    }
}