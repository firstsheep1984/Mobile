package com.example.radiobtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void run(View view) {
        int selectRadioBtn = radioGroup.getCheckedRadioButtonId();
        switch (selectRadioBtn){
            case R.id.radioButton1:
                imageView.setImageResource(R.drawable.sponjbob);
                break;
            case R.id.radioButton2:
                imageView.setImageResource(R.drawable.patric);
                break;
            case R.id.radioButton3:
                imageView.setImageResource(R.drawable.fire_fighter);
                break;
        }
    }
}
