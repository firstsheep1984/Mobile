package com.example.a20190621listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a20190621listview.model.Drink;

import static com.example.a20190621listview.DrinkCategoryActivity.EXTRA_DRINKED;

public class DrinkActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        initializeListView();
    }

    private void initializeListView() {
        ListView listView_drink = findViewById(R.id.listView_drink);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);
        listView_drink.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(DrinkActivity.this, DrinkCategoryActivity.class);

                    intent.putExtra(EXTRA_DRINKED, (int)l);
                    startActivity(intent);

            }
        };

        listView_drink.setOnItemClickListener(itemClickListener);
    }
}
