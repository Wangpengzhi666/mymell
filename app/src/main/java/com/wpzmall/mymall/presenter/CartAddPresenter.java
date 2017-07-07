package com.wpzmall.mymall.presenter;

import com.wpzmall.mymall.model.Bean.cart.CartAddBean;
import com.wpzmall.mymall.model.utils.HttpUtils;
import com.wpzmall.mymall.view.activity.Constant;
import com.wpzmall.mymall.view.iview.ICartAddView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  20:40
 * <p>
 * 思路：
 */


public class CartAddPresenter extends BasePresenter<ICartAddView> {
    private String url= Constant.LINK_MAIN;
    public void getListData(String key,String goods_id,String quantity){
        HttpUtils.getCartAddHttpData(url, new Observer<CartAddBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CartAddBean value) {
                getmT().callbackCartAddData(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, key, goods_id, quantity);
    }

}
