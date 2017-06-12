package com.wpzmall.mymall.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import com.wpzmall.mymall.model.Bean.login.LoginBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.iview.ILoginView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginPresenter extends BasePresenter<ILoginView> {
    private String url="http://169.254.164.252/";
    private String act="login";
    private String SYSTEM_TYPE = "android";
    public void getLoginData(String name, String pwd ) {
        HttpUtils.getLoginHttpData(url, new Observer<LoginBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull LoginBean o) {
                Log.e("onNext  :   " , o.toString());
                getmT().callbackData(o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                getmT().callbackErrer(new Throwable(e).toString());
            }

            @Override
            public void onComplete() {

            }
        },act,name, pwd,SYSTEM_TYPE);

    }

}
