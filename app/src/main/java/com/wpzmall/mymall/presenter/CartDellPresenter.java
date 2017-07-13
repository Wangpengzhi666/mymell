package com.wpzmall.mymall.presenter;

import com.wpzmall.mymall.model.Bean.cart.CartAddBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.ICartAddView;
import com.wpzmall.mymall.view.iview.ICartDeleteView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/9  21:04
 * <p>
 * 思路：
 */


public class CartDellPresenter extends BasePresenter<ICartDeleteView> {
    private String url= Constant.LINK_MAIN;
    public void getcertdellData(String key,String cart_id){
        HttpUtils.getCartDellHttpData(url, new Observer<CartAddBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CartAddBean value) {
                getmT().callbackCartDelData(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, key,cart_id);
    }
}
