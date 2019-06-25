package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.math.Model.QuestionAndAnswer;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initializeListView();
    }

    private void initializeListView() {
        ListView listView_drink = findViewById(R.id.listView);

        ArrayAdapter<QuestionAndAnswer> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.questionAndAnswerList);
        listView_drink.setAdapter(listAdapter);
    }
}
