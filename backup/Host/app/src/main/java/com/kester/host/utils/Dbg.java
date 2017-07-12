package com.kester.host.utils;

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

//    private static void toast(String msg) {
//        Toast.makeText(TestRepluginApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
//    }
}
