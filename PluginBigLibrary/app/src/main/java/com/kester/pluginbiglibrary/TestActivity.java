package com.kester.pluginbiglibrary;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * Created by kester on 2017/7/14.
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.pbl_root);

        PLView1 view = new PLView1(TestActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(DisplayUtils.getScreenWidth(getBaseContext()), DisplayUtils.getScreenHeight(getBaseContext()));
        view.setLayoutParams(lp);
        ll.addView(view);
    }
}
