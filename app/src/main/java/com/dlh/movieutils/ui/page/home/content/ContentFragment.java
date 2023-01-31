package com.dlh.movieutils.ui.page.home.content;


import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.dlh.dlhlibrary.ui.page.BaseFragment;
import com.dlh.dlhlibrary.ui.page.BaseViewMode;
import com.dlh.dlhlibrary.ui.page.DataBindingConfig;
import com.dlh.movieutils.BR;
import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.HomeBundleBean;
import com.dlh.movieutils.config.CommonConst;
import com.dlh.movieutils.ui.page.home.EmptyViewDelegate;
import com.dlh.movieutils.ui.page.home.ErrorViewDelegate;
import com.dlh.movieutils.ui.page.home.LoadingViewDelegate;
import com.dylanc.loadingstateview.LoadingStateView;
import com.dylanc.loadingstateview.OnReloadListener;
import com.dylanc.loadingstateview.ViewType;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;

public class ContentFragment extends BaseFragment {

    private ContentViewModel mContentViewModel;

    LoadingStateView loadingStateView;
    HomeBundleBean mHomeBundleBean;

    public static ContentFragment newInstance(HomeBundleBean mHomeBundleBean) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CommonConst.HOME_TAB_PAGE_TYPE_KEY, mHomeBundleBean);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    protected void initViewModel() {
        mContentViewModel = getFragmentScopeViewModel(ContentViewModel.class);

    }


    @Override
    protected DataBindingConfig getDataBindingConfig() {
        DataBindingConfig mDataBindingConfig = new DataBindingConfig(R.layout.fragment_content, BR.contentViewModel, mContentViewModel);

        return mDataBindingConfig;

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SmartRefreshLayout smartRefreshLayout=  view.findViewById(R.id.refreshLayout);

        loadingStateView=new LoadingStateView(smartRefreshLayout, () -> {
            mContentViewModel.mLoadingState= BaseViewMode.LoadingState.FIRSTLOAD;
            LogUtils.dTag("dlh","mErrorViewDelegate");

            if (mHomeBundleBean != null) {
                mContentViewModel.getPageList(mHomeBundleBean.getChannel_id());
            }
        });
        loadingStateView.register(new LoadingViewDelegate());
        loadingStateView.register(new ErrorViewDelegate());
        mContentViewModel.loadingStateView = loadingStateView;
        Bundle bundle = getArguments();
        mHomeBundleBean = bundle.getParcelable(CommonConst.HOME_TAB_PAGE_TYPE_KEY);
        mContentViewModel.mLoadingState= BaseViewMode.LoadingState.FIRSTLOAD;
        if (mHomeBundleBean != null) {
            mContentViewModel.getPageList(mHomeBundleBean.getChannel_id());
        }
        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mContentViewModel.mLoadingState= BaseViewMode.LoadingState.LOADMORE;
                if (mHomeBundleBean != null) {
                    mContentViewModel.getPageList(mHomeBundleBean.getChannel_id());
                }
                smartRefreshLayout.finishLoadMore();//传入false表示加载失败
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mContentViewModel.mLoadingState= BaseViewMode.LoadingState.REFRESH;
                if (mHomeBundleBean != null) {
                    mContentViewModel.getPageList(mHomeBundleBean.getChannel_id());
                }

                smartRefreshLayout.finishRefresh();//传入false表示刷新失败
            }
        });


    }


}