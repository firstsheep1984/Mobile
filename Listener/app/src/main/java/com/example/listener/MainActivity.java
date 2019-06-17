package com.example.listener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        // add action listener right away after the button
        // Approach 1: Create an object
        View.OnClickListener myOnClickListenerObject = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Approach 1: Create and pass and object", Toast.LENGTH_LONG).show();

                //  getUserInput();
            }
        };
        button.setOnClickListener(myOnClickListenerObject);

        // Approach 2: Anonymous inner class
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Approach 2: Anonymous inner class", Toast.LENGTH_LONG).show();
            }
        });

        // lambda expression:
        button.setOnClickListener((View view) -> Toast.makeText(MainActivity.this, "Approach 3: Anonymous inner class", Toast.LENGTH_LONG).show());

        // common
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Approach 4: More common way", Toast.LENGTH_LONG).show();

       // Intent intent = new Intent(this, SecondActivity.class);
        // startActivity(intent);
    }
}
