package com.kester.host.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kester.host.R;
import com.kester.host.service.HostService1;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.component.service.PluginServiceClient;

/**
 * Created by kester on 2017/7/8.
 */
public class HostActivity1 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host1);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                openPluginActivity1();
                break;

            case R.id.btn2:
                openHostService1();
                break;

            case R.id.btn3:
                openPluginService1();
                break;

            default:
                break;
        }
    }

    private void openPluginActivity1() {
        RePlugin.startActivity(HostActivity1.this, RePlugin.createIntent("plugin1", "com.kester.plugin1.activity.PluginActivity1"));
    }

    private void openHostService1() {
        startService(new Intent(HostActivity1.this, HostService1.class));
    }

    private void openPluginService1() {
        PluginServiceClient.startService(HostActivity1.this, RePlugin.createIntent("plugin1", "com.kester.plugin1.service.PluginService1"));
    }
}
