package com.example.yangyang_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText_name;
    ImageView imageView;
    RadioGroup radioGroup;
    RadioButton rb_poutine, rb_chefPoutine, rb_salmon, rb_tacos, rb_sushi;
    Button bt_finish, bt_order;
    TextView textView_displayAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        getIntentBack();
    }


    private void initialize() {
        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
        editText_name = findViewById(R.id.editText_name);
        rb_chefPoutine = findViewById(R.id.rb_chefPoutine);
        rb_poutine = findViewById(R.id.rb_poutine);
        rb_salmon = findViewById(R.id.rb_salmon);
        rb_sushi = findViewById(R.id.rb_sushi);
        rb_tacos = findViewById(R.id.rb_tacos);
        bt_finish = findViewById(R.id.button_finish);
        bt_finish.setOnClickListener(this);
        bt_order = findViewById(R.id.button_order);
        bt_order.setOnClickListener(this);
        textView_displayAddress = findViewById(R.id.textView_displayAddress);
    }

    private void getIntentBack() {
        Intent getIntentBack = getIntent();
        String address = getIntentBack.getStringExtra("address");
        textView_displayAddress.setText(address);
    }

    public void run(View view) {
        int selectRadioBtn = radioGroup.getCheckedRadioButtonId();
        switch (selectRadioBtn) {
            case R.id.rb_poutine:
                imageView.setImageResource(R.drawable.poutine);
                break;
            case R.id.rb_chefPoutine:
                imageView.setImageResource(R.drawable.chef);
                break;
            case R.id.rb_sushi:
                imageView.setImageResource(R.drawable.makisushi);
                break;
            case R.id.rb_salmon:
                imageView.setImageResource(R.drawable.salmon);
                break;
            case R.id.rb_tacos:
                imageView.setImageResource(R.drawable.tacos2);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_order:
                order();
                break;
            case R.id.button_finish:
                finish();
        }
    }

    private void order() {
        String name = editText_name.getText().toString();
        String selectedRadioGroup = "";

        // Just to show you different approaches
        if (rb_poutine.isChecked()) {
            selectedRadioGroup = rb_poutine.getTag().toString();

        } else if (rb_chefPoutine.isChecked()) {
            selectedRadioGroup = rb_chefPoutine.getTag().toString();

        } else if (rb_sushi.isChecked()) {
            selectedRadioGroup = rb_sushi.getTag().toString();
        } else if (rb_salmon.isChecked()) {
            selectedRadioGroup = rb_salmon.getTag().toString();

        } else if (rb_tacos.isChecked()) {
            selectedRadioGroup = rb_tacos.getTag().toString();
        }
        Order order = new Order(name, selectedRadioGroup);
        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleContent", order);
        Intent intent = new Intent(this, OrderAcitivity.class);
        intent.putExtra("intentExtra", bundle);
        startActivity(intent);
    }
}
