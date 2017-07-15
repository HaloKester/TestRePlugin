package com.kester.plugin1.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kester.litlibrary.Constant;
import com.kester.litlibrary.Dbg;

/**
 * Created by kester on 2017/7/9.
 */
public class PluginReceiverS1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Dbg.e("PluginReceiverS1", intent == null ? "null" : intent.getStringExtra(Constant.FROM));
    }
}
