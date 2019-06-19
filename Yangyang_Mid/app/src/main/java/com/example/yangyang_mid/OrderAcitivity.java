package com.example.yangyang_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class OrderAcitivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    TextView textView_displayName, textView_displayOrder;
    EditText editText_address;
    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_acitivity);
        initialize();
        getMyIntent();
    }

    private void getMyIntent() {
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("intentExtra");

        Serializable bundleContent = bundle.getSerializable("bundleContent");

        order = (Order)bundleContent;
        textView_displayName.setText(order.getName());
        textView_displayOrder.setText(order.getFood());
    }

    private void initialize() {
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView_displayName = findViewById(R.id.textView_displayName);
        editText_address = findViewById(R.id.editText_address);
        textView_displayOrder = findViewById(R.id.textView_displayOrder);

    }

    @Override
    public void onClick(View view) {
        String address = editText_address.getText().toString();
       // Order orderWithAddress = new Order(order.getName(),order.getFood(),address);
       // Bundle bundle = new Bundle();
       // bundle.putSerializable("bundleContent", order);
        Intent intentBack = new Intent(this, MainActivity.class);
        intentBack.putExtra("address", address);
        startActivity(intentBack);
        Toast.makeText(this, "Thank you for using our application " + order.getName(), Toast.LENGTH_LONG).show();
       // finish();
    }
}
