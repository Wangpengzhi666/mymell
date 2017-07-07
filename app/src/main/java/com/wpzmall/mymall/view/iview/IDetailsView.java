package com.wpzmall.mymall.view.iview;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  11:20
 * <p>
 * 思路：
 */


public interface IDetailsView<T> extends IMvpView{
    void callbackData(T t);
    void callbackErrer(String errcode);
}
