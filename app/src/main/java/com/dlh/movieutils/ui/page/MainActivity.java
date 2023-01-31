package com.dlh.movieutils.ui.page;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.dlh.dlhlibrary.ui.page.BaseActivity;
import com.dlh.dlhlibrary.ui.page.DataBindingConfig;
import com.dlh.movieutils.BR;
import com.dlh.movieutils.R;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends BaseActivity {
    private MainActivityViewModel mState;
    @Override
    protected void initViewModel() {
        mState=getActivityScopeViewModel(MainActivityViewModel.class);
        BarUtils.setStatusBarLightMode(this,true);

        if(getSupportActionBar()!=null){
           getSupportActionBar().hide();
        }

    }


    @Override
    protected DataBindingConfig getDataBindingConfig() {
        DataBindingConfig mDataBindingConfig=  new DataBindingConfig(R.layout.activity_main, BR.vm,mState);
        mDataBindingConfig.addBindingParam(BR.mainActivity,this);
        return mDataBindingConfig;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 返回键
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtils.dTag("dlh","onBackPressed");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== KeyEvent.KEYCODE_BACK) {//返回键
            LogUtils.dTag("dlh","onBackPressed");
            exitBy2Click();
        }
        return false;
    }
    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }

}