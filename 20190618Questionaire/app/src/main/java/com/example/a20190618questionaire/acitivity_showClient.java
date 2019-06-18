package com.example.a20190618questionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a20190618questionaire.Model.Client;
import com.example.a20190618questionaire.Model.DataCollection;

import java.io.Serializable;
import java.util.List;

public class acitivity_showClient extends AppCompatActivity {
    RadioButton rb_adventure, rb_comedy, rb_action, rb_all;
    Button bt_list;
    TextView textView_showClient;
    RadioGroup radioGroup;
    List<Client> clientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_show_client);
        initialize();
        getMyIntent();
    }



    private void initialize() {
        textView_showClient = findViewById(R.id.textView_showClient);
        radioGroup = findViewById(R.id.rbg);
        rb_adventure = findViewById(R.id.rb_adventure);
        rb_action = findViewById(R.id.rb_action);
        rb_comedy = findViewById(R.id.rb_comedy);
        rb_all = findViewById(R.id.rb_all);
        bt_list = findViewById(R.id.bt_list);
    }
    private void getMyIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        Serializable bundleContent = bundle.getSerializable("bundleContent");
        DataCollection dataCollection = (DataCollection)bundleContent;
        clientList = dataCollection.getClientArray();
    }
}
