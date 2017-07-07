package com.wpzmall.mymall.presenter;

import com.wpzmall.mymall.model.Bean.list.ListBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.IListView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/6  19:28
 * <p>
 * 思路：
 */

public class ListPresenter extends BasePresenter<IListView> {
    private String url= Constant.LINK_MAIN;
    private String listPage = "100";
    public void getListData(String gc_id){
        HttpUtils.getListHttpData(url, new Observer<ListBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ListBean value) {
                getmT().callbackData(value);
            }


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, listPage, gc_id);
    }
}
