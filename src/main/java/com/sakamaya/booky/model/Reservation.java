package com.sakamaya.booky.model;

import com.sakamaya.booky.model.enums.ReservationStatus;
import com.sakamaya.booky.model.interfaces.*;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;

public class Reservation implements ISerializable, IDeserializable {
    private int id;
    private User user;
    private Room room;
    private Date startDate;
    private Date endDate;
    private ReservationStatus status;

    public Reservation() {
    }

    public Reservation(User user, Room room, Date startDate, Date endDate, ReservationStatus status) {
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public HashMap<String, Object> accept(ISerializeVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public void accept(IDeserializeVisitor visitor, ResultSet resultSet) {
        try {
            visitor.visit(this, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
