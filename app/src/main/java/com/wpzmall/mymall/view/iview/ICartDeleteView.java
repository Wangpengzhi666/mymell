package com.wpzmall.mymall.view.iview;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  23:49
 * <p>
 * 思路：
 */


public interface ICartDeleteView<T> extends IMvpView{
    void callbackCartDelData(T t);
    void callbackCartDelErrer(String errcode);
}
