package com.saidur.bari.model;

import java.util.List;

public class Floor {
    String floor_name;
    List<Unit> unitList;

    public Floor() {
    }

    public String getFloor_name() {
        return floor_name;
    }

    public void setFloor_name(String floor_name) {
        this.floor_name = floor_name;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }
}
