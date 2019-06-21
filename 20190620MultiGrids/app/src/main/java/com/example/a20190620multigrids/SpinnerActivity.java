package com.example.a20190620multigrids;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class SpinnerActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    RatingBar ratingBar;
    Button button_add, button_show;
    ImageView imageViewMeal;
    ArrayAdapter<String> mealAdapter;
    ArrayList<MealRating> listOfMealRating;
    // Arrays of names and pictures for spinner
    String listMeal[] = {"Salmon", "Poutine", "Sushi", "Tacos"};
    int mealPicture[] = {R.drawable.salmon, R.drawable.poutine, R.drawable.sushi, R.drawable.tacos};

    //.........................................
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initialize();
    }

    private void initialize() {
        listOfMealRating = new ArrayList<>();

        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(this);
        button_show = findViewById(R.id.button_show);
        button_show.setOnClickListener(this);

        ratingBar = findViewById(R.id.ratingBar);
        imageViewMeal = findViewById(R.id.imageView2);
        // Initialize spinner -----------------------------------
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        mealAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                listMeal);
        spinner.setAdapter(mealAdapter);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_add:
                addMealRating();
                break;
            case R.id.button_show:
                showAllMealRating();
                break;
        }
    }

    private void showAllMealRating() {
        Collections.sort(listOfMealRating);

        StringBuilder sb = new StringBuilder("");

        for (MealRating oneMealRating : listOfMealRating) {
            sb.append(oneMealRating + "\n");
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();

    }

    private void addMealRating() {
        String meal = spinner.getSelectedItem().toString();
        // Read ratingBar ....................................
        int rating = (int) ratingBar.getRating();
        //....................................................


        // Create new object and add it to our model array....
        MealRating mealRating = new MealRating(meal, rating);
        listOfMealRating.add(mealRating);
        //....................................................

        // Reset rating bar for next time
        ratingBar.setRating(0);
    }
    // AdapterView.OnItemSelectedListener ----------------------------------------------------------
    // Callback method to be invoked when an item in this view has been selected.
    // This callback is invoked only when the newly selected position is different
    // from the previously selected position or if there was no selected item.
    @Override
    public void onItemSelected(AdapterView<?> parent, // The AdapterView where the selection happened
                               View view,             // The view within the AdapterView that was clicked
                               int i,                 // The position of the view in the ListView adapter start from zero
                               long id) {             // The row id of the item in underlying data model that is selected

        // 'i' is index of selected item in spinner,
        // so we can assign the corresponding image reference
        // from our image array to our imageView
        int image = mealPicture[i];
        imageViewMeal.setImageResource(image);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
