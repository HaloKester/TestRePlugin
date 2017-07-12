package com.kester.host.aidl;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;

import com.kester.host.TestRepluginApplication;
import com.kester.host.receiver.HostReceiverD1;
import com.kester.host.utils.Constant;
import com.qihoo360.replugin.IHostBinderFetcher;

/**
 * Created by kester on 2017/7/10.
 */
public class HostAidlImpl extends IHostAidl.Stub{
    private HostReceiverD1 mHostReceiverD1;

    @Override
    public void registerHostReceiverD1() {
        mHostReceiverD1 = new HostReceiverD1();
        IntentFilter filter = new IntentFilter(Constant.ACTION_HOST_RECEIVER_D1);
        TestRepluginApplication.getInstance().registerReceiver(mHostReceiverD1, filter);
    }

    @Override
    public void unRegisterHostReceiverD1() {
        if (mHostReceiverD1 != null) {
            TestRepluginApplication.getInstance().unregisterReceiver(mHostReceiverD1);
        }
    }
}
