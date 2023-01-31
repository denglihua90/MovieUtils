package com.dlh.movieutils.ui.page.jx;



import androidx.lifecycle.ViewModelProvider;

import android.content.Context;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import android.widget.LinearLayout;

import com.dlh.dlhlibrary.ui.page.BaseFragment;
import com.dlh.dlhlibrary.ui.page.DataBindingConfig;
import com.dlh.movieutils.BR;
import com.dlh.movieutils.R;



import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.DefaultWebClient;

public class JxPalyFragment extends BaseFragment {

    private JxPalyViewModel mViewModel;

    private final ParserSpinnerAdapter mParserSpinnerAdapter=new ParserSpinnerAdapter(ParserBeanUtils.getDataList());
    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(JxPalyViewModel.class);


    }
    @Override
    protected DataBindingConfig getDataBindingConfig() {
        DataBindingConfig mDataBindingConfig=new DataBindingConfig(R.layout.fragment_jxpaly, BR.viewmodel,mViewModel);
        mDataBindingConfig.addBindingParam(BR.mButtonAction,new ButtonAction());
        mDataBindingConfig.addBindingParam(BR.mParserSpinnerAdapter,mParserSpinnerAdapter);
        return mDataBindingConfig;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ParserBean m= mParserSpinnerAdapter.getItem(0);
        mViewModel.payUrl.setValue(m.getUrl());

        initAgentWeb();


    }
    public  class  ButtonAction{
        public  void actionBtnPlay(){
            mViewModel.loadAgentWeb();
        }



    }
    private void initAgentWeb(){
      mViewModel.mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(getBinding().getRoot().findViewById(R.id.video_layout), -1, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))//传入AgentWeb的父控件。
                .useDefaultIndicator(-1, 3)//设置进度条颜色与高度，-1为默认值，高度为2，单位为dp。
//                .setAgentWebWebSettings(getSettings())//设置 IAgentWebSettings。
//                .setWebViewClient(mWebViewClient)//WebViewClient ， 与 WebView 使用一致 ，但是请勿获取WebView调用setWebViewClient(xx)方法了,会覆盖AgentWeb DefaultWebClient,同时相应的中间件也会失效。
//                .setWebChromeClient(new CommonWebChromeClient()) //WebChromeClient
//                .setPermissionInterceptor(mPermissionInterceptor) //权限拦截 2.0.0 加入。
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK) //严格模式 Android 4.2.2 以下会放弃注入对象 ，使用AgentWebView没影响。
//                .setAgentWebUIController(new UIController(getActivity())) //自定义UI  AgentWeb3.0.0 加入。
//                .setMainFrameErrorView(R.layout.agentweb_error_page, -1) //参数1是错误显示的布局，参数2点击刷新控件ID -1表示点击整个布局都刷新， AgentWeb 3.0.0 加入。
//                .useMiddlewareWebChrome(getMiddlewareWebChrome()) //设置WebChromeClient中间件，支持多个WebChromeClient，AgentWeb 3.0.0 加入。
//                .additionalHttpHeader(getUrl(), "cookie", "41bc7ddf04a26b91803f6b11817a5a1c")
//                .useMiddlewareWebClient(getMiddlewareWebClient()) //设置WebViewClient中间件，支持多个WebViewClient， AgentWeb 3.0.0 加入。
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)//打开其他页面时，弹窗质询用户前往其他应用 AgentWeb 3.0.0 加入。
                .interceptUnkownUrl() //拦截找不到相关页面的Url AgentWeb 3.0.0 加入。
                .createAgentWeb()//创建AgentWeb。
                .ready()//设置 WebSettings。
                .go(mViewModel.getUrl()); //WebView载入该url地址的页面并显示。

        // AgentWeb 没有把WebView的功能全面覆盖 ，所以某些设置 AgentWeb 没有提供 ， 请从WebView方面入手设置。
        mViewModel.mAgentWeb.getWebCreator().getWebView().setOverScrollMode(WebView.OVER_SCROLL_NEVER);

        AgentWebConfig.debug();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }







}