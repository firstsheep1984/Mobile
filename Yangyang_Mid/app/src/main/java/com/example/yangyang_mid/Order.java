package com.example.yangyang_mid;

import java.io.Serializable;

public class Order implements Serializable {
   private String name;
   private String food;
   private String address;

    public Order(String name, String food) {
        this.name = name;
        this.food = food;
    }

    public Order(String name, String food, String address) {
        this.name = name;
        this.food = food;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
