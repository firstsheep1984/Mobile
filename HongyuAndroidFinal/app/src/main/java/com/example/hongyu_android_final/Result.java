package com.example.hongyu_android_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongyu_android_final.Model.Player;
import com.example.hongyu_android_final.utils.Calculator;
import com.example.hongyu_android_final.utils.PlayerDataCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result extends AppCompatActivity implements View.OnClickListener {

    /* General widget object */
    RadioButton  rbAll, rbRight, rbWrong, rbSortA, rbSortD;
    ListView lv;
    EditText txtRegister;
    TextView txtScore;
    Button btShow, btBack, btRegister;

    /* List */
    List<Player>pList;
    /* Adapter */
    ArrayAdapter<Player> adapter;

    /* Field vars invoked by methods */
    String newName; // registered Name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        InitResult();

        //Unboxing: Unbox data from main activity
        FetchData();

    }

    private  void InitResult(){

        //Init for Radio Button
        rbAll = findViewById(R.id.rbAll);
        rbAll.setOnClickListener(this);

        rbRight = findViewById(R.id.rbRight);
        rbRight.setOnClickListener(this);

        rbWrong = findViewById(R.id.rbWrong);
        rbWrong.setOnClickListener(this);

        rbSortA = findViewById(R.id.rbSortA);
        rbSortA.setOnClickListener(this);

        rbSortD = findViewById(R.id.rbSortD);
        rbSortD.setOnClickListener(this);

        //Init for Textview
        txtScore = findViewById(R.id.txtScore);

        //Init for EditText
        txtRegister = findViewById(R.id.txtRegister);

        //Init for Button
        btShow = findViewById(R.id.btShow);
        btShow.setOnClickListener(this);

        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(this);

        btRegister = findViewById(R.id.btRegister);
        btRegister.setOnClickListener(this);

        //Init for Listview
        lv = findViewById(R.id.lv);

    }

    private void FetchData(){

        //get intent from main activity
        //1 - getIntent();
        Intent intent = getIntent();

        if (intent.getBundleExtra("intentWithBundle") != null) {

            //2 & 3- fetch data from Intent then bundle
            Serializable seriaContent = intent.getBundleExtra("intentWithBundle").getSerializable("userInfo");
            PlayerDataCollection players = (PlayerDataCollection) seriaContent;
            pList = players.getPlayerList();

            String currentUser = intent.getStringExtra("keyForCurrentUser");

            //Calculator score
            int totalNumberOfTheUser=0;
            int correctCount=0;
            for(Player p :pList) {

                if (currentUser != null) {
                    if (p.getName().equals(currentUser)) {
                        totalNumberOfTheUser++;
                        if (p.isCorret()) { correctCount++; }
                    }
                }else {

                    if(p.getName() == null){
                        totalNumberOfTheUser++;
                        if (p.isCorret()) { correctCount++; }
                    }

                }
            }
            Calculator cal = new Calculator();
            double score = cal.div((double)correctCount, (double)totalNumberOfTheUser) * 100;
            System.out.println("correctCount: "+ correctCount + " pList.size(): " + pList.size()+ "score: "+ score);
            String strScore = String.valueOf(score)+ "%";
            txtScore.setText("");
            txtScore.setText(strScore);
        }
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btShow:
                goToShow();
                break;
            case R.id.btBack:
                goToBack();
                break;
            case R.id.btRegister:
                goToRegister();
                break;
        }
    }

    public void goToShow(){
        if (pList != null ) {
            if (rbAll.isChecked()) {
                   Collections.reverse(pList);
                    adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, pList);

            } else if (rbRight.isChecked()) {
                List<Player> newList = new ArrayList<Player>();
                for (Player p : pList) {
                    if (p.isCorret()) {
                        newList.add(p);

                    }
                }
                //Collections.reverse(newList);
                adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, newList);

            } else if (rbWrong.isChecked()) {
                List<Player> newList = new ArrayList<Player>();
                for (Player p : pList) {
                    if (!p.isCorret()) {
                        newList.add(p);

                    }
                }
                //Collections.reverse(newList);
                adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, newList);
            } else if (rbSortA.isChecked()) {
                Collections.sort(pList, Collections.reverseOrder());
                adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, pList);
            } else if (rbSortD.isChecked()) {
                Collections.sort(pList);
                adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, pList);
            }
            //Bind list to adapter
            if (adapter != null) {
                lv.setAdapter(adapter);
            }
        }else {
            Toast.makeText(this,"Nothing to be showed!", Toast.LENGTH_SHORT).show();
        }
    }


    public void goToRegister(){

        if (pList != null && ! txtRegister.getText().toString().isEmpty()){
            String uname = txtRegister.getText().toString();

            for(Player p : pList){

                if (p.getName() == null){
                    newName="";
                    newName=uname;
                    p.setName(uname);
                   Toast.makeText(this,"Rename to " +uname+" successfully!", Toast.LENGTH_SHORT).show();
                   //Debug
                   //System.out.println("txtRegister.getText().toString()========>" + txtRegister.getText().toString());
                }else if(p.getName().equals(uname)){
                    newName="";
                    newName=uname;
                    Toast.makeText(this,uname + " already exist!", Toast.LENGTH_SHORT).show();
                    break;
                }else if (!p.getName().equals(uname)){
                    newName="";
                    newName = uname;
                    Toast.makeText(this,"Register new player for " +uname+" successfully!", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            //Clean input string from register text
            txtRegister.setText("");

        }else if (pList == null && !txtRegister.getText().toString().isEmpty()){
            String uname = txtRegister.getText().toString();
            newName="";
            newName = uname;
            Toast.makeText(this,"Register new player for " +uname+" successfully!", Toast.LENGTH_SHORT).show();
            txtRegister.setText("");
        }else {
            Toast.makeText(this,"Register failed!", Toast.LENGTH_LONG).show();
        }
    }

    public void goToBack(){
        if (newName != null){
            //Send new registered name back to main activity
            setResult(RESULT_OK, new Intent().putExtra("newUserName", newName));
            //System.out.println("From result =====>" + newName);
            finish();
        }else{
            //Just back, do nothing
           finish();
        }
    }

}
