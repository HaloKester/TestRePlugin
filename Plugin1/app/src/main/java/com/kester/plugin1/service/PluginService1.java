package com.kester.plugin1.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.kester.litlibrary.Dbg;

/**
 * Created by kester on 2017/7/9.
 */
public class PluginService1 extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Dbg.e("plugin1 service1");
        return super.onStartCommand(intent, flags, startId);
    }
}
