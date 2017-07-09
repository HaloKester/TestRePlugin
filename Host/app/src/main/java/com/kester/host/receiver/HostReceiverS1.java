package com.kester.host.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kester.host.utils.Constant;
import com.kester.host.utils.Dbg;

/**
 * Created by kester on 2017/7/9.
 */
public class HostReceiverS1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Dbg.e("HostReceiverS1", intent == null ? "null" : intent.getStringExtra(Constant.FROM));
    }
}
