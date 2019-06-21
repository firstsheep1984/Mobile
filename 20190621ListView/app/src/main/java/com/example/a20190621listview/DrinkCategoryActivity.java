package com.example.a20190621listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a20190621listview.model.Drink;

public class DrinkCategoryActivity extends Activity {
    ImageView imageView;
    TextView textView_name, textView_description;
    Drink drink;
    public static final String EXTRA_DRINKED = "drinkid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        initialize();
       getmyIntent();
       loadData();
    }

    private void initialize() {
        imageView = findViewById(R.id.imageView2);
        textView_name = findViewById(R.id.textView_name);
        textView_description = findViewById(R.id.textView_description);
    }
    private void loadData() {
        imageView.setImageResource(drink.getImageResourceId());
        textView_name.setText(drink.getName());
        textView_description.setText(drink.getDescription());
    }

    private void getmyIntent() {

        int drinkId=(Integer) getIntent().getExtras().get(EXTRA_DRINKED);

        drink=Drink.drinks[drinkId];
    }
}
