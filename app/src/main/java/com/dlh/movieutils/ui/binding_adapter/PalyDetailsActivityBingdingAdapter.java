package com.dlh.movieutils.ui.binding_adapter;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.dlh.dlhlibrary.ui.recyclerview.GridSpacingItemDecoration;
import com.dlh.dlhlibrary.ui.recyclerview.SpaceItemDecoration;
import com.dlh.dlhlibrary.utils.ResourceDLHUtils;
import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.Main_charactor;
import com.dlh.movieutils.bean.People;
import com.dlh.movieutils.config.CommonConst;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

/**
 * @author: dlh
 * @date:
 * @description
 */
public class PalyDetailsActivityBingdingAdapter {

    @BindingAdapter(value = {"rvEpisodesDivider","rvChannel"}, requireAll = false)
    public static void rvEpisodesDivider(RecyclerView recyclerView, boolean rvEpisodesDivider,int rvChannel) {
        //直接清除动画
        recyclerView.setItemAnimator(null);
        //去除滑动阴影
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        if(rvChannel== CommonConst.CHANNEL_VARIETY){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        int spacing = (int) ResourceDLHUtils.getDimension(com.dlh.dlhlibrary.R.dimen.qb_px_10); // 50px
        SpaceItemDecoration spacingDecoration=new SpaceItemDecoration(spacing);
        recyclerView.addItemDecoration(spacingDecoration);
        }else{
            float w = ResourceDLHUtils.getDimension(com.dlh.dlhlibrary.R.dimen.qb_px_120);
            int rw = ScreenUtils.getScreenWidth();
            int spacing = (int) ResourceDLHUtils.getDimension(com.dlh.dlhlibrary.R.dimen.qb_px_20); // 50px
            int sc = (int) (rw / w);
            androidx.recyclerview.widget.GridLayoutManager manager = new GridLayoutManager(recyclerView.getContext(), sc);
            recyclerView.setLayoutManager(manager);
            GridSpacingItemDecoration itemDecoration = new GridSpacingItemDecoration(sc, spacing, rvEpisodesDivider);
            recyclerView.addItemDecoration(itemDecoration);
        }


//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        SpaceItemDecoration spacingDecoration=new SpaceItemDecoration(spacing);
//        recyclerView.addItemDecoration(spacingDecoration);


    }

    @BindingAdapter(value = {"bingPeople"}, requireAll = false)
    public static void bingPeople(TextView textView, People people) {
        StringBuffer mainCharactor =new StringBuffer("主演：");
        if (people != null && people.getMain_charactor() != null) {
            List<Main_charactor> main_charactorList = people.getMain_charactor();
            for (int i = 0; i <main_charactorList.size() ; i++) {
                if(i==main_charactorList.size()-1){
                    mainCharactor.append(main_charactorList.get(i).getName());
                }else{
                    mainCharactor.append(main_charactorList.get(i).getName()+",");
                }

            }
        }
        textView.setText(mainCharactor);
    }
}
