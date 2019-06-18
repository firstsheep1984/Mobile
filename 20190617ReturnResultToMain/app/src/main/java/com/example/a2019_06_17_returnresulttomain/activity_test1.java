package com.example.a2019_06_17_returnresulttomain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class activity_test1 extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    TextView textViewOperation;
    EditText editTextAnswer;
    Button btnGenerate, btnValidate, btnCancel;

    int rightResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        initialize();
    }

    private void initialize() {
        textViewOperation = (TextView) findViewById(R.id.textView_random);
        editTextAnswer = (EditText) findViewById(R.id.editText_answer);

        btnGenerate = (Button) findViewById(R.id.button_generate);
        btnGenerate.setOnClickListener(this);

        btnValidate = (Button) findViewById(R.id.button_validate);
        btnValidate.setOnClickListener(this);

        btnCancel = (Button) findViewById(R.id.button_cancel);
        btnCancel.setOnClickListener(this);

        //------------------------------------------ Validation
        editTextAnswer.addTextChangedListener(this);
       btnValidate.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_generate:
                goGenerate();
                break;

            case R.id.button_validate:
                goValidate();
                break;

            case R.id.button_cancel:
                goCancel();
                break;
        }
    }
    private void goGenerate() {
        Random random = new Random();
        int operand1 = random.nextInt(10);
        int operand2 = random.nextInt(10);
        rightResult = operand1 + operand2;

        String operation = String.valueOf(operand1) + "+" + String.valueOf(operand2) + "= ?";

        textViewOperation.setText(operation);
    }

    private void goValidate() {
        int integerUserAnswer = Integer.valueOf(editTextAnswer.getText().toString());

        String strResult;

        if (integerUserAnswer == rightResult) {
            strResult = "Right Answer!";
        } else {
            strResult = "Wrong Answer!";
        }

        //------------------------------------ Create an intent and putExtra result string
        Intent intent = new Intent();
        intent.putExtra("return_result_tag", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_OK, intent);
        finish();
    }

    private void goCancel() {
        String strResult = "Operation canceled";

        //------------------------------------ Create an intent
        Intent intent = new Intent();
        intent.putExtra("cancel_tag", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_CANCELED, intent);
        finish();
    }
    // TextWatcher Interface
   @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {

        try {
            int nb = Integer.valueOf(editTextAnswer.getText().toString());
            if (nb > 18) {
                Toast.makeText(this, "The total should be <= 18", Toast.LENGTH_SHORT).show();
                btnValidate.setEnabled(false);
            } else
                btnValidate.setEnabled(true);
        } catch (Exception e) {
            Toast.makeText(this, "Enter a number data type", Toast.LENGTH_SHORT).show();
        }
    }


}
