package com.grupp3.hairbook;

public class UserModel {

    private String name;
    private boolean hasBadHairDay;

    public UserModel(){}
    public UserModel(String name, boolean hasBadHairDay) {
        this.name = name;
        this.hasBadHairDay = hasBadHairDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasBadHairDay() {
        return hasBadHairDay;
    }

    public void setHasBadHairDay(boolean hasBadHairDay) {
        this.hasBadHairDay = hasBadHairDay;
    }
}
