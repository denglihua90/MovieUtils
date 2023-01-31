package com.dlh.movieutils.ui.page.home;





import com.dlh.dlhlibrary.ui.page.BaseFragment;
import com.dlh.dlhlibrary.ui.page.DataBindingConfig;
import com.dlh.movieutils.BR;
import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.HomeBundleBean;
import com.dlh.movieutils.config.CommonConst;

import java.util.ArrayList;



public class HomeFragment extends BaseFragment {
    HomeViewModel homeViewModel;

    private ArrayList<HomeBundleBean> tabs;

    @Override
    protected void initViewModel() {

        homeViewModel=getFragmentScopeViewModel(HomeViewModel.class);
        tabs=CommonConst.getHomeTabPageTypeList();
    }



    @Override
    protected DataBindingConfig getDataBindingConfig() {
        DataBindingConfig mDataBindingConfig= new DataBindingConfig(R.layout.fragment_home,BR.vm,homeViewModel);
        mDataBindingConfig.addBindingParam(BR.fragment,this);
        mDataBindingConfig.addBindingParam(BR.tabs,tabs);
        return mDataBindingConfig;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}