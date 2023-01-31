package com.dlh.movieutils.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dlh
 * @date:     /6/6
 * @description
 */
public class HomeViewPager2Adapter extends FragmentStateAdapter {

    private  List<Fragment> mList;
    public HomeViewPager2Adapter(@NonNull Fragment fragment,List<Fragment> fragmentList) {
        super(fragment);
        this.mList=fragmentList;
    }

    public HomeViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Fragment> fragmentList) {
        super(fragmentManager, lifecycle);
        this.mList=fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mList.get(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
