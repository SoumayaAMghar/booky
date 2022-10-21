package com.sakamaya.booky.visitor;

import com.sakamaya.booky.model.*;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.util.HashMap;


public class SerializeVisitor implements ISerializeVisitor {
    private static SerializeVisitor instance;
    private SerializeVisitor() {}

    public static SerializeVisitor getInstance() {
        if (instance == null) {
            instance = new SerializeVisitor();
        }
        return instance;
    }

    @Override
    public HashMap<String, Object> visit(User user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("username", user.getUsername());
        map.put("cin", user.getCin());
        map.put("password", user.getPassword());
        map.put("role", user.getRole().name());

        return map;
    }

    @Override
    public HashMap<String, Object> visit(Room room) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", room.getId());
        map.put("number", room.getNumber());
        map.put("floor", room.getFloor());
        map.put("type", room.getType().name());
        map.put("description", room.getDescription());

        return map;
    }

    @Override
    public HashMap<String, Object> visit(RoomImage roomImage) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", roomImage.getId());
        map.put("url", roomImage.getUrl());
        map.put("room_id", roomImage.getRoom().getId());

        return map;
    }

    @Override
    public HashMap<String, Object> visit(Reservation reservation) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", reservation.getId());
        map.put("user_id", reservation.getUser().getId());
        map.put("room_id", reservation.getRoom().getId());
        map.put("start_date", reservation.getStartDate());
        map.put("end_date", reservation.getEndDate());
        map.put("status", reservation.getStatus().name());

        return map;
    }

    @Override
    public HashMap<String, Object> visit(Extra extra) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", extra.getId());
        map.put("type", extra.getType().name());
        map.put("price", extra.getPrice());

        return map;
    }

    @Override
    public HashMap<String, Object> visit(Payment payment) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", payment.getId());
        map.put("reservation_id", payment.getReservation().getId());
        map.put("date", payment.getDate());
        map.put("type", payment.getType().name());
        map.put("total", payment.getTotal());

        return map;
    }

    @Override
    public HashMap<String, Object> visit(Rate rate) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", rate.getId());
        map.put("type", rate.getType().name());
        map.put("price", rate.getPrice());
        map.put("start_date", rate.getStartDate());
        map.put("end_date", rate.getEndDate());

        return map;
    }

    @Override
    public HashMap<String, Object> visit(Promotion promotion) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", promotion.getId());
        map.put("type", promotion.getType().name());
        map.put("reduction", promotion.getReduction());
        map.put("start_date", promotion.getStartDate());
        map.put("end_date", promotion.getEndDate());

        return map;
    }
}
