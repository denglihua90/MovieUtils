package com.dlh.movieutils.http.api;

import com.dlh.movieutils.bean.Data;
import com.dlh.movieutils.bean.Epsodelist;
import com.dlh.movieutils.bean.IQiyiTVListBean;
import com.dlh.movieutils.bean.PalyTvBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author: dlh
 * @date:
 * @description
 */
public interface IQiyiApiService {


    /**
     *
     * @param channel_id
     * @param page_id
     * @param page_id
     * @return
     * https://pcw-api.iqiyi.com/search/recommend/list?
     * channel_id=2&
     * data_type=1&
     * market_release_date_level=2020&
     * mode=11&
     * page_id=1&
     * ret_num=48&
     * three_category_id=16;must,24;must
     */

    @GET("/search/recommend/list?data_type=1&ret_num=48")
    Observable<IQiyiTVListBean<Data>> getList(@Query("channel_id") int channel_id,
                                              @Query("page_id") int page_id,
                                              @Query("mode") int mode,
                                              @Query("market_release_date_level") String date_level,
                                              @Query("three_category_id") String three_category_id

    );
    @GET("/search/recommend/list?data_type=1&mode=4&ret_num=48")
    Observable<IQiyiTVListBean<Data>> getList(@Query("channel_id") int channel_id,
                                              @Query("page_id") int page_id


    );

//    https://pcw-api.iqiyi.com/albums/album/avlistinfo?aid=7034693672247501&page=1&size=1000
    @GET("/albums/album/avlistinfo?page=1")
    Observable<IQiyiTVListBean<PalyTvBean>> getTvInfo(@Query("aid") long aid, @Query("size") int size);

//    https://pcw-api.iqiyi.com/video/video/baseinfo/1026471474188100
    @GET("/video/video/baseinfo/{aid}")
    Observable<IQiyiTVListBean<PalyTvBean>> getVideoInfo(@Path("aid") long aid);

//    https://pcw-api.iqiyi.com/album/bodan/childbodanlist/202861101
    @GET("album/bodan/childbodanlist/{albumId}")
    Observable<IQiyiTVListBean<List<Epsodelist>>> getPalyInfos(@Path("albumId") long albumId);



}
