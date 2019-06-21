package com.example.a20190621receivephonecall.phonecall_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import java.util.Date;

public abstract class PhoneCallReceiver extends BroadcastReceiver {
    // get name of the class
    private static final String TAG = PhoneCallReceiver.class.getSimpleName();

    // define required attributes
    private static int lastState = TelephonyManager.CALL_STATE_IDLE;
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String savedNumber;

    @Override
    public void onReceive(Context context, Intent intent) {

    }
    protected abstract void onIncomingCallStarted(Context ctx, String number,Date Start);
}
