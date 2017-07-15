package com.kester.pluginbiglibrary;

import android.content.Context;

import com.kester.litlibrary.DisplayUtils;

/**
 * Created by kester on 2017/7/14.
 */
public class PluginBigLibrary {
    public static int getWidth(Context context) {
        return DisplayUtils.getScreenWidth(context);
    }
}
