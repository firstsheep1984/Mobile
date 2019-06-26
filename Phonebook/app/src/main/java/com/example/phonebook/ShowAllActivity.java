package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.phonebook.model.Person;

import java.util.Collections;
import java.util.Comparator;

import static com.example.phonebook.PersonDetailActivity.EXTRA_PERSON;
import static com.example.phonebook.model.Person.pList;


public class ShowAllActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        initializeListView();

    }

    private void initializeListView() {
        ListView listView_showAll = findViewById(R.id.listView_showAll);
        // test using dummy data
        pList.add(new Person("Fire", "fighter", "5144444555", "fire@gmail.com", "111 Street Jisl, QC", R.drawable.fire_fighter));
        pList.add(new Person("Patric", "Sang", "5144678555", "patrick@gmail.com", "123 Street Jisl, QC", R.drawable.patric));
        pList.add(new Person("Sponge", "Bob", "514446666", "sponge@gmail.com", "189 Street Jisl, QC", R.drawable.sponjbob));

        //Collections.sort(pList);
        Collections.sort(pList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFamily().compareTo(o2.getFamily());
            }
        });
        ArrayAdapter<Person> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pList);
        listView_showAll.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ShowAllActivity.this, PersonDetailActivity.class);

                intent.putExtra(EXTRA_PERSON, (int) l);
                startActivity(intent);

            }
        };

        listView_showAll.setOnItemClickListener(itemClickListener);
    }
}
