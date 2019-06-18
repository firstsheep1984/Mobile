package com.example.a20190618questionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a20190618questionaire.Model.Client;
import com.example.a20190618questionaire.Model.DataCollection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText_clientNum, editText_email;
    RadioButton rb_adventure, rb_comedy, rb_action;
    Button bt_clear, bt_add, bt_remove, bt_updateEmail, bt_showAll;
    RadioGroup radioGroup;
    DataCollection dataCollection = new DataCollection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editText_clientNum = findViewById(R.id.editText_clientNum);
        editText_email = findViewById(R.id.editText_email);
        radioGroup = findViewById(R.id.rbg);
        rb_adventure = findViewById(R.id.rb_adventure);
        rb_action = findViewById(R.id.rb_action);
        rb_comedy = findViewById(R.id.rb_comedy);
        bt_clear = findViewById(R.id.bt_clear);
        bt_clear.setOnClickListener(this);
        bt_add = findViewById(R.id.bt_add);
        bt_add.setOnClickListener(this);
        bt_remove = findViewById(R.id.bt_remove);
        bt_remove.setOnClickListener(this);
        bt_updateEmail = findViewById(R.id.bt_updateEmail);
        bt_updateEmail.setOnClickListener(this);
        bt_showAll = findViewById(R.id.bt_showAll);
        bt_showAll.setOnClickListener(this);

    }

    private void showAll() {
       // String lastName = editText_LastName.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleContent", dataCollection);
        Intent myIntent = new Intent(this, acitivity_showClient.class);
       myIntent.putExtra("intentExtra", bundle);

        startActivity(myIntent);
    }


    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.bt_clear:
                clear();
                break;
            case R.id.bt_add:
                add();
                break;
            case R.id.bt_remove:
                remove();
                break;
            case R.id.bt_updateEmail:
                updateEmail();
                break;
            case R.id.bt_showAll:
                showAll();
                break;

        }
    }

    private void add() {
        int clientNumber = Integer.valueOf(editText_clientNum.getText().toString());
        String email = editText_email.getText().toString();
        String selectRb ="";

        if(rb_adventure.isChecked()){
            selectRb = rb_adventure.getTag().toString();
        }else if(rb_action.isChecked()){
            selectRb = rb_action.getTag().toString();
        }else if(rb_comedy.isChecked()){
            selectRb = rb_comedy.getTag().toString();
        }
        System.out.println("client number " + clientNumber + "client email " + email + "movie " + selectRb);
        Client client = new Client(clientNumber, email, selectRb);
        dataCollection.getClientArray().add(client);
    }

    private void clear() {
    }
    private void remove() {
    }

    private void updateEmail() {
    }
}
