package com.dlh.dlhlibrary;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.blankj.utilcode.util.LogUtils;

import com.dlh.dlhlibrary.utils.MmkvUtils;
import com.getkeepsafe.relinker.ReLinker;

import com.tencent.mmkv.MMKV;

/**
 * @author: dlh
 * @date:
 * @description
 */
public class BaseApplication extends Application implements ViewModelStoreOwner {

    private ViewModelStore mAppViewModelStore;

    @Override
    public void onCreate() {
        super.onCreate();

//        Config.setLogSwitch              : 设置 log 总开关
        LogUtils.getConfig().setLogSwitch(BuildConfig.DEBUG);
//        Config.setConsoleSwitch          : 设置 log 控制台开关
        LogUtils.getConfig().setConsoleSwitch(BuildConfig.DEBUG);
//        Config.setGlobalTag              : 设置 log 全局 tag
        LogUtils.getConfig().setGlobalTag("base");
//        Config.setLogHeadSwitch          : 设置 log 头部信息开关
        LogUtils.getConfig().setLogHeadSwitch(BuildConfig.DEBUG);


        // TODO:     初始化 MMKV
        initMMKV();


        mAppViewModelStore = new ViewModelStore();
    }


    /**
     * 初始化 MMKV
     */
    protected void initMMKV(){
        if (Build.VERSION.SDK_INT == 19) {
            //一些 Android设备（API level 19）在安装/更新APK 时可能出错, 导致 libmmkv.so 找不到。
            MMKV.initialize(this, libName -> {
                //开源库[ReLinker](https://github.com/KeepSafe/ReLinker) 专门解决这个问题
                ReLinker.loadLibrary(getApplicationContext(), libName);
            });
        } else {
            //👇初始化代码，数据默认存储在：
            //context.getFilesDir().getAbsolutePath() + "/mmkv"
            MMKV.initialize(this);
        }
        // TODO:     获取defaultMMKV 对象
        MmkvUtils.getInstance();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }
}