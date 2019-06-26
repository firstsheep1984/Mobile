package com.example.phonebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.FormatException;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phonebook.model.Person;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.phonebook.model.Person.pList;


public class PersonActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText_name, editText_family, editText_phone, editText_email, editText_address;
    Button button_add, button_find, button_remove;
    ImageView imageView;
    RadioGroup radioGroup;
    Person person;
    int imageResourceId;

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
        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_add:
                add();
                break;
            case R.id.button_remove:
                removeByFamily();
                break;
            case R.id.button_find:
                findByFamily();
                break;
        }
    }

    private void add() {
        //validation name
        String name_str = editText_name.getText().toString();
        if (name_str != null) {
            String regex_name = "^[^;]{1,}$";
            Pattern pattern = Pattern.compile(regex_name);
            Matcher matcher = pattern.matcher(name_str);
            if (!matcher.matches()) {
                Toast.makeText(this, "You must input a valid name!", Toast.LENGTH_SHORT).show();
                return ;
            }
        }
        //validation family
        String family_str = editText_family.getText().toString();
        if (family_str != null) {
            String regex_family = "^[^;]{1,}$";
            Pattern pattern = Pattern.compile(regex_family);
            Matcher matcher = pattern.matcher(family_str);
            if (!matcher.matches()) {
                Toast.makeText(this, "You must input a valid family name!", Toast.LENGTH_SHORT).show();
                return ;
            }
        }
        else{
            Toast.makeText(this, "You must input a family name!", Toast.LENGTH_SHORT).show();
            return ;
        }
        //validation phone
        String phone_str = editText_phone.getText().toString();
        if (phone_str != null) {
            String regex_phone = "^[0-9]{10}$";
            Pattern pattern = Pattern.compile(regex_phone);
            Matcher matcher = pattern.matcher(phone_str);
            if (!matcher.matches()) {
                Toast.makeText(this, "You must input a valid phone number!", Toast.LENGTH_SHORT).show();
                return ;
            }
        }
        else{
            Toast.makeText(this, "You must input a phone number!", Toast.LENGTH_SHORT).show();
            return ;
        }
        // validation email
        String email_str = editText_email.getText().toString();
        if (email_str != null) {
            String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email_str);
            if (!matcher.matches()) {
                Toast.makeText(this, "You must input a valid email address!", Toast.LENGTH_SHORT).show();
                return ;
            }
        }

        person = new Person(editText_name.getText().toString(), editText_family.getText().toString(),
                editText_phone.getText().toString(), email_str, editText_address.getText().toString(),
                imageResourceId);
        pList.add(person);
        Toast.makeText(this, "You have added a new contact!", Toast.LENGTH_SHORT).show();
        editText_name.setText("");
        editText_family.setText("");
        editText_email.setText("");
        editText_address.setText("");
        editText_phone.setText("");

    }

    private void findByFamily() {
      /*
      // doesn't support JAVA 8 & Lambda
      pList.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getFamily().equals(editText_family.getText().toString());
            }
        });
        */
        Iterator<Person> itr = pList.iterator();
        while (itr.hasNext()) {

            Person p = itr.next();
            if (p.getFamily().equals(editText_family.getText().toString())) {
                Toast.makeText(this, "You have found this person!", Toast.LENGTH_SHORT).show();
                editText_name.setText(p.getName());
                editText_email.setText(p.getEmail());
                editText_address.setText(p.getAddress());
                editText_phone.setText(p.getPhone());
            }
        }
    }

    private void removeByFamily() {
        Iterator<Person> itr = pList.iterator();
        while (itr.hasNext()) {
            Person p = itr.next();
            if (p.getFamily().equals(editText_family.getText().toString())) {
                itr.remove();
                Toast.makeText(this, "You have removed this person!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void run(View view) {
        int selectRadioBtn = radioGroup.getCheckedRadioButtonId();
        switch (selectRadioBtn) {
            case R.id.radioButton_sponge:
                imageView.setImageResource(R.drawable.sponjbob);
                imageView.setTag(R.drawable.sponjbob);

                break;
            case R.id.radioButton_patric:
                imageView.setImageResource(R.drawable.patric);
                imageView.setTag(R.drawable.patric);
                break;
            case R.id.radioButton_firefighter:
                imageView.setImageResource(R.drawable.fire_fighter);
                imageView.setTag(R.drawable.fire_fighter);
                break;
        }
        Integer objPicture = (Integer) imageView.getTag();
        imageResourceId = objPicture.intValue();
    }
}
