package com.example.yangyang_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WithdrawActivity extends AppCompatActivity {
    TextView textView_showBalance;
    EditText editText_enterAmount;
    Button button_withdraw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
        initialize();
        myGetIntent();
    }



    private void initialize() {
       textView_showBalance = findViewById(R.id.textView_showBalance);
        editText_enterAmount = findViewById(R.id.editText_enterAmount);
        button_withdraw = findViewById(R.id.button_withdraw);
    }

    private void myGetIntent() {
        Intent intent = getIntent();
        String balance = intent.getStringExtra("balance");
        textView_showBalance.setText(balance);
    }

    public void withdraw(View view) {
        double previousBalance = Double.valueOf(textView_showBalance.getText().toString());
        double minusAmount =  Double.valueOf(editText_enterAmount.getText().toString());
        String newBalance = String.valueOf(previousBalance - minusAmount);
        textView_showBalance.setText(newBalance);
        editText_enterAmount.setText("");
    }
}
