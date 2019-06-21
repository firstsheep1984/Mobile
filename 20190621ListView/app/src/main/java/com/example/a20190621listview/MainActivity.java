package com.example.a20190621listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeListView();
    }

    private void initializeListView() {
        ListView listView = findViewById(R.id.listView);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, // position in the listview start from 0
                                    long id) { //row id of the underlying data
                if(position == 0){
                    startActivity(new Intent(MainActivity.this,DrinkActivity.class));
                }

            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
}
