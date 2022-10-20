package com.sakamaya.booky.model;

import com.sakamaya.booky.model.enums.ExtraTypes;
import com.sakamaya.booky.model.interfaces.IDeserializable;
import com.sakamaya.booky.model.interfaces.ISerializable;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.sql.ResultSet;
import java.util.HashMap;

public class Extra implements ISerializable, IDeserializable {
    private int id;
    private ExtraTypes type;
    private double price;

    public Extra() {
    }

    public Extra(ExtraTypes type, double price) {
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExtraTypes getType() {
        return type;
    }

    public void setType(ExtraTypes type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
