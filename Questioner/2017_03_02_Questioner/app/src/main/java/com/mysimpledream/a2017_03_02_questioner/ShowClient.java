package com.mysimpledream.a2017_03_02_questioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mysimpledream.a2017_03_02_questioner.Model.Client;
import com.mysimpledream.a2017_03_02_questioner.Model.DataCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowClient extends AppCompatActivity {

    RadioButton radioBtnAdventure, radioBtnAction, radioBtnComedy, radioBtnAll;
    Button ListBtn;
    TextView textViewClients;

    List<Client> clientList;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client);

        Initialize();
        getMyIntent();
    }

    private void Initialize() {

        // RadioGroup
        radioBtnAdventure = findViewById(R.id.radioBtnAdventure);
        radioBtnAction = findViewById(R.id.radioBtnAction);
        radioBtnComedy = findViewById(R.id.radioBtnComedy);
        radioBtnAll = findViewById(R.id.radioBtnAll);

        ListBtn = findViewById(R.id.ListBtn);

        textViewClients = findViewById(R.id.textViewClients);
    }

    private void getMyIntent() {

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("intentExtra");

        Serializable bundleContent = bundle.getSerializable("bundleContent");

        DataCollection dataCollection = (DataCollection)bundleContent;

        clientList = dataCollection.getClientArray();
    }


    public void showListOfClients(View view) {

        if (radioBtnAdventure.isChecked())
            iterateByType("adv");

        else if (radioBtnAction.isChecked())
            iterateByType("action");

        else if (radioBtnComedy.isChecked())
            iterateByType("comedy");

        else if (radioBtnAll.isChecked())
            iterateByType("all");

        textViewClients.setText(str);
    }


    void iterateByType(String myType) {
        str = "";
        for (Client oneClient : clientList) {
            if (myType.equals("all")) {
                str = str + oneClient;
            } else if (oneClient.getType().equals(myType)) {
                str = str + oneClient;
            }
        }
    }
}
