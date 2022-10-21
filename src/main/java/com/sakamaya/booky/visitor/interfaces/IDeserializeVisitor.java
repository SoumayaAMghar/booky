package com.sakamaya.booky.visitor.interfaces;

import com.sakamaya.booky.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDeserializeVisitor {
    void visit(User user, ResultSet resultSet) throws SQLException;

    void visit(Room room, ResultSet resultSet) throws SQLException;

    void visit(RoomImage roomImage, ResultSet resultSet) throws SQLException;

    void visit(Reservation reservation, ResultSet resultSet) throws SQLException;

    void visit(Extra extra, ResultSet resultSet) throws SQLException;

    void visit(Payment payment, ResultSet resultSet) throws SQLException;

    void visit(Rate rate, ResultSet resultSet) throws SQLException;

    void visit(Promotion promotion, ResultSet resultSet) throws SQLException;
}
