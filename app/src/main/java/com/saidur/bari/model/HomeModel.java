package com.saidur.bari.model;

import java.util.List;

public class HomeModel {
    String h_name,h_add,h_owner,h_owphn,h_id,h_pin;
    List<Floor> floorList;

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public HomeModel() {
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_add() {
        return h_add;
    }

    public void setH_add(String h_add) {
        this.h_add = h_add;
    }

    public String getH_owner() {
        return h_owner;
    }

    public void setH_owner(String h_owner) {
        this.h_owner = h_owner;
    }

    public String getH_owphn() {
        return h_owphn;
    }

    public void setH_owphn(String h_owphn) {
        this.h_owphn = h_owphn;
    }

    public String getH_id() {
        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getH_pin() {
        return h_pin;
    }

    public void setH_pin(String h_pin) {
        this.h_pin = h_pin;
    }
}
