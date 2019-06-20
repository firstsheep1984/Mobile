package com.example.a20190620multigrids;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DIalogActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    Button button_builder1, button_builder2, button_builder3, button_builder4, button_progress, button_custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initialize();
    }

    private void initialize() {
        button_builder1 = findViewById(R.id.button_builder1);
        button_builder1.setOnClickListener(this);
        button_builder2 = findViewById(R.id.button_builder2);
        button_builder2.setOnClickListener(this);
        button_builder3 = findViewById(R.id.button_builder3);
        button_builder3.setOnClickListener(this);

        button_builder4 = findViewById(R.id.button_builder4);
        button_builder4.setOnClickListener(this);

        button_progress = findViewById(R.id.button_progress);
        button_progress.setOnClickListener(this);

        button_custom = findViewById(R.id.button_custom);
        button_custom.setOnClickListener(this);

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(DIalogActivity.this, "id = " + i, Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(DIalogActivity.this, "id = " + i, Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                Toast.makeText(DIalogActivity.this, "id = " + i, Toast.LENGTH_SHORT).show();
                break;

        }

    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId) {
            case R.id.button_builder1:
                builder1();
                break;
            case R.id.button_builder2:
                builder2();
                break;
            case R.id.button_builder3:
                builder3();
                break;
            case R.id.button_builder4:
                builder4();
                break;
            case R.id.button_progress:
             //    progress();
                break;
            case R.id.button_custom:
                custom();
                break;

        }
    }



    private void builder1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("This is my title");

        // second argument in below methods is a reference to event listener
        alertDialogBuilder.setPositiveButton("yes", this);
        alertDialogBuilder.setNegativeButton("No", this);
        alertDialogBuilder.setNeutralButton("Neutral", this);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void builder2() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // type 2
        builder.setTitle("AlertDialog\njust a question for demo")
                .setMessage("Do you want to delete this file?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)
                // we just define event listener for yes button
                // but it can be defined for 'no' and 'cancel'
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DIalogActivity.this, "id = " + i, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", null)
                .setNeutralButton("Cancel", null);
        builder.show();
    }

    private void builder3() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // type 3
        builder.setTitle("Question ?")
                .setCancelable(false)
                .setSingleChoiceItems(new String[]{"A", "B", "C", "D"}, //single choice
                        0, //-1 for no default selection
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DIalogActivity.this, "id = " + i, Toast.LENGTH_SHORT).show();
                            }
                        })
                .setPositiveButton("OK", null);
        builder.show();
    }
    private void builder4() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // type 4
        builder.setTitle("Question ?")
                .setCancelable(true)
                .setMultiChoiceItems(new String[]{"item0", "item1", "item2", "item3", "item4", "item5"},
                        new boolean[]{false, true, false, false, true, false},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                Toast.makeText(DIalogActivity.this, "id = " + i, Toast.LENGTH_SHORT).show();
                            }
                        })
                .setPositiveButton("OK", null);
        builder.show();
    }
  /*  private void progress() {
        final ProgressDialog progressDialog = new Package(this);
        // progressDialog.setCancelable(false);
        // Disable ability to dismiss progress dialog
        progressDialog.setTitle("progress dialog example");
        progressDialog.setMessage("Please wait...");

        // by removing this line the default style will be used which is spinner
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        // we can use this line when we do not know when the progress will be finished
        // for activating this line simulator code must be disabled
        progressDialog.setIndeterminate(true);
        progressDialog.show();

        // create a simulator to start the progress from 0 and increase to 100
        progressDialog.setProgress(0);

        // change the progress in the specific time interval
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //progressDialog.getMax() is 100%
                if(progressDialog.getProgress() < progressDialog.getMax()){
                    // increase progress 1% each 200 ms
                    progressDialog.incrementProgressBy(1);
                }else {
                    // progressDialog.getMax() == 100% dismiss progressDialog
                    progressDialog.dismiss();
                    this.cancel();
                }
            }
        },0,200);
    }
    */
    private void custom() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog);
        dialog.show();
    }

}
