package com.wpzmall.mymall.presenter;

import com.wpzmall.mymall.model.Bean.Class.ExpandableBean;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.IClassExpandView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/5  19:31
 * <p>
 * 思路：
 */


public class ClassExpandPresenter extends BasePresenter<IClassExpandView> {
    private String url= Constant.LINK_MAIN;
    public void getClassExpanderData2(String gc_id){
        HttpUtils.getClassExpandHttpData(url, new Observer<ExpandableBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ExpandableBean value) {
                getmT().CollBackViewData2(value);

            }

            @Override
            public void onError(Throwable e) {
//                getmT().callbackErrer(new Throwable(e).toString());
            }

            @Override
            public void onComplete() {

            }
        },gc_id);
    }

    public void getClassExpandData3(String gc_id){
        HttpUtils.getClassExpandHttpData(url, new Observer<ExpandableBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ExpandableBean value) {
                getmT().CollBackViewData3(value);
            }

            @Override
            public void onError(Throwable e) {
//                getmT().callbackErrer(new Throwable(e).toString());
            }

            @Override
            public void onComplete() {

            }
        },gc_id);
    }
}
