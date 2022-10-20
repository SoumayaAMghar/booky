package com.sakamaya.booky.model;

import com.sakamaya.booky.model.enums.PaymentTypes;
import com.sakamaya.booky.model.interfaces.*;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;

public class Payment implements ISerializable, IDeserializable {
    private int id;
    private Reservation reservation;
    private Date date;
    private double total;
    private PaymentTypes type;

    public Payment(Reservation reservation, Date date, double total, PaymentTypes type) {
        this.reservation = reservation;
        this.date = date;
        this.total = total;
        this.type = type;
    }

    public Payment() {}

    public int getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Date getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }

    public PaymentTypes getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setType(PaymentTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", reservation=" + reservation.getStartDate().toString() +
                " - " + reservation.getEndDate().toString() +
                ", date=" + date +
                ", total=" + total +
                ", type=" + type +
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
