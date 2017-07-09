package com.kester.plugin1.utils;

import android.util.Log;

/**
 * Created by kester on 2017/7/9.
 */
public class Dbg {
    public static void e(String method, String what) {
        Log.e("jinghai", method + "#" + what);
    }

    public static void e(String what) {
        Log.e("jinghai", what);
    }

    public static void i(String method, String what) {
        Log.i("jinghai", method + "#" + what);
    }

    public static void i(String what) {
        Log.i("jinghai", what);
    }
}
