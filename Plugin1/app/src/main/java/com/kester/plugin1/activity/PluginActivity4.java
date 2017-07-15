package com.kester.plugin1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.kester.litlibrary.Dbg;
import com.kester.litlibrary.DisplayUtils;
import com.kester.plugin1.R;

/**
 * Created by kester on 2017/7/14.
 */
public class PluginActivity4 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin4);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                invokeLitLibraryMethod();
                break;

            default:
                break;
        }
    }

    private void invokeLitLibraryMethod() {
        int width = DisplayUtils.getScreenWidth(getApplicationContext());
        Dbg.e("width="+width+",from LitLibrary");
    }

}
