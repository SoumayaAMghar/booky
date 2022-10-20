package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IDAO;
import com.sakamaya.booky.model.interfaces.*;
import com.sakamaya.booky.visitor.DeserializeVisitor;
import com.sakamaya.booky.visitor.SerializeVisitor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class BaseDAO<T extends ISerializable & IDeserializable> implements IDAO<T> {
    protected final Connection connection;
    protected final String tableName;
    protected final Class<T> type;

    public BaseDAO(Class<T> clazz) {
        this.connection = MySQLConnection.getConnection();
        this.tableName = clazz.getSimpleName().toLowerCase() + "s";
        this.type = clazz;
    }

    @Override
    public T find(int id) {
        return find("id", id);
    }

    protected T find(String key, Object value) {
        String query = "SELECT * FROM " + tableName + " WHERE " + key + " = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (value instanceof String) {
                statement.setString(1, (String) value);
            } else if (value instanceof Integer) {
                statement.setInt(1, (Integer) value);
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                T t = type.getDeclaredConstructor().newInstance();
                t.accept(DeserializeVisitor.getInstance(), resultSet);
                return t;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<T> findAll(String key, Object value) {
        String query = "SELECT * FROM " + tableName + " WHERE " + key + " = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (value instanceof String) {
                statement.setString(1, (String) value);
            } else if (value instanceof Integer) {
                statement.setInt(1, (Integer) value);
            }
            ResultSet resultSet = statement.executeQuery();
            List<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = type.getDeclaredConstructor().newInstance();
                t.accept(DeserializeVisitor.getInstance(), resultSet);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        ArrayList<T> ts = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T t = type.getDeclaredConstructor().newInstance();
                t.accept(DeserializeVisitor.getInstance(), resultSet);
                ts.add(t);
            }
            return ts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(T t) {
        HashMap<String, Object> map = t.accept(SerializeVisitor.getInstance());
        map.remove("id");
        String fields = String.join(",", map.keySet());
        String[] placeholders = new String[map.size()];
        Arrays.fill(placeholders, "?");

        String query = "INSERT INTO "+ tableName +" (" + fields + ") VALUES (" + String.join(",", placeholders) + ")";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            fillStatement(map, statement);
            return statement.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(T t) {
        HashMap<String, Object> map = t.accept(SerializeVisitor.getInstance());
        int id = (int) map.get("id");
        map.remove("id");

        String fields = String.join(" = ?,", map.keySet()) + " = ?";
        String query = "UPDATE " + tableName + " SET " + fields + " WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            fillStatement(map, statement);
            statement.setInt(map.size() + 1, id);
            return statement.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void fillStatement(HashMap<String, Object> map, PreparedStatement statement) throws SQLException {
        int i = 1;
        for (Object value : map.values()) {
            switch (value.getClass().getSimpleName()) {
                case "String" -> statement.setString(i, (String) value);
                case "Integer" -> statement.setInt(i, (Integer) value);
                case "Double" -> statement.setDouble(i, (Double) value);
                case "Date" -> statement.setDate(i, java.sql.Date.valueOf((java.time.LocalDate) value));
                case "Boolean" -> statement.setBoolean(i, (Boolean) value);
                default -> statement.setNull(i, Types.VARCHAR);
            }
            i++;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return statement.getUpdateCount() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            return statement.executeQuery().getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
