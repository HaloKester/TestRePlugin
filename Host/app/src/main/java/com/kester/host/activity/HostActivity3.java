package com.kester.host.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.kester.host.R;
import com.kester.host.utils.Dbg;
import com.qihoo360.replugin.RePlugin;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by kester on 2017/7/14.
 */
public class HostActivity3 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host3);
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
                usePluginBigLibraryView();
                break;

            case R.id.btn2:
                invokePluginBigLibraryMethod();
                break;

            default:
                break;
        }
    }

    private void invokePluginBigLibraryMethod() {
        Object object = null;
        try {
            ClassLoader loader = RePlugin.fetchClassLoader("plugin_bl");
            Class<?> clz = loader.loadClass("com.kester.pluginbiglibrary.PluginBigLibrary");
            Method method = clz.getMethod("getWidth", Context.class);
            object = method.invoke(clz, RePlugin.fetchContext("plugin_bl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (object == null) {
            return;
        }
        int width = (int) object;
        Dbg.e("width:"+width);
    }

    private void usePluginBigLibraryView() {
        Object object = null;
        try {
            ClassLoader loader = RePlugin.fetchClassLoader("plugin_bl");
            Class<?> clz = loader.loadClass("com.kester.pluginbiglibrary.PLView1");
            Constructor constructor = clz.getConstructor(Context.class);
            object = constructor.newInstance(RePlugin.fetchContext("plugin_bl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (object == null) {
            return;
        }
        View view = (View) object;
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll1);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
        view.setLayoutParams(lp);
        ll.addView(view);

    }
}
