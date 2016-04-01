package com.mli;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by limian on 2016/3/31.
 */
public class Common {
    public static final String TAG = "Debug Album";

    public static void logI(String log) {
        Log.i(TAG, log);
    }

    public static void ToastMsg(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
