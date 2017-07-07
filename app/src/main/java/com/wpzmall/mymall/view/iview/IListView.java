package com.wpzmall.mymall.view.iview;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/6  19:09
 * <p>
 * 思路：
 */


public interface IListView<T> extends IMvpView{
    void callbackData(T t);
    void callbackErrer(String errcode);
}
