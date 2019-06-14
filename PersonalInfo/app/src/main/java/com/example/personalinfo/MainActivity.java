package com.example.personalinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup1, radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editText = findViewById(R.id.editText);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
    }

    public void display(View view) {
        String name = editText.getText().toString();

        int selectRadioBtn1 = radioGroup1.getCheckedRadioButtonId();
        String getSex = "";
        switch (selectRadioBtn1) {
            case R.id.radioButton1:
                getSex = "Male";
                break;
            case R.id.radioButton2:
                getSex = "Female";
                break;

        }
        int selectRadioBtn2 = radioGroup2.getCheckedRadioButtonId();
        String getSport = "";
        switch (selectRadioBtn2) {
            case R.id.radioButton3:
                getSport = "Soccer";
                break;
            case R.id.radioButton4:
                getSport = "Hockey";
                break;
            case R.id.radioButton5:
                getSport = "Handball";
                break;
        }

        Toast.makeText(this,
                "Name: " + name + "\n"
                        + "Sex: " + getSex + "\n"
                        + " Sport: " + getSport,
                Toast.LENGTH_LONG).show();

    }
}
