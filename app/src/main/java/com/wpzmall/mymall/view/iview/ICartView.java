package com.wpzmall.mymall.view.iview;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  21:02
 * <p>
 * 思路：
 */


public interface ICartView<T> extends IMvpView{
    void callbackCartData(T t);
    void callbackCartErrer(String errcode);
}
