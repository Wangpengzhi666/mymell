package com.wpzmall.mymall.presenter;

import com.wpzmall.mymall.model.Bean.cart.CartBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.ICartView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  21:05
 * <p>
 * 思路：
 */


public class CartPresenter extends BasePresenter<ICartView>  {
    private String url= Constant.LINK_MAIN;
    public void getCartData(String key){
        HttpUtils.getCartHttpData(url, new Observer<CartBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CartBean value) {
                getmT().callbackCartData(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, key);
    }

}
