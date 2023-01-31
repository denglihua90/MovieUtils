package com.dlh.movieutils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;


import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;

import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;



/**
 * @author: dlh
 * @date:
 * @description
 */
@GlideModule
public class MovieUtilsGlideModule  extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);


        long maxMemory = Runtime.getRuntime().maxMemory();
        //设置缓存的大小
        long cacheSize = maxMemory / 8;

        MemorySizeCalculator.Builder builderCalculator= new MemorySizeCalculator.Builder(context);
        int defaultMemoryCacheSize = builderCalculator.build().getMemoryCacheSize();
        int defaultBitmapPoolSize = builderCalculator.build().getBitmapPoolSize();
        int defaultArrayPoolSize = builderCalculator.build().getArrayPoolSizeInBytes();
        builderCalculator.setMemoryCacheScreens(2);//内存缓存的屏数
        builderCalculator.setBitmapPoolScreens(3);//BitmapPool的屏数
        builderCalculator.setMaxSizeMultiplier(0.3f);//从进程可用内存划分的比例
        builderCalculator.setLowMemoryMaxSizeMultiplier(0.3f);//低内存设备时从进程可用内存划分的比例
        builder.setMemorySizeCalculator(builderCalculator);
        // Default empty impl.
        builder.setArrayPool(new LruArrayPool(defaultArrayPoolSize/2));
        //设置Bitmap的缓存池
        builder.setBitmapPool(new LruBitmapPool(defaultBitmapPoolSize/2));//位图池缓存
        //设置内存缓存
        builder.setMemoryCache(new LruResourceCache(cacheSize));//内存缓存
        //设置磁盘缓存大小
        int diskCacheSizeBytes = 1024 * 1024 * 500;  //100 MB 最多可以缓存多少字节的数据
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, diskCacheSizeBytes));//内部存储
        builder.setDiskCache(new ExternalPreferredCacheDiskCacheFactory(context,diskCacheSizeBytes));//外部存储
        //设置读取不在缓存中资源的线程
        builder.setSourceExecutor(GlideExecutor.newSourceExecutor());
        //设置读取磁盘缓存中资源的线程
        builder.setDiskCacheExecutor(GlideExecutor.newDiskCacheExecutor());
        //设置日志级别
        builder.setLogLevel(Log.DEBUG);
        //设置全局选项
        RequestOptions mRequestOptions=new RequestOptions();
        mRequestOptions.format(DecodeFormat.PREFER_RGB_565);
        builder.setDefaultRequestOptions(mRequestOptions);









    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
