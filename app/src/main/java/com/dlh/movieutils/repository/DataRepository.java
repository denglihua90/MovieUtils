package com.dlh.movieutils.repository;

import androidx.lifecycle.MutableLiveData;

import com.dlh.dlhlibrary.network.BaseObserver;
import com.dlh.dlhlibrary.network.NetworkManager;
import com.dlh.movieutils.bean.IQiyiTVListBean;
import com.dlh.movieutils.bean.Tv;
import com.dlh.movieutils.config.ApiConst;
import com.dlh.movieutils.http.HttpManager;
import com.dlh.movieutils.http.api.IQiyiApiService;
import com.kunminx.architecture.ui.callback.UnPeekLiveData;


import java.util.List;

/**
 * @author: dlh
 * @date:
 * @description
 */
public class DataRepository {

    private static final DataRepository S_REQUEST_MANAGER = new DataRepository();

    private DataRepository() {

    }

    public static DataRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    private final MutableLiveData<List<Tv>> mTvListLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Tv>>  getIQiyiTVList(int type) {
//        HttpManager.createService(IQiyiApiService.class).getList(type).compose(NetworkManager.applySchedulers(new BaseObserver<IQiyiTVListBean>() {
//            @Override
//            public void onSuccess(IQiyiTVListBean mIQiyiTVListBean) {
//                if(mIQiyiTVListBean!=null&&mIQiyiTVListBean.getCode().equals(ApiConst.IQIYI_LIST_SUCCESS_CODE)){
//                   if(mIQiyiTVListBean.getData()!=null&& mIQiyiTVListBean.getData().getList()!=null&&mIQiyiTVListBean.getData().getList().size()>0){
//                       List<Tv> mList=mIQiyiTVListBean.getData().getList();
//                       mTvListLiveData.setValue(mList);
//                   }else{
//                       //无数据
//                   }
//                }else{
//                    //请求服务器错误
//                }
//
//            }
//
//            @Override
//            public void onFailure(Throwable e) {
//                //请求服务器错误
//            }
//        }));

        return  mTvListLiveData;
    }
}
