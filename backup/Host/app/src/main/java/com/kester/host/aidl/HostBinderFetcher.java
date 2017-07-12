package com.kester.host.aidl;

import android.os.IBinder;
import android.text.TextUtils;

import com.kester.host.utils.Constant;
import com.qihoo360.replugin.IHostBinderFetcher;

/**
 * Created by kester on 2017/7/11.
 */
public class HostBinderFetcher implements IHostBinderFetcher{
    @Override
    public IBinder query(String module) {
        if (TextUtils.isEmpty(module)) {
            return null;
        }
        if (module.equals(Constant.BINDER_HOST_AIDL)) {
            return new HostAidlImpl();
        }
        return null;
    }
}
