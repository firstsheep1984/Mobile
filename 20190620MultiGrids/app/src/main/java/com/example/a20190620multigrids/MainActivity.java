package com.example.a20190620multigrids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_dialog, button_toasts, button_internet, button_async, button_spinner, button_listview, button_file, buttondb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        button_dialog = findViewById(R.id.button_dialog);
        button_dialog.setOnClickListener(this);
        button_async = findViewById(R.id.button_async);
        button_async.setOnClickListener(this);
        button_internet = findViewById(R.id.button_internet);
        button_internet.setOnClickListener(this);
        button_spinner = findViewById(R.id.button_spinner);
        button_spinner.setOnClickListener(this);
        button_listview = findViewById(R.id.button_listview);
        button_listview.setOnClickListener(this);
        button_toasts = findViewById(R.id.button_toast);
        button_toasts.setOnClickListener(this);
        button_file = findViewById(R.id.button_file);
        button_file.setOnClickListener(this);
        buttondb = findViewById(R.id.button_DB);
        buttondb.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_dialog:
                dialog();
                break;
            case R.id.button_async:
                async();
                break;
            case R.id.button_internet:
                internet();
                break;
            case R.id.button_spinner:
                spinner();
                break;
            case R.id.button_listview:
                listview();
                break;
            case R.id.button_toast:
                toast();
                break;
            case R.id.button_file:
                file();
                break;
            case R.id.button_DB:
                db();
                break;
        }
    }


    private void dialog() {
        //  String lastName = editText_LastName.getText().toString();
        Intent myIntent = new Intent(this, DIalogActivity.class);
        // myIntent.putExtra("lastName", lastName);
        startActivity(myIntent);
    }

    private void async() {
    }

    private void internet() {
    }

    private void spinner() {
        //  String lastName = editText_LastName.getText().toString();
        Intent myIntent = new Intent(this, SpinnerActivity.class);
        // myIntent.putExtra("lastName", lastName);
        startActivity(myIntent);
    }

    private void toast() {
        startActivity(new Intent(this, ToastActivity.class));
    }

    private void listview() {
    }

    private void file() {
    }

    private void db() {
    }
}
