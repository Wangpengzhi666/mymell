package com.wpzmall.mymall.view.iview;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/17  08:52
 * <p>
 * 思路：
 */


public interface IClassView<T> extends IMvpView{
    void callbackData(T t);
    void callbackErrer(String errcode);
}
