package com.dlh.dlhlibrary.ui.page;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;



/**
 * @author: dlh
 * @date:
 * @description
 */
public abstract class DataBindingActivity<T extends ViewDataBinding > extends AppCompatActivity {
    private ViewDataBinding mBinding;
    private TextView mTvStrictModeTip;

    public DataBindingActivity() {
    }

    protected abstract void initViewModel();

    protected abstract DataBindingConfig getDataBindingConfig();

    protected ViewDataBinding getBinding() {
//        if (this.isDebug() && this.mBinding != null && this.mTvStrictModeTip == null) {
//            this.mTvStrictModeTip = new TextView(this.getApplicationContext());
//            this.mTvStrictModeTip.setAlpha(0.4F);
//            this.mTvStrictModeTip.setPadding(this.mTvStrictModeTip.getPaddingLeft() + 24, this.mTvStrictModeTip.getPaddingTop() + 64, this.mTvStrictModeTip.getPaddingRight() + 24, this.mTvStrictModeTip.getPaddingBottom() + 24);
//            this.mTvStrictModeTip.setGravity(1);
//            this.mTvStrictModeTip.setTextSize(10.0F);
//            this.mTvStrictModeTip.setBackgroundColor(-1);
//            String tip = this.getString(string.debug_databinding_warning, new Object[]{this.getClass().getSimpleName()});
//            this.mTvStrictModeTip.setText(tip);
//            ((ViewGroup)this.mBinding.getRoot()).addView(this.mTvStrictModeTip);

//        }


        return this.mBinding;
    }

    public void setmBinding(ViewDataBinding mBinding) {
        this.mBinding = mBinding;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initViewModel();
        DataBindingConfig dataBindingConfig = this.getDataBindingConfig();
        ViewDataBinding binding = DataBindingUtil.setContentView(this, dataBindingConfig.getLayout());

        binding.setLifecycleOwner(this);
        binding.setVariable(dataBindingConfig.getVmVariableId(), dataBindingConfig.getStateViewModel());
        SparseArray<Object> bindingParams = dataBindingConfig.getBindingParams();
        int i = 0;

        for(int length = bindingParams.size(); i < length; ++i) {
            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }

        this.mBinding = binding;
    }

    public boolean isDebug() {
        return this.getApplicationContext().getApplicationInfo() != null && (this.getApplicationContext().getApplicationInfo().flags & 2) != 0;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mBinding.unbind();
        this.mBinding = null;
    }
}

