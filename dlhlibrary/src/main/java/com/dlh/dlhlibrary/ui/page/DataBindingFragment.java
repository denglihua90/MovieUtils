package com.dlh.dlhlibrary.ui.page;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;



/**
 * @author: dlh
 * @date:
 * @description
 */
public abstract class DataBindingFragment extends Fragment {
    protected AppCompatActivity mActivity;
    private ViewDataBinding mBinding;
    private TextView mTvStrictModeTip;
//    private LoadingStateView loadingStateView;
//
//    public LoadingStateView getLoadingStateView() {
//        return loadingStateView;
//    }

    public DataBindingFragment() {
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mActivity = (AppCompatActivity)context;
    }

    protected abstract void initViewModel();

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initViewModel();
    }

    protected abstract DataBindingConfig getDataBindingConfig();


    protected ViewDataBinding getBinding() {
        if (this.isDebug() && this.mBinding != null && this.mTvStrictModeTip == null) {
//            this.mTvStrictModeTip = new TextView(this.getContext());
//            this.mTvStrictModeTip.setAlpha(0.5F);
//            this.mTvStrictModeTip.setPadding(this.mTvStrictModeTip.getPaddingLeft() + 24, this.mTvStrictModeTip.getPaddingTop() + 64, this.mTvStrictModeTip.getPaddingRight() + 24, this.mTvStrictModeTip.getPaddingBottom() + 24);
//            this.mTvStrictModeTip.setGravity(1);
//            this.mTvStrictModeTip.setTextSize(10.0F);
//            this.mTvStrictModeTip.setBackgroundColor(-1);
//            String tip = this.getString(string.debug_databinding_warning, new Object[]{this.getClass().getSimpleName()});
//            this.mTvStrictModeTip.setText(tip);
//            ((ViewGroup)this.mBinding.getRoot()).addView(this.mTvStrictModeTip);
        }

        return this.mBinding;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DataBindingConfig dataBindingConfig = this.getDataBindingConfig();
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, dataBindingConfig.getLayout(), container, false);
        binding.setLifecycleOwner(this.getViewLifecycleOwner());
        binding.setVariable(dataBindingConfig.getVmVariableId(), dataBindingConfig.getStateViewModel());
        SparseArray<Object> bindingParams = dataBindingConfig.getBindingParams();
        int i = 0;

        for(int length = bindingParams.size(); i < length; ++i) {
            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }

        this.mBinding = binding;
//        loadingStateView = new LoadingStateView(binding.getRoot());
//
//        return loadingStateView.getDecorView();

        return binding.getRoot();
    }

    public boolean isDebug() {
        return this.mActivity.getApplicationContext().getApplicationInfo() != null && (this.mActivity.getApplicationContext().getApplicationInfo().flags & 2) != 0;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mBinding.unbind();
        this.mBinding = null;
    }
}
