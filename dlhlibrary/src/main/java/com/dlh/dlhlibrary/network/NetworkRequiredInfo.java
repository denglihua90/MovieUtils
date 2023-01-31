package com.dlh.dlhlibrary.network;

import android.app.Application;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.dlh.dlhlibrary.BuildConfig;


/**
 * 网络访问信息
 *
 */
public class NetworkRequiredInfo implements INetworkRequiredInfo {

    private final Application application;

    public NetworkRequiredInfo(Application application){
        this.application = application;
    }

    /**
     * 版本名
     */
    @Override
    public String getAppVersionName() {

        String vName=AppUtils.getAppVersionName();
        LogUtils.d("vName",vName);
        return vName;
    }

    /**
     * 版本号
     */
    @Override
    public String getAppVersionCode() {

        int vCode= AppUtils.getAppVersionCode();
        LogUtils.d("vCode",vCode);
        return String.valueOf(vCode);
    }

    /**
     * 是否为debug
     */
    @Override
    public boolean isDebug() {

        return BuildConfig.DEBUG;
    }

    /**
     * 应用全局上下文
     */
    @Override
    public Application getApplicationContext() {
        return application;
    }
}
