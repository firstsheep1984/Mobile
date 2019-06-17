package com.example.intent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_temprature extends AppCompatActivity implements View.OnClickListener{
    TextView textView_LastName,  textView_TempratureF;
    EditText editText_TempratureC;
    Button button_Convert, button_Finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temprature);
        initialize();

    }

    private void initialize() {
        textView_LastName = findViewById(R.id.textView_LastName);
        editText_TempratureC = findViewById(R.id.editText_TempratureC);
        textView_TempratureF = findViewById(R.id.textView_TempratureF);

        button_Convert = findViewById(R.id.button_Convert);
        button_Convert.setOnClickListener(this);
        button_Finish = findViewById(R.id.button_Finish);
        button_Finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_Convert:
                tempratureConvert();
                break;
            case R.id.button_Finish:
                finish();
        }

    }

    private void tempratureConvert() {
        double temperatureF = Double.valueOf(editText_TempratureC.getText().toString())*9/5+32;
        textView_TempratureF.setText(String.valueOf(textView_TempratureF));

    }
}
