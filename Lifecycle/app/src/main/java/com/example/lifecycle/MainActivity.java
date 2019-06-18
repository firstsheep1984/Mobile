package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("--------------onCreate: When the activity object create for the first time");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("--------------onRestart: Run after stop state and before start state");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--------------onStart: When the activity is becoming visible from stop state");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--------------onResume: When the activity return to foreground from pause or" +
                "stop state. Always run after onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--------------onCreate: When the activity is no longer in the foreground," +
                "but it can be visible like when an alert is on top of an activity");
      //  Log.d("myTag", ">>>>>>>>>>>>This is a message from Lod.d");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--------------onStop: When the activity is no longer visible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--------------onDestroy: When the activity is about to be destroyed and completed ");
    }
}
