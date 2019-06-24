package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView_generate;
    EditText editText_answer;
    Button btnGenerate, btnValidate, btnClear, btnScore, btnFinish, btn1, btn2, btn3,btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot, btnMinus;
int rightResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        textView_generate = findViewById(R.id.textView_generate);

        editText_answer = findViewById(R.id.editText_answer);

        btnGenerate = findViewById(R.id.button_generate);
        btnGenerate.setOnClickListener(this);

        btnValidate = findViewById(R.id.button_validate);
        btnValidate.setOnClickListener(this);

        btnClear = findViewById(R.id.button_clear);


        btnScore = findViewById(R.id.button_score);
        btnScore.setOnClickListener(this);

        btnFinish = findViewById(R.id.button_finish);
        btnFinish.setOnClickListener(this);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn0 = findViewById(R.id.button0);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnDot = findViewById(R.id.buttonDot);
        btnMinus = findViewById(R.id.buttonMinus);
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

            case R.id.button_finish:
                finish();
                break;

            case R.id.button_score:
                showScore();
                break;


        }
    }

    private void goValidate() {
        int integerUserAnswer = Integer.valueOf(editText_answer.getText().toString());

        if (integerUserAnswer == rightResult) {
            Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

    }

    private void showScore() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }

    private void goGenerate() {

            Random random = new Random();
            int operand1 = random.nextInt(10);
            int operand2 = random.nextInt(10);

            String[] arr = {"+", "-", "*", "/"};

            // randomly selects an index from the arr
            int index = random.nextInt(arr.length);

            String operation = operand1 + arr[index] + operand2;
            if (operation.equals(operand1 + "+" + operand2)) {
                rightResult = operand1 + operand2;
            } else if (operation.equals(operand1 + "-" + operand2)) {
                rightResult = operand1 - operand2;
            } else if (operation.equals(operand1 + "*" + operand2)) {
                rightResult = operand1 * operand2;
            } else if (operation.equals(operand1 + "/" + operand2)) {
                rightResult = operand1 / operand2;
                //TODO: EXCEPTION
            }
            textView_generate.setText(operation);

        }


    public void clickTwo(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "2");
    }

    public void clickOne(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "1");
    }


    public void clickThree(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "3");
    }

    public void clickFour(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "4");
    }

    public void clickFive(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "5");
    }

    public void clickSix(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "6");
    }

    public void clickSeven(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "7");
    }

    public void clickEight(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "8");
    }

    public void clickNine(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "9");
    }

    public void clickDot(View view) {
        editText_answer.setText(editText_answer.getText().toString() + ".");
    }

    public void clickZero(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "0");
    }

    public void clickMinus(View view) {
        editText_answer.setText(editText_answer.getText().toString() + "-");
    }

    public void goClear(View view) {
        editText_answer.setText("");
        textView_generate.setText("");
    }
}