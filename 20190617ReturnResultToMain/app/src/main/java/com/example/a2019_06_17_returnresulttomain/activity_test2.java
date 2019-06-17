package com.example.a2019_06_17_returnresulttomain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_test2 extends AppCompatActivity implements View.OnClickListener {
    Button button_OK, button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initialize();
    }

    private void initialize() {
        button_OK = findViewById(R.id.button_OK);
        button_OK.setOnClickListener(this);
        button_cancel = findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_OK:
                goOK();
                break;
            case R.id.button_cancel:
                goCancel();
                break;
        }
    }
    private void goOK() {
        String strResult = "Ok result from test2";

        //------------------------------------ Create an intent and putExtra result string
        Intent intent = new Intent();
        intent.putExtra("return_result_from_test2", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_OK, intent);
        finish();
    }
    private void goCancel() {
        String strResult = "Operation canceled";

        //------------------------------------ Create an intent
        Intent intent = new Intent();
        intent.putExtra("cancel_tag", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}