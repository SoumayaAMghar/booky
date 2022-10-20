package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IRateDAO;
import com.sakamaya.booky.model.Rate;
import com.sakamaya.booky.model.enums.RoomTypes;
import com.sakamaya.booky.visitor.DeserializeVisitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class RateDAO extends BaseDAO<Rate> implements IRateDAO {
    public RateDAO() {
        super(Rate.class);
    }

    @Override
    public List<Rate> findAllByRoomType(RoomTypes roomType) {
        return findAll("room_type", roomType);
    }

    @Override
    public Rate findRateForDate(RoomTypes roomType, Date date) {
        String query = "SELECT * FROM rates WHERE type = ? AND start_date >= ? AND end_date <= ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roomType.toString());
            statement.setDate(2, new java.sql.Date(date.getTime()));
            statement.setDate(3, new java.sql.Date(date.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Rate rate = new Rate();
                rate.accept(DeserializeVisitor.getInstance(), resultSet);
                return rate;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
