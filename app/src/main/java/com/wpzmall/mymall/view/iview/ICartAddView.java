package com.wpzmall.mymall.view.iview;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  20:22
 * <p>
 * 思路：
 */


public interface ICartAddView<T> extends IMvpView{
    void callbackCartAddData(T t);
    void callbackCartAddErrer(String errcode);
}
