package com.sakamaya.booky.model.interfaces;

import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;

import java.sql.ResultSet;

public interface IDeserializable {
    void accept(IDeserializeVisitor visitor, ResultSet resultSet);
}
