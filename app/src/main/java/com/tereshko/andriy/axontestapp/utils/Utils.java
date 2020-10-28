package com.tereshko.andriy.axontestapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by andy on 28/10/20
 */
public class Utils {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
