package com.example.pyatiminutka.Models.items;

public class UserItem {
    public String id, name;
    public int points;

    public UserItem(){

    }

    public UserItem(String id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
