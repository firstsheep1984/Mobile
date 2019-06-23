package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.phonebook.model.Person;

public class ShowAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        initializeListView();
    }

    private void initializeListView() {
        ListView listView_showAll = findViewById(R.id.listView_showAll);

        ArrayAdapter<Person> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Person.personList);
        listView_showAll.setAdapter(listAdapter);

    /*    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(DrinkActivity.this, DrinkCategoryActivity.class);

                intent.putExtra(EXTRA_DRINKED, (int)l);
                startActivity(intent);

            }
        };

        listView_drink.setOnItemClickListener(itemClickListener);*/
    }
}
