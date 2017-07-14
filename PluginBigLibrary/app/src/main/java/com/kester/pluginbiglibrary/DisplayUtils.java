package com.kester.pluginbiglibrary;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by kester on 2017/7/14.
 */
public class DisplayUtils {
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }
}
