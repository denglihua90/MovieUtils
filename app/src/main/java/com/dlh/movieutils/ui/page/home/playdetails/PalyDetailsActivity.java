package com.dlh.movieutils.ui.page.home.playdetails;



import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;

import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import android.widget.TextView;


import androidx.annotation.Nullable;

import androidx.lifecycle.Observer;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;

import com.dlh.dlhlibrary.ui.page.BaseActivity;
import com.dlh.dlhlibrary.ui.page.DataBindingConfig;
import com.dlh.dlhlibrary.utils.MmkvUtils;

import com.dlh.movieutils.BR;
import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.Epsodelist;
import com.dlh.movieutils.bean.Tv;
import com.dlh.movieutils.config.CommonConst;
import com.dlh.movieutils.databinding.ActivityPalyDetailsBinding;
import com.dlh.movieutils.ui.page.jx.ParserBean;
import com.dlh.movieutils.ui.page.jx.ParserBeanUtils;
import com.dlh.movieutils.ui.page.jx.ParserSpinnerAdapter;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;

import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

public class PalyDetailsActivity extends BaseActivity {
    private PalyDetailsViewModel palyDetailsViewModel;

    private ActivityPalyDetailsBinding mActivityPalyDetailsBinding;
    protected AgentWeb mAgentWeb;
    protected ParserSpinnerAdapter spinnerAdapter = new ParserSpinnerAdapter(ParserBeanUtils.getDataList());
    protected Tv mtv;
    protected int spinnerIndex;
    private View mMoiveView = null;
    private ViewGroup mMoiveParentView = null;

    @Override
    protected void initViewModel() {
        palyDetailsViewModel = getActivityScopeViewModel(PalyDetailsViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        DataBindingConfig bindingConfig = new DataBindingConfig(R.layout.activity_paly_details, BR.mPalyModel, palyDetailsViewModel);
        bindingConfig.addBindingParam(BR.mSpinnerAdapter, spinnerAdapter);
        return bindingConfig;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
//        BarUtils.setStatusBarLightMode(this, true);
        mActivityPalyDetailsBinding = (ActivityPalyDetailsBinding) getBinding();
        BarUtils.addMarginTopEqualStatusBarHeight(mActivityPalyDetailsBinding.playVideoView);

        if (getIntent() != null) {
            mtv = getIntent().getParcelableExtra(CommonConst.PALY_TV_KEY);

            palyDetailsViewModel.tvObservableField.set(mtv);
            palyDetailsViewModel.getPalyInfos(mtv.getAlbumId());
        }

        spinnerIndex = MmkvUtils.decodeInt(CommonConst.PALY_LINE_KEY);
        if (spinnerIndex > spinnerAdapter.getCount()) {
            spinnerIndex = 0;
        }
        LogUtils.dTag("MmkvUtils", spinnerIndex);
        ParserBean m = (ParserBean) spinnerAdapter.getItem(spinnerIndex);
        palyDetailsViewModel.observableParserBean.set(m);

        mActivityPalyDetailsBinding.palySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ParserBean mParserBean = (ParserBean) parent.getAdapter().getItem(position);
                palyDetailsViewModel.observableParserBean.set(mParserBean);
                mAgentWeb.getUrlLoader().loadUrl(getUrl());
                MmkvUtils.save(CommonConst.PALY_LINE_KEY, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initVideoView();


        palyDetailsViewModel.epsodelistLiveData.observe(this, new Observer<Epsodelist>() {
            @Override
            public void onChanged(Epsodelist epsodelist) {
                mAgentWeb.getUrlLoader().loadUrl(getUrl());
            }
        });


    }

    protected void initVideoView() {
        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(mActivityPalyDetailsBinding.playVideoView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))//??????AgentWeb???????????????
                .useDefaultIndicator(-1, 3)//?????????????????????????????????-1????????????????????????2????????????dp???
//                .setAgentWebWebSettings(getSettings())//?????? IAgentWebSettings???
                .setWebViewClient(mWebViewClient)//WebViewClient ??? ??? WebView ???????????? ?????????????????????WebView??????setWebViewClient(xx)?????????,?????????AgentWeb DefaultWebClient,???????????????????????????????????????
                .setWebChromeClient(mWebChromeClient) //WebChromeClient
//                .setPermissionInterceptor(mPermissionInterceptor) //???????????? 2.0.0 ?????????
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK) //???????????? Android 4.2.2 ??????????????????????????? ?????????AgentWebView????????????
//                .setAgentWebUIController(new UIController(getActivity())) //?????????UI  AgentWeb3.0.0 ?????????
                .setMainFrameErrorView(R.layout.layout_error, -1) //??????1?????????????????????????????????2??????????????????ID -1???????????????????????????????????? AgentWeb 3.0.0 ?????????
//                .useMiddlewareWebChrome(getMiddlewareWebChrome()) //??????WebChromeClient????????????????????????WebChromeClient???AgentWeb 3.0.0 ?????????
//                .additionalHttpHeader(getUrl(), "cookie", "41bc7ddf04a26b91803f6b11817a5a1c")
//                .useMiddlewareWebClient(getMiddlewareWebClient()) //??????WebViewClient????????????????????????WebViewClient??? AgentWeb 3.0.0 ?????????
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)//???????????????????????????????????????????????????????????? AgentWeb 3.0.0 ?????????
                .interceptUnkownUrl() //??????????????????????????????Url AgentWeb 3.0.0 ?????????
                .createAgentWeb()//??????AgentWeb???
                .ready()//?????? WebSettings???
                .go(getUrl()); //WebView?????????url???????????????????????????


    }

    private String getUrl() {
//        String BaseURL="https://vip.parwix.com:4433/player/?url=";
        String BaseURL = palyDetailsViewModel.observableParserBean.get().getUrl();
        String dUrl = "https://v.qq.com/x/cover/mzc00200ccaqs78.html";

        if (palyDetailsViewModel.epsodelistLiveData.getValue() != null && !TextUtils.isEmpty(palyDetailsViewModel.epsodelistLiveData.getValue().getPlayUrl())) {
            dUrl = palyDetailsViewModel.epsodelistLiveData.getValue().getPlayUrl();
        } else {
            dUrl = mtv.getPlayUrl();
        }
        return BaseURL + dUrl;
    }

    private com.just.agentweb.WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            Log.i("onPageStarted", "BaseWebActivity request-->" + request.toString() + "---->" + view.getTitle());
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("onPageStarted", "BaseWebActivity onPageStarted");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.i("onPageStarted", "BaseWebActivity onPageFinished");
        }

    };
    private com.just.agentweb.WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
