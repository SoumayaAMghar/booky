package com.sakamaya.booky.model;

import com.sakamaya.booky.model.interfaces.*;
import com.sakamaya.booky.model.enums.UserRoles;
import com.sakamaya.booky.visitor.interfaces.IDeserializeVisitor;
import com.sakamaya.booky.visitor.interfaces.ISerializeVisitor;

import java.sql.ResultSet;
import java.util.HashMap;

public class User implements ISerializable, IDeserializable {
    private int id;
    private String username;
    private String password;
    private String cin;
    private String name;
    private UserRoles role;

    public User() {
    }

    public User(String username, String password, String cin, String name, UserRoles role) {
        this.username = username;
        this.password = password;
        this.cin = cin;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cin='" + cin + '\'' +
                ", role=" + role +
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
