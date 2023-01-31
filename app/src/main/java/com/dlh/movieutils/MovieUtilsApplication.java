package com.dlh.movieutils;

import android.content.Context;

import com.dlh.dlhlibrary.BaseApplication;
import com.dlh.dlhlibrary.network.NetworkManager;
import com.dlh.dlhlibrary.network.NetworkRequiredInfo;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;

/**
 * @author: dlh
 * @date:
 * @description
 */
public class MovieUtilsApplication extends BaseApplication {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            layout.setPrimaryColorsId(R.color.purple_500, R.color.white);//全局设置主题颜色
            return  new MaterialHeader(context);
//                    new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        });
        //设置全局的Footer构建器

        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> {
            //指定为经典Footer，默认是 BallPulseFooter
            return new ClassicsFooter(context).setDrawableSize(20);
        });
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // TODO:     初始化网络框架
        NetworkManager.init(new NetworkRequiredInfo(this));

    }
}
