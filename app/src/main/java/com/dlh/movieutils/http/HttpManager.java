package com.dlh.movieutils.http;

import com.dlh.dlhlibrary.network.NetworkManager;
import com.dlh.movieutils.config.ApiConst;

/**
 * @author: dlh
 * @description
 */
public class HttpManager {

    public static <T> T createService(Class<T> serviceClass) {

        return NetworkManager.createService(serviceClass, ApiConst.IQIYI_BASE_URL);
    }

    public static <T> T createService(Class<T> serviceClass,String url) {

        return NetworkManager.createService(serviceClass, url);
    }
}
