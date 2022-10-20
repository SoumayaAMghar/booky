package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IPromotionDAO;
import com.sakamaya.booky.model.Promotion;
import com.sakamaya.booky.model.enums.RoomTypes;
import com.sakamaya.booky.visitor.DeserializeVisitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionDAO extends BaseDAO<Promotion> implements IPromotionDAO {
    public PromotionDAO() {
        super(Promotion.class);
    }

    @Override
    public Promotion findActivePromotionForTypeInDate(RoomTypes type, Date date) {
        String query = "SELECT * FROM promotions WHERE type = ? AND start_date >= ? AND end_date <= ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, type.name());
            statement.setDate(2, new java.sql.Date(date.getTime()));
            statement.setDate(3, new java.sql.Date(date.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Promotion promotion = new Promotion();
                promotion.accept(DeserializeVisitor.getInstance(), resultSet);
                return promotion;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Promotion> findAllActivePromotionsInDate(Date date) {
        String query = "SELECT * FROM promotions WHERE start_date >= ? AND end_date <= ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, new java.sql.Date(date.getTime()));
            statement.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Promotion> promotions = new ArrayList<>();
            while (resultSet.next()) {
                Promotion promotion = new Promotion();
                promotion.accept(DeserializeVisitor.getInstance(), resultSet);
                promotions.add(promotion);
            }
            return promotions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
