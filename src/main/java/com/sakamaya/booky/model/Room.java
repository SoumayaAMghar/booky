package com.sakamaya.booky.model;

import com.sakamaya.booky.model.enums.RoomTypes;
import com.sakamaya.booky.model.interfaces.*;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.sql.ResultSet;
import java.util.HashMap;

public class Room implements IDeserializable, ISerializable {
    private int id;
    private RoomTypes type;
    private int number;
    private int floor;
    private String description;

    public Room() {
    }

    public Room(RoomTypes type, int number, int floor, String description) {
        this.type = type;
        this.number = number;
        this.floor = floor;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomTypes getType() {
        return type;
    }

    public void setType(RoomTypes type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type=" + type +
                ", number=" + number +
                ", floor=" + floor +
                ", description='" + description + '\'' +
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
