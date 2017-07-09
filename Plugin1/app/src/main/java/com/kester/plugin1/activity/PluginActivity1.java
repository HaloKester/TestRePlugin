package com.kester.plugin1.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kester.plugin1.R;
import com.kester.plugin1.service.PluginService1;
import com.qihoo360.replugin.RePlugin;

/**
 * Created by kester on 2017/7/9.
 */
public class PluginActivity1 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin1);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                openHostActivity1();
                break;

            case R.id.btn2:
                openPluginActivity2();
                break;

            case R.id.btn3:
                openHostService1();
                break;

            case R.id.btn4:
                openPluginService1();
                break;

            default:
                break;
        }
    }

    private void openHostActivity1() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.kester.host", "com.kester.host.activity.HostActivity1"));
        startActivity(intent);
    }

    private void openPluginActivity2() {
        startActivity(new Intent(PluginActivity1.this, PluginActivity2.class));
    }

    private void openHostService1() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.kester.host", "com.kester.host.service.HostService1"));
        startService(intent);
    }

    private void openPluginService1() {
        startService(new Intent(PluginActivity1.this, PluginService1.class));
    }
}
