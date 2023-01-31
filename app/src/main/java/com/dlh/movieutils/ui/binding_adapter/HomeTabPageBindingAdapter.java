package com.dlh.movieutils.ui.binding_adapter;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.HomeBundleBean;
import com.dlh.movieutils.ui.adapter.HomeViewPager2Adapter;
import com.dlh.movieutils.ui.page.home.content.ContentFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dlh
 * @date:     /6/6
 * @description
 */
public class HomeTabPageBindingAdapter {

    @BindingAdapter(value = {"titles","homefragment"}, requireAll = false)
    public static void initTabAndPage(TabLayout tabLayout, ArrayList<HomeBundleBean> tabs, Fragment fragment) {
        ViewPager2 homeViewPager2 =tabLayout.getRootView().findViewById(R.id.home_view_pager2);
        List<Fragment> tabsF=new ArrayList<>();
        for (int i=0;i<tabs.size();i++){

                tabsF.add(ContentFragment.newInstance(tabs.get(i)));


        }
        HomeViewPager2Adapter homeViewPager2Adapter=new HomeViewPager2Adapter(fragment,tabsF);
        homeViewPager2.setAdapter(homeViewPager2Adapter);
        TabLayoutMediator mTabLayoutMediator=  new TabLayoutMediator(tabLayout, homeViewPager2, (tab, position) -> {
            // position of the current tab and that tab
            tab.setText(tabs.get(position).getTabTitle());
        });
        mTabLayoutMediator.attach();

    }

    @BindingAdapter(value = {"tabSelectedListener"}, requireAll = false)
    public static void tabSelectedListener(TabLayout tabLayout, TabLayout.OnTabSelectedListener listener) {
        tabLayout.addOnTabSelectedListener(listener);
    }
}
