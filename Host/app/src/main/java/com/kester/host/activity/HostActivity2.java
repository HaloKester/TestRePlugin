package com.kester.host.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.kester.host.R;
import com.kester.host.receiver.HostReceiverD1;
import com.kester.host.utils.Constant;
import com.qihoo360.replugin.RePlugin;

/**
 * Created by kester on 2017/7/9.
 */
public class HostActivity2 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host2);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                sendBroadcast2HostReceiverS1();
                break;

            case R.id.btn2:
                sendBroadcast2PluginReceiverS1();
                break;

            case R.id.btn3:
                RePlugin.startActivity(HostActivity2.this, RePlugin.createIntent("plugin1", "com.kester.plugin1.activity.PluginActivity3"));
                break;

            case R.id.btn4:
                registerHostReceiverD1();
                break;

            case R.id.btn5:
                sendBroadcast2HostReceiverD1();
                break;

            default:
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterHostReceiverD1();
    }

    private void sendBroadcast2HostReceiverD1() {
        Intent intent = new Intent();
        intent.putExtra(Constant.FROM, "HostActivity2");
        intent.setAction(Constant.ACTION_HOST_RECEIVER_D1);
        sendBroadcast(intent);
    }

    private HostReceiverD1 mHostReceiverD1;
    private void registerHostReceiverD1() {
        mHostReceiverD1 = new HostReceiverD1();
        IntentFilter filter = new IntentFilter(Constant.ACTION_HOST_RECEIVER_D1);
        registerReceiver(mHostReceiverD1, filter);
    }
    private void unRegisterHostReceiverD1() {
        if (mHostReceiverD1 != null) {
            unregisterReceiver(mHostReceiverD1);
        }
    }

    private void sendBroadcast2HostReceiverS1() {
        Intent intent = new Intent();
        intent.putExtra(Constant.FROM, "HostActivity2");
        intent.setAction(Constant.ACTION_HOST_RECEIVER_S1);
        sendBroadcast(intent);
    }

    private void sendBroadcast2PluginReceiverS1() {
        Intent intent = new Intent();
        intent.putExtra(Constant.FROM, "HostActivity2");
        intent.setAction(Constant.ACTION_PLUGIN_RECEIVER_S1);
        sendBroadcast(intent);
    }
}
