package com.dlh.movieutils.ui.page.home.content;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;

import androidx.databinding.ObservableList;

import androidx.lifecycle.ViewModel;


import com.blankj.utilcode.util.ActivityUtils;

import com.dlh.dlhlibrary.network.BaseObserver;
import com.dlh.dlhlibrary.network.NetworkManager;

import com.dlh.dlhlibrary.ui.page.BaseViewMode;
import com.dlh.movieutils.BR;
import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.Data;
import com.dlh.movieutils.bean.IQiyiTVListBean;
import com.dlh.movieutils.bean.Tv;
import com.dlh.movieutils.config.ApiConst;
import com.dlh.movieutils.config.CommonConst;
import com.dlh.movieutils.http.HttpManager;
import com.dlh.movieutils.http.api.IQiyiApiService;


import com.dlh.movieutils.ui.page.home.ErrorViewDelegate;
import com.dlh.movieutils.ui.page.home.playdetails.PalyDetailsActivity;
import com.dylanc.loadingstateview.LoadingStateView;
import com.dylanc.loadingstateview.ViewType;


import java.util.List;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class ContentViewModel extends BaseViewMode {
    // TODO: Implement the ViewModel
    public final ObservableBoolean rvGridDividerItemDecoration = new ObservableBoolean(true);
    public  ObservableList<Tv> items = new ObservableArrayList<>();

    OnItemClickListener listener= item -> {
//        ToastUtils.showShort(item.getTitle());
        Context context =ActivityUtils.getTopActivity();
        Intent intent=new Intent();
        intent.setClass(context,PalyDetailsActivity.class);
        intent.putExtra(CommonConst.PALY_TV_KEY,item);
        context.startActivity(intent);

    };
    public  ItemBinding<Tv> itemBinding = ItemBinding.<Tv>of(BR.item, R.layout.fragment_content_rv_item).bindExtra(BR.itemClickListener,listener);
    public final BindingRecyclerViewAdapter<Tv> adapter = new BindingRecyclerViewAdapter<>();

    public LoadingStateView loadingStateView;

    private int mPageNum = 1;
    public  LoadingState mLoadingState=LoadingState.FIRSTLOAD;


    public interface OnItemClickListener {
        void onItemClick(Tv item);
    }
    public  void getPageList(int type) {
      if(mLoadingState==LoadingState.REFRESH|mLoadingState==LoadingState.FIRSTLOAD){
          if(mLoadingState==LoadingState.FIRSTLOAD) {
              loadingStateView.showLoadingView();
          }
          mPageNum=1;
        }
        HttpManager.createService(IQiyiApiService.class).getList(type,mPageNum).compose(NetworkManager.applySchedulers(new BaseObserver<IQiyiTVListBean<Data>>() {
            @Override
            public void onSuccess(IQiyiTVListBean<Data> mIQiyiTVListBean) {
                if(mIQiyiTVListBean!=null&&!TextUtils.isEmpty(mIQiyiTVListBean.getCode())&&mIQiyiTVListBean.getCode().equals(ApiConst.IQIYI_LIST_SUCCESS_CODE)){
                    if(mIQiyiTVListBean.getData()!=null&& mIQiyiTVListBean.getData().getList()!=null&&mIQiyiTVListBean.getData().getList().size()>0){
                        List<Tv> mList=mIQiyiTVListBean.getData().getList();
                        if(mLoadingState!=LoadingState.LOADMORE) {
                            items.clear();
                        }
                        items.addAll(mList);
                       loadingStateView.showContentView();
                        mPageNum++;
                    }else{
                        //无数据
                        if(mLoadingState!=LoadingState.LOADMORE) {
                            loadingStateView.showEmptyView();
                        }

                    }
                }else{
                    //请求服务器错误

                    if(mLoadingState!=LoadingState.LOADMORE) {
                        loadingStateView.showErrorView();
                        loadingStateView.updateViewDelegate(ViewType.ERROR, (ErrorViewDelegate delegate) ->
                                delegate.updateMsg("网络开小差了···，请稍后重试"));

                    }
                }

            }

            @Override
            public void onFailure(Throwable e) {
                //请求服务器错误
                if(mLoadingState!=LoadingState.LOADMORE) {
                    loadingStateView.showErrorView();
                    loadingStateView.updateViewDelegate(ViewType.ERROR, (ErrorViewDelegate delegate) ->
                            delegate.updateMsg("网络开小差了···，请稍后重试"));
                }

            }
        }));


    }
}