package com.example.testmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView_generate;
    EditText editText_answer;
    Button btnGenerate, btnValidate, btnClear, btnScore, btnFinish, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot, btnMinus;
    int rightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        textView_generate = findViewById(R.id.textView_generate);
        setContentView(R.layout.activity_main);
        editText_answer = findViewById(R.id.editText_answer);

        btnGenerate = findViewById(R.id.button_generate);
        btnGenerate.setOnClickListener(this);

        btnValidate = findViewById(R.id.button_validate);
         btnValidate.setOnClickListener(this);

        btnClear = findViewById(R.id.button_clear);
          btnClear.setOnClickListener(this);

        btnScore = findViewById(R.id.button_score);
          btnScore.setOnClickListener(this);

        btnFinish = findViewById(R.id.button_finish);
          btnFinish.setOnClickListener(this);

        btn0 = findViewById(R.id.button0);
          btnFinish.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_generate:
                editText_answer.setText("2");
                textView_generate.setText("2");
                break;

            case R.id.button_finish:
                finish();
                break;

            case R.id.button_score:
                showScore();
                break;
            case R.id.button0:
                editText_answer.setText(editText_answer.getText().toString()+"0");
                break;

        }
    }

    private void showScore() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }


    private void goGenerate() {
    /*    Random random = new Random();
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
*/
        textView_generate.setText("2");
    }
}