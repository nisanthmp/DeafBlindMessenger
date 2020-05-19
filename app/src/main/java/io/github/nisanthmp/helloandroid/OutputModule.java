package io.github.nisanthmp.helloandroid;

import android.telephony.SmsManager;

import java.lang.reflect.Array;

public class OutputModule {
    Object[] inputCharByteArray;
    public static String messageString;
    public void setInputCharByteArray(Object[] array) {
        inputCharByteArray = array;
    }

    public void sendMessage() {
        convertFromBytesToString();
        //SmsManager smsManager = SmsManager.getDefault();
        //smsManager.sendTextMessage("8547071009", null, messageString, null, null);
    }

    private void convertFromBytesToString() {

    }

}
