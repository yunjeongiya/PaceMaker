package com.saomath.pacemaker.domain;

public class User {
    private String id;
    private String pw;
    private String name;

    public User(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
}