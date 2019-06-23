package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phonebook.model.Person;

public class PersonDetailActivity extends AppCompatActivity {
    ImageView imageView_photo;
    TextView textView_name, textView_family,textView_phone, textView_email, textView_address;
    Person person;
    public static final String EXTRA_DRINKED = "drinkid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        initialize();
        getmyIntent();
        loadData();
    }
    private void initialize() {
        imageView_photo = findViewById(R.id.imageView_photo);
        textView_name = findViewById(R.id.textView_name);
        textView_family = findViewById(R.id.textView_family);
        textView_phone = findViewById(R.id.textView_phone);
        textView_address = findViewById(R.id.textView_address);
        textView_email = findViewById(R.id.textView_email);
    }
    private void getmyIntent() {
        int drinkId=(Integer) getIntent().getExtras().get(EXTRA_DRINKED);
        person= Person.personList[drinkId];
    }
    private void loadData() {
        imageView_photo.setImageResource(person.getImageResourceId());
        textView_name.setText(person.getName());
        textView_family.setText(person.getFamily());
        textView_email.setText(person.getEmail());
        textView_address.setText(person.getAddress());
        textView_phone.setText(person.getPhone());
    }
}
