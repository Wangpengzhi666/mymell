package com.wpzmall.mymall.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.wpzmall.mymall.model.Bean.Registered.RegisteredBean;
import com.wpzmall.mymall.model.Bean.login.LoginBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.iview.IRegView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/12  21:59
 * <p>
 * 思路：
 */


public class RegPresenter extends BasePresenter<IRegView>  {
    private String url="http://169.254.164.252/mobile/";
    private String act="login";
    private String op="register";
    private String SYSTEM_TYPE = "android";

    //注册的方法
    public void getRegisterNwtWorkData(String name, String pwd,String pwd_confirm, String email ) {
        HttpUtils.getRegHttpData(url, new Observer<RegisteredBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull RegisteredBean o) {
                Log.e("onNext  注册  :   " , o.toString());
                getmT().callbackData(o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                getmT().callbackErrer(new Throwable(e).toString());
            }

            @Override
            public void onComplete() {

            }
        },act,op,name, pwd,pwd_confirm,email,SYSTEM_TYPE);

    }
}
