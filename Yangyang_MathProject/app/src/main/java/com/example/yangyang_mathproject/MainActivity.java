package com.example.yangyang_mathproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    TextView textView_generate;
    EditText editText_answer;
    Button btnGenerate, btnValidate, btnClear, btnScore, btnFinish, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot, btnMinus;
    int rightResult;
    String display = "";

    //TODO:
    //List<Button> calculateButtons = new ArrayList<Button>();
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

        btn1 = findViewById(R.id.button1);
        btnFinish.setOnClickListener(this);

        btn2 = findViewById(R.id.button2);
        btnFinish.setOnClickListener(this);

        btn3 = findViewById(R.id.button3);
        btnFinish.setOnClickListener(this);

        btn4 = findViewById(R.id.button4);
        btnFinish.setOnClickListener(this);

        btn5 = findViewById(R.id.button5);
        btnFinish.setOnClickListener(this);

        btn6 = findViewById(R.id.button6);
        btnFinish.setOnClickListener(this);

        btn7 = findViewById(R.id.button7);
        btnFinish.setOnClickListener(this);

        btn8 = findViewById(R.id.button8);
        btnFinish.setOnClickListener(this);

        btn9 = findViewById(R.id.button9);
        btnFinish.setOnClickListener(this);

        btnDot = findViewById(R.id.button_dot);
        btnFinish.setOnClickListener(this);

        btnMinus = findViewById(R.id.button_minus);
        btnFinish.setOnClickListener(this);


        //------------------------------------------ Validation
        editText_answer.addTextChangedListener(this);
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

            case R.id.button_finish:
                finish();
                break;
        }
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
        }else if (operation.equals(operand1 + "-" + operand2)) {
            rightResult = operand1 - operand2;
        } else if (operation.equals(operand1 + "*" + operand2)) {
            rightResult = operand1 * operand2;
        } else if (operation.equals(operand1 + "/" + operand2)) {
            rightResult = operand1 / operand2;
            //TODO: EXCEPTION
        }


        textView_generate.setText(operation);
    }
    private void goValidate() {
       int integerUserAnswer = Integer.valueOf(editText_answer.getText().toString());

        if (integerUserAnswer == rightResult) {
            Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        try {
            btnValidate.setEnabled(true);
        } catch (Exception e) {
            Toast.makeText(this, "Enter a number data type", Toast.LENGTH_SHORT).show();
        }
    }

    public void ClickOne(View view) {
        editText_answer.setText(editText_answer.getText().toString()  + "1");
    }

    public void ClickTwo(View view) {
        editText_answer.setText(editText_answer.getText().toString()  + "2");
    }
}
