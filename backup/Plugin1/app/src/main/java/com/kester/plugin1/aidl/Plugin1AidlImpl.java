package com.kester.plugin1.aidl;

import android.content.IntentFilter;
import android.os.RemoteException;

import com.kester.plugin1.receiver.PluginReceiverD1;
import com.kester.plugin1.utils.Constant;
import com.qihoo360.replugin.RePlugin;

/**
 * Created by kester on 2017/7/10.
 */
public class Plugin1AidlImpl extends IPlugin1Aidl.Stub{
    private PluginReceiverD1 mPlugin1ReceiverD1;

    @Override
    public void registerPluginReceiverD1() throws RemoteException {
        mPlugin1ReceiverD1 = new PluginReceiverD1();
        IntentFilter filter = new IntentFilter(Constant.ACTION_PLUGIN_RECEIVER_D1);
        RePlugin.getPluginContext().registerReceiver(mPlugin1ReceiverD1, filter);
    }

    @Override
    public void unRegisterPluginReceiverD1() throws RemoteException {
        if (mPlugin1ReceiverD1 != null) {
            RePlugin.getPluginContext().unregisterReceiver(mPlugin1ReceiverD1);
        }
    }
}
