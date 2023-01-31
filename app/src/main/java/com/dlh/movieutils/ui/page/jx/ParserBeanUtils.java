package com.dlh.movieutils.ui.page.jx;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: dlh
 * @date:     /5/15
 * @description
 */
public  class  ParserBeanUtils {


    public static ArrayList<ParserBean> getDataList(){
        ArrayList<ParserBean> arrayList=new ArrayList<>();
        arrayList.add(new ParserBean("线路1(高速)","https://chaxun.truechat365.com/?url="));
//        map.put("高速接口/attakids","https://jsap.attakids.com/?url=");

        arrayList.add(new ParserBean("线路(高速)","https://jx.aidouer.net/?url="));


        arrayList.add(new ParserBean("线路2","https://jx.bozrc.com:4433/player/analysis.php?v="));
//        map.put("parwix解析/无广告","https://vip.parwix.com:4433/player/?url=");
        arrayList.add(new ParserBean("线路3","https://okjx.cc/?url="));
//        map.put("OK解析/无广告","https://okjx.cc/?url=");

         arrayList.add(new ParserBean("线路4","https://www.miaojx.tk/miao/?url="));
//        map.put("MiaoPlayer解析/无广告","https://www.miaojx.tk/miao/?url=");

        arrayList.add(new ParserBean("高清秒播","https://api.leduotv.com/wp-api/ifr.php?vid="));
        //        https://api.leduotv.com/wp-api/ifr.php?vid=
//        arrayList.add(new ParserBean("m1907","https://z1.m1907.cn/?jx="));
////        map.put("m1907"," https://z1.m1907.cn/?jx=");
        arrayList.add(new ParserBean("4kdv","https://jx.4kdv.com/?url="));
//        map.put("4K","https://jx.4kdv.com/?url=");
        return arrayList;
    }

}
