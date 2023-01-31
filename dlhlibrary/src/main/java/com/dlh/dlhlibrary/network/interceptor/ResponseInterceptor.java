package com.dlh.dlhlibrary.network.interceptor;

import com.blankj.utilcode.util.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author: dlh
 * @date:
 * @description
 */
public class ResponseInterceptor implements Interceptor {

    private static final String TAG = "ResponseInterceptor";

    /**
     * 拦截
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        long requestTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        LogUtils.i(TAG, "requestSpendTime=" + (System.currentTimeMillis() - requestTime) + "ms");
        return response;
    }
}