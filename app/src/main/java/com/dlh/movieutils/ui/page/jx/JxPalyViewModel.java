package com.dlh.movieutils.ui.page.jx;


import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.just.agentweb.AgentWeb;

public class JxPalyViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<String> payUrl =new MutableLiveData<String>();
    public MutableLiveData<String> editUrl =new MutableLiveData<String>();

    public AgentWeb mAgentWeb;

    public  void loadAgentWeb(){
        if(mAgentWeb!=null) {
            mAgentWeb.getUrlLoader().loadUrl(getUrl());
        }
    }

    public String getUrl() {
        String dUrl="https://v.qq.com/x/cover/mzc00200ccaqs78.html";

        if(!TextUtils.isEmpty(payUrl.getValue())){
            dUrl=payUrl.getValue();
            if(!TextUtils.isEmpty(editUrl.getValue())){
                dUrl=  dUrl+ editUrl.getValue();
            }
            return dUrl;
        }

        return dUrl;

    }



}