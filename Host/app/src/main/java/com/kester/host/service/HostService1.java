package com.kester.host.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kester.litlibrary.Dbg;

/**
 * Created by kester on 2017/7/8.
 */
public class HostService1 extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Dbg.e("host service1");
        return super.onStartCommand(intent, flags, startId);
    }
}
