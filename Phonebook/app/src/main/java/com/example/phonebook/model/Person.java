package com.example.phonebook.model;

import android.nfc.FormatException;
import android.widget.Toast;

import com.example.phonebook.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Comparable<Person>, Serializable {
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
    public Person(){};
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

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String setEmail(String email) throws FormatException {
        if (email != null) {
            String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new FormatException("invalid email");
            }
        }
        return  email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return getName() + " " + getFamily();
    }
 /*   public static Person[] personList = {
            new Person("Fire","fighter","5144444555", "fire@gmail.com","111 Street Jisl, QC",R.drawable.fire_fighter),
            new Person("Patric","Sang","5144678555", "patrick@gmail.com","123 Street Jisl, QC",R.drawable.patric),
            new Person("Sponge","Bob","514446666", "sponge@gmail.com","189 Street Jisl, QC",R.drawable.sponjbob),
    };
*/
    public static List<Person> pList = new ArrayList<Person>(){};


  /*  {{

    pList.add(new Person("Fire","fighter","5144444555", "fire@gmail.com","111 Street Jisl, QC",R.drawable.fire_fighter));
        pList.add(new Person("Patric","Sang","5144678555", "patrick@gmail.com","123 Street Jisl, QC",R.drawable.patric));
        pList.add(new Person("Sponge","Bob","514446666", "sponge@gmail.com","189 Street Jisl, QC",R.drawable.sponjbob));
    }};
*/
    //fixme

    @Override
    public int compareTo(Person person) {
        return person.getFamily().compareTo(this.getFamily());
    }
}
