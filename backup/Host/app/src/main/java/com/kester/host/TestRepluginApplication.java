package com.kester.host;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.kester.host.aidl.HostBinderFetcher;
import com.qihoo360.replugin.IHostBinderFetcher;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginConfig;
import com.qihoo360.replugin.gen.RePluginHostConfig;

/**
 * Created by kester on 2017/7/6.
 */
public class TestRepluginApplication extends Application {
    private static TestRepluginApplication mIns;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        RePlugin.App.attachBaseContext(this, new RePluginConfig().setVerifySign(false));
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

    @Override
    public void onCreate() {
        super.onCreate();
        RePlugin.App.onCreate();
        mIns = this;
        RePlugin.registerHostBinder(new HostBinderFetcher());
    }

    public static TestRepluginApplication getInstance() {
        return mIns;
    }
}
