package com.dlh.movieutils.ui.binding_adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;

import com.dlh.movieutils.ui.page.jx.JxPalyFragment;
import com.dlh.movieutils.ui.page.jx.JxPalyViewModel;
import com.dlh.movieutils.ui.page.jx.ParserBean;
import com.google.android.material.tabs.TabLayout;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.DefaultWebClient;

/**
 * @author: dlh
 * @date:     /6/26
 * @description
 */
public class JxPalyFragmentBingdingAdpter {

    @BindingAdapter(value = {"jxAppCompatSpinner"}, requireAll = false)
    public static void jxAppCompatSpinner(AppCompatSpinner mAppCompatSpinner, JxPalyViewModel mViewModel) {
        mAppCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ParserBean mParserBean= (ParserBean) parent.getAdapter().getItem(position);
//
                mViewModel.payUrl.postValue(mParserBean.getUrl());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
