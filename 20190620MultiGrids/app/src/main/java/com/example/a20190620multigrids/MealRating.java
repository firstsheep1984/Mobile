package com.example.a20190620multigrids;


import androidx.annotation.NonNull;

public class MealRating implements Comparable<MealRating> {

    private String mealName;
    private int rating;


    public MealRating(String mealName, int rating) {
        this.mealName = mealName;
        this.rating = rating;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Meal: " + mealName + " Rating: " + rating;
    }

    @Override
    public int compareTo(@NonNull MealRating mealRating) {
        return mealName.compareTo(mealRating.getMealName());
    }
}





