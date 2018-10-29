package com.example.jyo05.smsrecevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.Objects;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            Object objs[] = (Object[]) bundle.get("pdus");
            SmsMessage smss[] = new SmsMessage[objs.length];
            for (int i = 0; i < smss.length; ++i) {
                smss[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
                System.out.println("spdn " + i + " SMS: " + smss[i].getDisplayMessageBody());
            }
        }
    }
}
