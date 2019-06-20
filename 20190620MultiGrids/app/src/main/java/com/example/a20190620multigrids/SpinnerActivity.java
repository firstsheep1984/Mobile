package com.example.a20190620multigrids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner spinner;
    RatingBar ratingBar;
    Button button_add, button_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initialize();
    }

    private void initialize() {
        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(this);
        button_show = findViewById(R.id.button_show);
        button_show.setOnClickListener(this);
        spinner = findViewById(R.id.spinner);
        ratingBar = findViewById(R.id.ratingBar);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_add:
                add();
                break;
            case R.id.button_show:
              //  show();
                break;
        }
    }

    private void add() {
    }
}
