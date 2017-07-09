package com.kester.plugin1;

import android.app.Application;

/**
 * Created by kester on 2017/7/9.
 */
public class Plugin1Application extends Application {
    private static Plugin1Application mIns;

    @Override
    public void onCreate() {
        super.onCreate();
        mIns = this;
    }

    public static Plugin1Application getInstance() {
        return mIns;
    }
}
