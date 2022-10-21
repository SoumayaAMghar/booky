package com.sakamaya.booky.visitor.interfaces;

import com.sakamaya.booky.model.*;

import java.util.HashMap;

public interface ISerializeVisitor {
    HashMap<String, Object> visit(User user);

    HashMap<String, Object> visit(Room room);

    HashMap<String, Object> visit(RoomImage roomImage);

    HashMap<String, Object> visit(Reservation reservation);

    HashMap<String, Object> visit(Extra extra);

    HashMap<String, Object> visit(Payment payment);

    HashMap<String, Object> visit(Rate rate);

    HashMap<String, Object> visit(Promotion promotion);
}
