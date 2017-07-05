package com.kester.repluginhost;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.qihoo360.replugin.RePlugin;

/**
 * Created by kester on 2017/7/5.
 */
public class HostApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        RePlugin.App.attachBaseContext(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RePlugin.App.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RePlugin.App.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        RePlugin.App.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        RePlugin.App.onLowMemory();
    }
}
