package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
    }

    public void display(View view) {
        String editText1_str = editText1.getText().toString();
        String editText2_str = editText2.getText().toString();
        String editText3_str = editText3.getText().toString();

        Toast.makeText(this,
                "id: " + editText1_str + "\n"
                        + "Name: " + editText2_str + "\n"
                        + " Age: " + editText3_str,
                Toast.LENGTH_LONG).show();
    }
}
