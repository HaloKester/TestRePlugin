package com.kester.plugin1;

import android.app.Application;

import com.kester.litlibrary.Constant;
import com.kester.plugin1.aidl.Plugin1AidlImpl;
import com.qihoo360.replugin.RePlugin;

/**
 * Created by kester on 2017/7/9.
 */
public class Plugin1Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RePlugin.registerPluginBinder(Constant.BINDER_PLUGIN1_AIDL, new Plugin1AidlImpl());
    }

}
