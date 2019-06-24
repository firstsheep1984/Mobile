package com.example.phonebook.model;

import com.example.phonebook.R;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    private String name;
    private String family;
    private String phone;
    private String email;
    private String address;
    private int imageResourceId;

    public Person(String name, String family, String phone, String email,  String address, int imageResourceId) {
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
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
        return getName() + " " + getFamily();
    }
    public static Person[] personList = {
            new Person("Fire","fighter","5144444555", "fire@gmail.com","111 Street Jisl, QC",R.drawable.fire_fighter),
            new Person("Patric","Sang","5144678555", "patrick@gmail.com","123 Street Jisl, QC",R.drawable.patric),
            new Person("Sponge","Bob","514446666", "sponge@gmail.com","189 Street Jisl, QC",R.drawable.sponjbob),


    };

//fixme


    @Override
    public int compare(Person p1, Person p2) {
        return (p1.getFamily().compareTo(p2.getFamily()));
    }
}
