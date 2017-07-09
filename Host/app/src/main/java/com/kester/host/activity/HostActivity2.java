package com.kester.host.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kester.host.R;
import com.kester.host.utils.Constant;

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
