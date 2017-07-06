package com.wpzmall.mymall.presenter;

import android.util.Log;

import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.IClassView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/17  08:49
 * <p>
 * 思路：
 */


public class ClassPresenter extends BasePresenter<IClassView>{
    private String url= Constant.LINK_MAIN;
    public void getClassData(){
        HttpUtils.getClassHttpData(url, new Observer<LeftListBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LeftListBean value) {
                getmT().callbackData(value);
            }

            @Override
            public void onError(Throwable e) {
                getmT().callbackErrer(new Throwable(e).toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
