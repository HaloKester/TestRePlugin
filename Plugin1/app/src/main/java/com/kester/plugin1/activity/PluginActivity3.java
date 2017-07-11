package com.kester.plugin1.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.kester.host.aidl.IHostAidl;
import com.kester.plugin1.R;
import com.kester.plugin1.utils.Constant;
import com.qihoo360.replugin.RePlugin;

/**
 * Created by kester on 2017/7/9.
 */
public class PluginActivity3 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin3);
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
    protected void onDestroy() {
        super.onDestroy();
        unRegisterHostReceiverD1();
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
                sendBroadcast2HostReceiverD1();
                break;

            case R.id.btn4:
                sendBroadcast2PluginReceiverD1();
                break;

            case R.id.btn5:
                registerHostReceiverD1();
                break;

            default:
                break;
        }
    }

    private void registerHostReceiverD1() {
        IBinder b = RePlugin.fetchBinder("main", Constant.BINDER_HOST_AIDL);
        if (b == null) {
            return;
        }
        IHostAidl i = IHostAidl.Stub.asInterface(b);
        try {
            i.registerHostReceiverD1();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    private void unRegisterHostReceiverD1() {
        IBinder b = RePlugin.fetchBinder("main", Constant.BINDER_HOST_AIDL);
        if (b == null) {
            return;
        }
        IHostAidl i = IHostAidl.Stub.asInterface(b);
        try {
            i.unRegisterHostReceiverD1();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void sendBroadcast2PluginReceiverD1() {
        Intent intent = new Intent();
        intent.setAction(Constant.ACTION_PLUGIN_RECEIVER_D1);
        intent.putExtra(Constant.FROM, "PluginActivity3");
        sendBroadcast(intent);
    }

    private void sendBroadcast2HostReceiverD1() {
        Intent intent = new Intent();
        intent.putExtra(Constant.FROM, "PluginActivity3");
        intent.setAction(Constant.ACTION_HOST_RECEIVER_D1);
        sendBroadcast(intent);
    }

    private void sendBroadcast2HostReceiverS1() {
        Intent intent = new Intent();
        intent.putExtra(Constant.FROM, "PluginActivity3");
        intent.setAction(Constant.ACTION_HOST_RECEIVER_S1);
        sendBroadcast(intent);
    }

    private void sendBroadcast2PluginReceiverS1() {
        Intent intent = new Intent();
        intent.putExtra(Constant.FROM, "PluginActivity3");
        intent.setAction(Constant.ACTION_PLUGIN_RECEIVER_S1);
        sendBroadcast(intent);
    }
}
