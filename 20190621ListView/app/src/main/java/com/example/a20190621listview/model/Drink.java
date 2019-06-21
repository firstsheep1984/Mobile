package com.example.a20190621listview.model;

import com.example.a20190621listview.R;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return getName();
    }

    public static final Drink[] drinks = {
            new Drink("Latte", " A couple of espresso shots with steamed milk", R.drawable.poutine),
            new Drink("Cuppuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.sushi),
            new Drink("Filter", "highest quality beans roasted and brewed fresh", R.drawable.salmon),

    };
}
