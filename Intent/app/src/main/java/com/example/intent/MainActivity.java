package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   EditText editText_LastName;
   Button button;
   Button button2;
   Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editText_LastName = findViewById(R.id.editText_LastName);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }
  // set onclick
   // public void operate(View view){

   // }

    private void tempratureConversation() {
        String lastName = editText_LastName.getText().toString();
        Intent myIntent = new Intent(this, activity_temprature.class);
        myIntent.putExtra("lastName", lastName);
        startActivity(myIntent);
    }
    private void metricConversation() {
        String lastName = editText_LastName.getText().toString();
        Intent myIntent = new Intent(this, activity_metric.class);
        myIntent.putExtra("lastName", lastName);
        startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) { 
            case R.id.button:
                tempratureConversation();
                break;
            case R.id.button2:
                metricConversation();
                break;
            case R.id.button3:
                finish();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        SubMenu intentSubMenu = menu.addSubMenu("Options");
        intentSubMenu.add("Open Browser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //define our action_view
                intent.setData(Uri.parse("http://www.google.com"));

                startActivity(intent);
                return false;
            }
        });
        intentSubMenu.add("Open sms screen").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //define our action_view
                intent.setData(Uri.parse("sms:0123456789"));
                intent.putExtra("sms_body","Hello Yang");
                startActivity(intent);
                return false;
            }
        });
        intentSubMenu.add("Open dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //define our action_view
                Random random = new Random();
                int operand1 = random.nextInt(10);

                intent.setData(Uri.parse("tel:0123456789"));

                startActivity(intent);
                return false;
            }
        });
        intentSubMenu.add("Camera").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                /*Manually add to manifest.xml*/

                Intent intent = new Intent(MainActivity.this, activity_camera.class);
                startActivity(intent);
                return false;

            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
