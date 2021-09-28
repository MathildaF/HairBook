package com.grupp3.hairbook;

import java.util.concurrent.atomic.AtomicLong;

public class User {

    private static final AtomicLong idGenerator = new AtomicLong(1);
    private long id;
    private String name;
    private boolean hasBadHairDay;
//    private String email;
//    private String password;

    public User(String name, boolean hasBadHairDay) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.hasBadHairDay = hasBadHairDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

}
