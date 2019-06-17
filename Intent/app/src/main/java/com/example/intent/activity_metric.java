package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_metric extends AppCompatActivity implements View.OnClickListener{
    TextView textView_LastName, textView_Centimeter, textView_Kilometer;
    EditText editText_Meter;
    Button button_Convert, button_Finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric);
        initialize();
        myGetIntent();
    }

    private void initialize() {
        textView_LastName = findViewById(R.id.textView_LastName);
        editText_Meter = findViewById(R.id.editText_Meter);
        textView_Centimeter = findViewById(R.id.textView_Centimeter);
        textView_Kilometer = findViewById(R.id.textView_Kilometer);
        button_Convert = findViewById(R.id.button_Convert);
        button_Convert.setOnClickListener(this);
        button_Finish = findViewById(R.id.button_Finish);
        button_Finish.setOnClickListener(this);
    }
    private void myGetIntent() {
        Intent intent = getIntent();
        String lastName = intent.getStringExtra("lastName");
        textView_LastName.setText(lastName);

    }
    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_Convert:
                metricConvert();
                break;
            case R.id.button_Finish:
                finish();
        }
    }

    private void metricConvert() {
        double centimeter = Double.valueOf(editText_Meter.getText().toString())*100;
        textView_Centimeter.setText(String.valueOf(centimeter));
        double kilometer = Double.valueOf(editText_Meter.getText().toString())/1000;
        textView_Kilometer.setText(String.valueOf(kilometer));
    }
}
