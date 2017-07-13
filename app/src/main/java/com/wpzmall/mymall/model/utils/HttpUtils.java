package com.wpzmall.mymall.model.utils;


import android.database.Observable;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wpzmall.mymall.BuildConfig;
import com.wpzmall.mymall.model.Bean.Class.ExpandableBean;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.view.iview.ICartBiz;
import com.wpzmall.mymall.view.iview.IClassBiz;
import com.wpzmall.mymall.view.iview.IDetailsBiz;
import com.wpzmall.mymall.view.iview.IListBiz;
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

    //登录方法
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
    public static void getClassHttpData(String url, Observer observer){
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
        classGetFix.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //请求分类界面二级列表的数据
    public static void getClassExpandHttpData(String url, Observer observer, String gc_id){
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
        classGetFix.getData2(gc_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //列表页的数据
    public static void getListHttpData(String url, Observer observer, String page,
                                       String gc_id){
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
        IListBiz classGetFix = build.create(IListBiz.class);
        classGetFix.getData(page,gc_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //详情页数据
    public static void getDetailsHttpData(String url, Observer observer, String goods_id){
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
        IDetailsBiz classGetFix = build.create(IDetailsBiz.class);
        classGetFix.getData(goods_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //添加购物车的方法
    public static void getCartAddHttpData(String url, Observer observer,String key,
                                        String goods_id,String quantity){
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

        ICartBiz inPostfix = build.create(ICartBiz.class);
        inPostfix.postCartAdd(key,goods_id,quantity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //查询购物车的方法
    public static void getCartHttpData(String url, Observer observer,String key){
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

        ICartBiz inPostfix = build.create(ICartBiz.class);
        inPostfix.postCart(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //查询购物车删除的方法
    public static void getCartDellHttpData(String url, Observer observer,String key,String cart_id){
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

        ICartBiz inPostfix = build.create(ICartBiz.class);
        inPostfix.postCartDell(key,cart_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
