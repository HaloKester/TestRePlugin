package com.kester.plugin1.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.kester.host.aidl.IHostAidl;
import com.kester.plugin1.R;
import com.kester.plugin1.receiver.PluginReceiverD1;
import com.kester.plugin1.utils.Constant;
import com.kester.plugin1.utils.DbHelper;
import com.kester.plugin1.utils.Dbg;
import com.qihoo360.replugin.RePlugin;

import static com.kester.plugin1.utils.Constant.AUTHORITY_PLUGIN_PROVIDER_S1;

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
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterHostReceiverD1();
        unRegisterPluginReceiverD1();
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

            case R.id.btn6:
                registerPluginReceiverD1();
                break;

            case R.id.btn7:
                openHostActivity2();
                break;

            case R.id.btn8:
                queryPluginProviderS1();
                break;

            case R.id.btn9:
                addData2PluginProviderS1();
                break;

            default:
                break;
        }
    }

    private void queryPluginProviderS1() {
        Uri uri = Uri.parse("content://"+ AUTHORITY_PLUGIN_PROVIDER_S1 + "/plugin_table1");
        Cursor cursor = null;
        try {
            ContentValues cv = new ContentValues();
            cv.put(DbHelper.PS1_COL_VALUE1, "hello");
            cv.put(DbHelper.PS1_COL_VALUE2, "world");
            cursor = getContentResolver().query(uri, null, null, null, null);
            while (cursor != null && cursor.moveToNext()) {
                String value1 = cursor.getString(cursor.getColumnIndex(DbHelper.PS1_COL_VALUE1));
                String value2 = cursor.getString(cursor.getColumnIndex(DbHelper.PS1_COL_VALUE2));
                int id = cursor.getInt(cursor.getColumnIndex(DbHelper.PS1_COL_PRIMARY_KEY));
                Dbg.e("id="+id+",value1="+value1+",value2="+value2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void addData2PluginProviderS1() {
        Uri uri = Uri.parse("content://"+ AUTHORITY_PLUGIN_PROVIDER_S1 + "/plugin_table1");
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.PS1_COL_VALUE1, "hello");
        cv.put(DbHelper.PS1_COL_VALUE2, "world");
        getContentResolver().insert(uri, cv);
    }

    private void openHostActivity2() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.kester.host", "com.kester.host.activity.HostActivity2"));
        startActivity(intent);
    }

    private PluginReceiverD1 mPluginReceiverD1;
    private void registerPluginReceiverD1() {
        mPluginReceiverD1 = new PluginReceiverD1();
        IntentFilter filter = new IntentFilter(Constant.ACTION_PLUGIN_RECEIVER_D1);
        registerReceiver(mPluginReceiverD1, filter);
    }
    private void unRegisterPluginReceiverD1() {
        if (mPluginReceiverD1 != null) {
            unregisterReceiver(mPluginReceiverD1);
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
