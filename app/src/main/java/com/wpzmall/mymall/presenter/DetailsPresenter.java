package com.wpzmall.mymall.presenter;

import com.wpzmall.mymall.model.Bean.details.DetailsBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.IDetailsView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.R.attr.value;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  11:31
 * <p>
 * 思路：
 */


public class DetailsPresenter extends BasePresenter<IDetailsView> {
    private String url= Constant.LINK_MAIN;
    public void getDetailsData(String goods_id){
        HttpUtils.getDetailsHttpData(url, new Observer<DetailsBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DetailsBean value) {
                getmT().callbackData(value);
            }


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, goods_id);

    }
}
