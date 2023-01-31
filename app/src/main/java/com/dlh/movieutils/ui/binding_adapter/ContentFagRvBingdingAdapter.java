package com.dlh.movieutils.ui.binding_adapter;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.dlh.dlhlibrary.ui.recyclerview.GridSpacingItemDecoration;
import com.dlh.dlhlibrary.utils.ResourceDLHUtils;
import com.dlh.movieutils.GlideApp;

import com.dlh.movieutils.bean.Tv;

import java.util.List;


/**
 * @author: dlh
 * @date:
 * @description
 */
public class ContentFagRvBingdingAdapter {
    @BindingAdapter(value = {"rvGridDividerItemDecoration"}, requireAll = false)
    public static void rvGridDividerItemDecoration(RecyclerView recyclerView,boolean rvGridDividerItemDecoration) {
        float w= ResourceDLHUtils.getDimension(com.dlh.dlhlibrary.R.dimen.qb_px_120);
        int rw= ScreenUtils.getScreenWidth();
        int sc= (int) (rw/w);
        LogUtils.dTag("dlh","w=="+w+"---->rw=="+rw+"---->sc=="+sc);

        //直接清除动画
        recyclerView.setItemAnimator(null);
        //去除滑动阴影
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        androidx.recyclerview.widget.GridLayoutManager manager=new GridLayoutManager(recyclerView.getContext(),sc);
        recyclerView.setLayoutManager(manager);

        int spanCount = sc; // 3 columns
        int spacing = (int) ResourceDLHUtils.getDimension(com.dlh.dlhlibrary.R.dimen.qb_px_10);
//        boolean includeEdge = true;
        GridSpacingItemDecoration itemDecoration=  new GridSpacingItemDecoration(spanCount, spacing, rvGridDividerItemDecoration);
        recyclerView.addItemDecoration(itemDecoration);


    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }

    @BindingAdapter(value ={"imageUrl","imageSize", "placeHolder", "error"},requireAll = false)
    public static void loadImage(ImageView imageView, String url, List<String> imageSize, Drawable holderDrawable, Drawable errorDrawable) {
//        260_360, 579_772, 318_424, 255_340
        if(imageSize.contains("579_772")){
            url= url.replace(".jpg","_579_772.webp");
        }else if(imageSize.contains("318_424")){
            url= url.replace(".jpg","_318_424.webp");

        } else if(imageSize.contains("260_360")){
            url= url.replace(".jpg","_260_360.webp");

        }else if(imageSize.contains("255_340")){
            url= url.replace(".jpg","_255_340.webp");

        }

        GlideApp.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .into(imageView);
    }

    @BindingAdapter(value ={"numbers"},requireAll = false)
    public static void numbers(TextView textView, Tv mTv) {
//        android:background="@color/gray_80"
        if(mTv.getChannelId()==1){
            textView.setText(mTv.getScore()+"");

        }else if(mTv.getChannelId()==6){
            textView.setText(mTv.getPeriod()+"");

        }else{
//            android:text='@{item.latestOrder==item.videoCount?:"更新至"+item.latestOrder+"集"}'
            if(mTv.getLatestOrder()==mTv.getVideoCount()){
                textView.setText("全"+mTv.getVideoCount()+"集");
            }else{
                textView.setText("更新至"+mTv.getLatestOrder()+"集");
            }
        }


    }


}
