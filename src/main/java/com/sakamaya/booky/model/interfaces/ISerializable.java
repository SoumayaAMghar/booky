package com.sakamaya.booky.model.interfaces;

import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.util.HashMap;

public interface ISerializable {
    HashMap<String, Object> accept(ISerializeVisitor visitor);
}
