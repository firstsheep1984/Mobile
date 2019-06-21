package com.example.a20190621receivephonecall.phonecall_receiver;

import android.content.Context;
import android.content.Intent;

import java.util.Date;

public class MyReceiver extends PhoneCallReceiver {
    private static final String TAG = MyReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {

    }

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date Start) {

    }
}
