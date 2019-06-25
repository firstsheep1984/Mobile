package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.phonebook.model.Person;

import static com.example.phonebook.model.Person.personList;

public class PersonActivity extends AppCompatActivity implements View.OnClickListener{
    TextView editText_name, editText_family,editText_phone, editText_email, editText_address;
    Button button_add, button_find, button_remove;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        initialize();
    }

    private void initialize() {
        editText_name = findViewById(R.id.editText_name);
        editText_family = findViewById(R.id.editText_family);
        editText_phone = findViewById(R.id.editText_phone);
        editText_address = findViewById(R.id.editText_address);
        editText_email = findViewById(R.id.editText_email);
        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(this);
        button_remove = findViewById(R.id.button_remove);
        button_remove.setOnClickListener(this);
        button_find = findViewById(R.id.button_find);
        button_find.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_add:
                add();
                break;
            case R.id.button_remove:

                break;
            case R.id.button_find:

                break;

        }
    }

    private void add() {
     /*   person = new Person(editText_name.getText().toString(),editText_family.getText().toString(),
                editText_phone.getText().toString(),editText_email.getText().toString(),editText_address.getText().toString(),
                R.drawable.sponjbob);
        personList[personList.length] = person;
        */
       // personList[personList.length] = new Person("d","e","555","email","address", R.drawable.sponjbob);
    }

}
