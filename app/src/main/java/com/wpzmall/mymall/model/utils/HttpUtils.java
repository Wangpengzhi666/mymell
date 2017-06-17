package com.wpzmall.mymall.model.utils;


import android.database.Observable;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wpzmall.mymall.BuildConfig;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.view.iview.IClassBiz;
import com.wpzmall.mymall.view.iview.ILoginBiz;
import com.wpzmall.mymall.view.iview.IRegBiz;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/12  13:22
 * <p>
 * 思路：
 */


public class HttpUtils {

    public static void getLoginHttpData(String url, Observer observer,String act,
                                        String name,String pwd,String client){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.connectTimeout(20, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ILoginBiz inPostfix = build.create(ILoginBiz.class);
        inPostfix.postfix(act,name,pwd,client)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //注册方法
    public static void getRegHttpData(String url, Observer observer,String act,
                                      String op,String name,String pwd,
                                      String pwdc,String email,String client){


        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(20,TimeUnit.SECONDS);
        builder.connectTimeout(20, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IRegBiz postfix = build.create(IRegBiz.class);
        postfix.postfix(act,op,name,pwd,pwdc,email,client)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    //分类方法
    public static void getClassHttpData(String url, Observer observer,
                                        String act,String client){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(20,TimeUnit.SECONDS);
        builder.connectTimeout(20,TimeUnit.SECONDS);

        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IClassBiz classGetFix = build.create(IClassBiz.class);
        classGetFix.getData(act)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

}
