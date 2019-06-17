package com.example.a2019_06_17_returnresulttomain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static  int REQUEST_CODE1 = 1;
    final static  int REQUEST_CODE2 = 2;

    TextView textView_feedBack;
    Button button_test1, button_test2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        textView_feedBack = findViewById(R.id.textView_feedBack);
        button_test1 = findViewById(R.id.button_test1);
        button_test1.setOnClickListener(this);
        button_test2 = findViewById(R.id.button_test2);
        button_test2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_test1:
                gototest1();
                break;
            case R.id.button_test2:
                gototest2();
                break;

        }
    }
    private void gototest1() {

        Intent myIntent = new Intent(this, activity_test1.class);

        startActivityForResult(myIntent, REQUEST_CODE1);
    }

    private void gototest2() {
        Intent myIntent = new Intent(this, activity_test2.class);

        startActivityForResult(myIntent, REQUEST_CODE2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
