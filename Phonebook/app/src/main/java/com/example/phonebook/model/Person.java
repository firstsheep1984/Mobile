package com.example.phonebook.model;

public class Person {
    private String name;
    private String phone;
    private String email;
    private String address;
    private int imageResourceId;

    public Person(String name, String phone, String email, String address, int imageResourceId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
    public static final Person[] personList = {
         //   new Person("Latte", " A couple of espresso shots with steamed milk", R.drawable.poutine),


    };
}
