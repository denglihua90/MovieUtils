package com.dlh.movieutils.config;

import com.blankj.utilcode.util.Utils;
import com.dlh.movieutils.R;
import com.dlh.movieutils.bean.HomeBundleBean;

import java.util.ArrayList;

/**
 * @author: dlh

 * @description
 */
public  class CommonConst {


    // TODO:  tab 类型  传值
    /**
     * channel_id
     * 爱奇艺电视剧列表 channel_id=2 tv
     * 爱奇艺电影 channel_id=1 movie
     * 爱奇艺动漫 channel_id=4 Animation
     * 爱奇艺综艺 channel_id=6 variety
     */
    public static final int CHANNEL_TV=2;
    public static final int CHANNEL_MOVIE=1;
    public static final int CHANNEL_ANIMATION=4;
    public static final int CHANNEL_VARIETY=6;
    public static ArrayList<HomeBundleBean> getHomeTabPageTypeList(){
        ArrayList<HomeBundleBean> homeBundleBeanList=new ArrayList<>();
       String[] titles= Utils.getApp().getResources().getStringArray(R.array.tabsArray);
        for (int i=0;i<titles.length;i++){
            HomeBundleBean homeBundleBean=new HomeBundleBean();
            homeBundleBean.setTabTitle(titles[i]);
            if(i==0){
                homeBundleBean.setChannel_id(CHANNEL_TV);

            }else if(i==1){
                homeBundleBean.setChannel_id(CHANNEL_MOVIE);
            }else if(i==2){
                homeBundleBean.setChannel_id(CHANNEL_ANIMATION);
            }else if(i==3){
                homeBundleBean.setChannel_id(CHANNEL_VARIETY);
            }
            homeBundleBeanList.add(homeBundleBean);
        }

        return homeBundleBeanList;
    }
    public static String HOME_TAB_PAGE_TYPE_KEY="HOME_TAB_PAGE_TYPE_KEY";
    public static String PALY_TV_KEY="PALY_TV_KEY";

    public final static String PALY_LINE_KEY="PALY_LINE_KEY";



}
