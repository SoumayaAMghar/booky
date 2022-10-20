package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IExtraDAO;
import com.sakamaya.booky.model.Extra;
import com.sakamaya.booky.visitor.DeserializeVisitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExtraDAO extends BaseDAO<Extra> implements IExtraDAO {
    public ExtraDAO() {
        super(Extra.class);
    }

    @Override
    public List<Extra> findAllByReservationId(int reservationId) {
        String query = "SELECT * FROM reservation_extras WHERE reservation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservationId);
            ResultSet resultSet = statement.executeQuery();
            List<Extra> extras = new ArrayList<>();
            while (resultSet.next()) {
                Extra extra = new Extra();
                extra.accept(DeserializeVisitor.getInstance(), resultSet);
                extras.add(extra);
            }
            return extras;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
