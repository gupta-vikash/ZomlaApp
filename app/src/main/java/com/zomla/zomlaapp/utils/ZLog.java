package com.zomla.zomlaapp.utils;

import android.util.Log;

/**
 * Created by vikashg on 05/06/17.
 */

public class ZLog {
    private static boolean isDebuggingEnabled = true;

    public static void enableDebugging(boolean enabled) {
        isDebuggingEnabled = enabled;
    }

    public static void d(String tag, String message) {
        if (check(tag, message)) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (check(tag, message)) {
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (check(tag, message)) {
            Log.w(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (check(tag, message)) {
            Log.e(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (check(tag, message)) {
            Log.v(tag, message);
        }
    }

    private static boolean check(String tag, String message) {
        return isDebuggingEnabled && tag != null && message != null;
    }
}