//            if (mActivityPalyDetailsBinding.toolbarTitle != null) {
//                mActivityPalyDetailsBinding.toolbarTitle.setText(title);
//            }
        }
    };

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
//        Configuration.ORIENTATION_LANDSCAPE
//        Configuration.ORIENTATION_PORTRAIT
        LogUtils.dTag("onConfigurationChanged", "newConfig----->" + newConfig.orientation);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FrameLayout mDecorView = (FrameLayout) this.getWindow().getDecorView();
            mMoiveParentView = new FrameLayout(this);
            mMoiveView = getLayoutInflater().inflate(R.layout.movie_land_layout, null, false);

            palyDetailsViewModel.mMoiveViewState.setValue(true);

            mMoiveParentView.setOnTouchListener((v, event) -> {

                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                        palyDetailsViewModel.mMoiveViewState.setValue(!palyDetailsViewModel.mMoiveViewState.getValue());



                }


                return false;
            });
            TextView tvTitle = mMoiveView.findViewById(R.id.movie_title);
            if(mtv.getChannelId()==CommonConst.CHANNEL_MOVIE) {
                tvTitle.setText(mtv.getTitle());
            }else {
                if(palyDetailsViewModel.epsodelistLiveData.getValue()!=null) {
                    tvTitle.setText(palyDetailsViewModel.epsodelistLiveData.getValue().getName());
                }
            }


            mMoiveParentView.addView(this.mMoiveView);
            mDecorView.addView(mMoiveParentView);

            palyDetailsViewModel.mMoiveViewState.observe(this, aBoolean -> {
                if (mMoiveParentView != null) {
                    if (aBoolean) {
                        this.mMoiveView.setVisibility(View.VISIBLE);

                    } else {
                        this.mMoiveView.setVisibility(View.GONE);
                    }

                    LogUtils.dTag("dlhonTouch", "aBoolean-->" + aBoolean);
                }
            });

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

//        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_BACK) {//?????????
            LogUtils.dTag("dlh", "onKeyDown");
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
        mActivityPalyDetailsBinding.palySpinner.setSelection(spinnerIndex);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("Info", "onResult:" + requestCode + " onResult:" + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mAgentWeb.destroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }


}