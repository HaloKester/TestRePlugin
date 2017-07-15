package com.kester.host;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kester.host.activity.HostActivity1;
import com.kester.host.activity.HostActivity2;
import com.kester.host.activity.HostActivity3;
import com.kester.host.activity.HostActivity4;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.test_plugin_update).setOnClickListener(this);
        findViewById(R.id.test_activity_service).setOnClickListener(this);
        findViewById(R.id.test_provider_receiver).setOnClickListener(this);
        findViewById(R.id.test_library).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_plugin_update:
                startActivity(new Intent(MainActivity.this, HostActivity4.class));
                break;

            case R.id.test_activity_service:
                startActivity(new Intent(MainActivity.this, HostActivity1.class));
                break;

            case R.id.test_provider_receiver:
                startActivity(new Intent(MainActivity.this, HostActivity2.class));
                break;

            case R.id.test_library:
                startActivity(new Intent(MainActivity.this, HostActivity3.class));

            default:
                break;
        }
    }
}
