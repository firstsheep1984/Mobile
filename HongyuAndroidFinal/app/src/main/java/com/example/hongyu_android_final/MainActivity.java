package com.example.hongyu_android_final;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongyu_android_final.Model.Player;
import com.example.hongyu_android_final.utils.Calculator;
import com.example.hongyu_android_final.utils.PlayerDataCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Define Widget objects
    TextView txtTitle, txtQuestion;
    EditText txtAnswer;

    ImageView imgResult;

    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    List<Button> bt0To9List = new ArrayList<Button>(); //Button List
    
    Button btDot, btDash;
    Button btGenerate, btValiadate, btClear, btScore, btFinish;

    Calculator myCalculator ;
    PlayerDataCollection playList;

    //Field variables
    private  String strQuestion;
    private  String inputStr; //User answers
    private  Double realResult;  //Real answers


    //Define Constant
    private final static String TITLE = "MATH QUIZ";
    private final static int MAX_NUMBER = 50; // Range of Number :  0 - 999
    private final static int RQ_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize current activity
        InitializeMe();
    }

    private void InitializeMe() {

        //Init for Textview
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(TITLE); //Set default title

        txtQuestion = findViewById(R.id.txtQuestion);


        //Init for EditText
        txtAnswer = findViewById(R.id.txtAnswer);

        //Init for ImageView
        imgResult = findViewById(R.id.imgResult);

        //Init for Buttons
        bt0 = findViewById(R.id.bt0);
        bt0.setOnClickListener(this);

        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(this);

        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(this);

        bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(this);

        bt5 = findViewById(R.id.bt5);
        bt5.setOnClickListener(this);

        bt6 = findViewById(R.id.bt6);
        bt6.setOnClickListener(this);

        bt7 = findViewById(R.id.bt7);
        bt7.setOnClickListener(this);

        bt8 = findViewById(R.id.bt8);
        bt8.setOnClickListener(this);

        bt9 = findViewById(R.id.bt9);
        bt9.setOnClickListener(this);
               
        btDot = findViewById(R.id.btDot);
        btDot.setOnClickListener(this);

        btDash = findViewById(R.id.btDash);
        btDash.setOnClickListener(this);

        btGenerate = findViewById(R.id.btGenerate);
        btGenerate.setOnClickListener(this);

        btValiadate = findViewById(R.id.btValidate);
        btValiadate.setOnClickListener(this);

        btFinish = findViewById(R.id.btFinish);
        btFinish.setOnClickListener(this);

        btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(this);

        btScore = findViewById(R.id.btScore);
        btScore.setOnClickListener(this);
        
        //Init for Button List
        bt0To9List = Arrays.asList(bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btDot,btDash);

        //Init Calculator
        myCalculator = new Calculator();

        //Init playList
        playList = new PlayerDataCollection();

        //clean everything
        goToClear();
    }


    @Override
    public void onClick (View view){

        switch (view.getId()){

            case R.id.btFinish:
                finish();
                break;
            case R.id.btGenerate:
                goToGenerate();
                break;
            case R.id.btClear:
               goToClear();
                break;
            case R.id.btValidate:
                try{
                    goToValidate();
                }catch (Exception e){ }

                break;

            case R.id.btScore:
                goToActivityResult();
                break;
        }

        //Bind bt0 - bt9 to same method
        for (Button b : bt0To9List){
            if (b.getId() == view.getId()){
                String Str = b.getText().toString();
                userInput(Str);
            }
        }

    }

    public void goToGenerate(){

        //Clean cached data before generate new question!
        inputStr="";
        txtAnswer.setText("");
        imgResult.setImageResource(android.R.color.transparent);

        //Generate new question
        strQuestion ="";
        Random random = new Random();

        int numberA = random.nextInt(MAX_NUMBER);
        int numberB =random.nextInt(MAX_NUMBER);

        Double dNumA = Double.valueOf(numberA);
        Double dNumB = Double.valueOf(numberB);

        //0: + | 1: - | 2: * | 3: /
        //Double result = 0.0;
        switch(random.nextInt(4)){

            case 0:
                realResult = myCalculator.add(dNumA,dNumB);
                strQuestion = numberA + " + " +  numberB;
                break;
            case 1:
                realResult = myCalculator.sub(dNumA,dNumB);
                strQuestion = numberA + " - " +  numberB;
                break;
            case 2:
                realResult = myCalculator.mul(dNumA,dNumB);
                strQuestion = numberA + " * " +  numberB;
                break;
            case 3:
                if (numberB !=0 ){
                    realResult =myCalculator.div(dNumA,dNumB);
                    strQuestion = numberA + " / "+ numberB;
                }
                break;
        }

        //Show Random question to view
        txtQuestion.setText("");
        txtQuestion.setText(strQuestion);
    }

    public void userInput(String strFromInput){

        if (strFromInput != "") {

            String tmpStr = inputStr + strFromInput;

            /* Filter for inputStr */
            String regPat = "^(-?|[0-9]+)+(\\.?[0-9]*)?$";

            boolean isMatch = Pattern.matches(regPat, tmpStr);

                if (!isMatch) {

                    Toast.makeText(MainActivity.this, "Invalid data format! Please input again!", Toast.LENGTH_LONG).show();
                    return;
                } else {

                    inputStr = tmpStr;
                }

        }

        txtAnswer.setText(inputStr);
    }

    public void goToValidate(){
        if (inputStr !="" && realResult !=null){

            Boolean isGoodAnswer = false;
            if (realResult.equals(Double.valueOf(inputStr))){

                //Debug
                //System.out.println("CorrectAnswer: " + realResult + " UserInput: " + Double.valueOf(inputStr));
                imgResult.setImageResource(R.drawable.check);
                isGoodAnswer = true;

            }else {
                //Debug
                //System.out.println("CorrectAnswer: " + realResult + " UserInput: " + Double.valueOf(inputStr));
                imgResult.setImageResource(R.drawable.cross);
            }

            //Put ALL Data to playerList
            String userName = null;

            if (! txtTitle.getText().toString().equals(TITLE)){
                userName = txtTitle.getText().toString();
            }
            playList.getPlayerList().add(new Player(
                    userName,
                    strQuestion,
                    inputStr,
                    String.valueOf(realResult),
                    isGoodAnswer  ));
            //Debug
            //System.out.println(playList.getPlayerList());
        }else {
            Toast.makeText(MainActivity.this, "Input data or Question not found!", Toast.LENGTH_LONG).show();
        }

    }

    public void goToActivityResult(){

        /* Data Boxing */
        // 1 - check playerList
        if (playList.getPlayerList().isEmpty() ||playList.getPlayerList() == null ) {

            Toast.makeText(MainActivity.this, "No Players found!", Toast.LENGTH_SHORT).show();
            startActivityForResult(new Intent(MainActivity.this, Result.class), RQ_CODE);

        }else{

            //2 - Bundle
            Bundle bundle = new Bundle();

            //3 - Make list to Serializable !!
            bundle.putSerializable("userInfo", (Serializable) playList);

            //4 - Create Intent for next activity --> Result.class
            Intent intent = new Intent(MainActivity.this, Result.class);
            intent.putExtra("intentWithBundle", bundle);

            //Bind current user name to intent
            String currentUser;
            if (txtTitle.getText()!= null && txtTitle.getText().toString().equals(TITLE)){
                //if current user doesn't have a name, null is the Name
                currentUser=null;
            }else{
                currentUser = txtTitle.getText().toString();
            }
            intent.putExtra("keyForCurrentUser", currentUser);

            //5 - startActivity() -- Jump to Another activity
            //startActivity(intent);
            startActivityForResult(intent, RQ_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        goToClear();
        if (requestCode == RQ_CODE && resultCode == RESULT_OK && data != null ){

                    String newUName= data.getStringExtra("newUserName");
                    //System.out.println("MainActivity ========>" + newUName);
                    //Put new userName to titile in main activity
                    txtTitle.setText("");
                    txtTitle.setText(newUName);
        }
    }

    public void goToClear(){

        imgResult.setImageResource(android.R.color.transparent);
        txtAnswer.setText("");
        txtQuestion.setText("");
        inputStr ="";

    }





}




