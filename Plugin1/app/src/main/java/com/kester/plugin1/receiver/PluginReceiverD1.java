package com.kester.plugin1.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kester.litlibrary.Constant;
import com.kester.litlibrary.Dbg;

/**
 * Created by kester on 2017/7/10.
 */
public class PluginReceiverD1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Dbg.e("PluginReceiverD1", intent == null ? "null" : intent.getStringExtra(Constant.FROM));
    }
}
