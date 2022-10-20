package com.sakamaya.booky.model;

import com.sakamaya.booky.model.enums.RoomTypes;
import com.sakamaya.booky.model.interfaces.IDeserializable;
import com.sakamaya.booky.model.interfaces.ISerializable;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;

public class Promotion implements ISerializable, IDeserializable {
    private int id;
    private RoomTypes type;
    private double reduction;
    private Date startDate;
    private Date endDate;

    public Promotion() {}

    public Promotion(RoomTypes type, double reduction, Date startDate, Date endDate) {
        this.type = type;
        this.reduction = reduction;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public RoomTypes getType() {
        return type;
    }

    public double getReduction() {
        return reduction;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(RoomTypes type) {
        this.type = type;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
