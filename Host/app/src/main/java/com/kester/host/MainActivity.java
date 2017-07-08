package com.kester.host;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.demo1).setOnClickListener(this);
        findViewById(R.id.install_demo1).setOnClickListener(this);
        findViewById(R.id.uninstall_demo1).setOnClickListener(this);
        findViewById(R.id.update_demo1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.demo1:
                RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("plugin1", "com.kester.plugin1.MainActivity"));
                break;

            case R.id.install_demo1:
                PluginInfo pi1 = RePlugin.install("/sdcard/Android/data/com.kester.host/cache/plugin1/v1/plugin1.apk");
                if (pi1 != null) {
                    RePlugin.preload(pi1);
                }

                break;

            case R.id.uninstall_demo1:
                RePlugin.uninstall("plugin1");
                break;

            case R.id.update_demo1:
                PluginInfo pi2 = RePlugin.install("/sdcard/Android/data/com.kester.host/cache/plugin1/v2/plugin1.apk");
                if (pi2 != null) {
                    RePlugin.preload(pi2);
                }
                break;

            default:
                break;
        }
    }
}
