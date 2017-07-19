package com.wpzmall.mymall.presenter;

import com.wpzmall.mymall.model.Bean.commit.CommitBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.ICommitView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/13  11:30
 * <p>
 * 思路：
 */


public class CommitPresenter extends BasePresenter<ICommitView>{
    private String url= Constant.LINK_MAIN;
    public void getCommitData(String key,String cart_id,String ifcart){
        HttpUtils.getCommitHttpData(url, new Observer<CommitBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CommitBean value) {
                getmT().callbackCommitData(value);
            }


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },key,cart_id,ifcart);

    }
}
