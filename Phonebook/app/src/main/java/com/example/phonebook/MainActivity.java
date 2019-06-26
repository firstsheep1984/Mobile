package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.phonebook.model.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_showAll, button_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {

        button_showAll = findViewById(R.id.button_showAll);
        button_showAll.setOnClickListener(this);
        button_update = findViewById(R.id.button_update);
        button_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_showAll:
                startActivity(new Intent(MainActivity.this, ShowAllActivity.class));
                break;
            case R.id.button_update:
                startActivity(new Intent(MainActivity.this, PersonActivity.class));
                break;
        }
    }
}
