package com.kester.host.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.kester.host.R;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;

/**
 * Created by kester on 2017/7/15.
 */
public class HostActivity4 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host4);
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
                installPlugin1();
                break;

            case R.id.btn2:
                uninstallPlugin1();
                break;

            case R.id.btn3:
                updatePlugin1();
                break;

            default:
                break;
        }
    }

    private void installPlugin1() {
        PluginInfo pi = RePlugin.install("/sdcard/Android/data/com.kester.host/cache/plugin1/v1/plugin1.apk");
        if (pi != null) {
            RePlugin.preload(pi);
        }
    }

    private void uninstallPlugin1() {
        RePlugin.uninstall("plugin1");
    }

    private void updatePlugin1() {
        PluginInfo pi = RePlugin.install("/sdcard/Android/data/com.kester.host/cache/plugin1/v2/plugin1.apk");
        if (pi != null) {
            RePlugin.preload(pi);
        }
    }
}
