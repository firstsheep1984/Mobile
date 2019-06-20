package com.example.a20190620multigrids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class ToastCustom {
    Toast toast;

    //
    private Context context;
    public View view;

    public ToastCustom(Context context){

        //

        this.context = context;
        this.toast = new Toast(context);

        // 2.
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //this.view = inflater.inflate(R.layout.colored_toast1);
    }

}
