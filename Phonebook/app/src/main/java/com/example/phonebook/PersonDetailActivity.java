package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phonebook.model.Person;

import java.util.Random;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu intentSubMenu = menu.addSubMenu("Options");

        intentSubMenu.add("Open sms screen").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //define our action_view
                intent.setData(Uri.parse("sms:" + person.getPhone()));
                intent.putExtra("sms_body","Hello！");
                startActivity(intent);
                return false;
            }
        });
        intentSubMenu.add("Open dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:" + person.getPhone()));
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
