package com.sakamaya.booky.model;

import com.sakamaya.booky.model.interfaces.*;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.sql.ResultSet;
import java.util.HashMap;

public class RoomImage implements IDeserializable, ISerializable {
    private int id;
    private Room room;
    private String url;

    public RoomImage() {
    }

    public RoomImage(Room room, String url) {
        this.room = room;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RoomImage{" +
                "id=" + id +
                ", room=" + room.getType() +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public void accept(IDeserializeVisitor visitor, ResultSet resultSet) {
        try {
            visitor.visit(this, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<String, Object> accept(ISerializeVisitor visitor) {
        return visitor.visit(this);
    }
}
