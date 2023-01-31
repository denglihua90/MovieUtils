package com.dlh.movieutils.ui.page.home.playdetails;

import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableParcelable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dlh.dlhlibrary.network.BaseObserver;
import com.dlh.dlhlibrary.network.NetworkManager;
import com.dlh.dlhlibrary.ui.page.BaseViewMode;
import com.dlh.dlhlibrary.utils.MmkvUtils;
import com.dlh.movieutils.BR;
import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.Epsodelist;
import com.dlh.movieutils.bean.IQiyiTVListBean;
import com.dlh.movieutils.bean.PalyTvBean;

import com.dlh.movieutils.bean.SingleChoice;
import com.dlh.movieutils.bean.Tv;
import com.dlh.movieutils.config.ApiConst;
import com.dlh.movieutils.config.CommonConst;
import com.dlh.movieutils.http.HttpManager;
import com.dlh.movieutils.http.api.IQiyiApiService;
import com.dlh.movieutils.ui.page.home.content.ContentViewModel;
import com.dlh.movieutils.ui.page.jx.ParserBean;
import com.dylanc.loadingstateview.LoadingStateView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.internal.observers.BlockingBaseObserver;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSerialized;
import me.tatarka.bindingcollectionadapter2.BindingListViewAdapter;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @author: dlh
 * @date:     /6/11
 * @description
 */
public class PalyDetailsViewModel extends BaseViewMode {
    public final ObservableField<ParserBean> observableParserBean=new ObservableField<>();
    public final ObservableField<Tv> tvObservableField=new ObservableField<>();
    public final MutableLiveData<Epsodelist> epsodelistLiveData=new MutableLiveData<>();
//    public final ObservableField<Epsodelist> observableEpsode=new ObservableField<>();
    public final ObservableBoolean rvEpisodesDivider = new ObservableBoolean(true);
    public final ObservableList<Epsodelist> itemEpsodelist = new ObservableArrayList<>();
    public final BindingRecyclerViewAdapter<Epsodelist> adapter = new BindingRecyclerViewAdapter<>();

    public final MutableLiveData<Boolean> mMoiveViewState= new MutableLiveData<>(true);

    boolean frist=true;
    int checkIndex=-1;
    public BindingRecyclerViewAdapter.ItemIds itemIds= new BindingRecyclerViewAdapter.ItemIds<Epsodelist>() {
        @Override
        public long getItemId(int position, Epsodelist item) {
            item.setIndex(position);
            if(frist){
            if(position==0){
                epsodelistLiveData.postValue(item);
                checkIndex=position;
                item.setChecked(true);
            }else{
                item.setChecked(false);
            }
                frist=false;
            }else{

                if(item.isChecked()){
                    checkIndex=position;
                }

            }


            return position;
        }
    };


    public final ItemBinding<Epsodelist> itemEpsodeBinding =
            ItemBinding.<Epsodelist>of(BR.itemEpsodelist, R.layout.rv_item_epsode_layout)
            .bindExtra(BR.itemEpsodelistClick, (OnEpsodelistClickListener<Epsodelist>) item -> {

                item.setChecked(true);
                epsodelistLiveData.setValue(item);

                adapter.getAdapterItem(checkIndex).setChecked(false);
                adapter.notifyItemChanged(checkIndex);
                adapter.notifyItemChanged((int) item.getIndex());

            });



    //    public LoadingState itemLoadingState= LoadingState.FIRSTLOAD;
//    public LoadingState palyLoadingState= LoadingState.FIRSTLOAD;
//
//    public LoadingStateView itemLoadingView,palyLoadingView;




    public  void  getPalyInfos(long id){
        HttpManager.createService(IQiyiApiService.class).getPalyInfos(id).compose(NetworkManager.applySchedulers(new BaseObserver<IQiyiTVListBean<List<Epsodelist>>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(IQiyiTVListBean<List<Epsodelist>> listIQiyiTVListBean) {
                if(listIQiyiTVListBean!=null&&!TextUtils.isEmpty(listIQiyiTVListBean.getCode())&&listIQiyiTVListBean.getCode().equals(ApiConst.IQIYI_LIST_SUCCESS_CODE)){
                    if(listIQiyiTVListBean.getData()!=null){
                        itemEpsodelist.clear();
                        List<Epsodelist> list= listIQiyiTVListBean.getData();
                        if(tvObservableField.get().getChannelId()==6) {
                            list = list.stream().sorted(Comparator.comparing(Epsodelist::getPublishTime).reversed())
                                    .collect(Collectors.toList());
                        }

                        itemEpsodelist.addAll(list);

                    }
                }else{

                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        }));
    }

}
