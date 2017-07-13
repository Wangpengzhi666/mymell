package com.wpzmall.mymall.view.iview;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/12  20:13
 * <p>
 * 思路：
 */


public interface ICommitView<T> extends IMvpView{
    void callbackCommitData(T t);
    void callbackCommitErrer(String errcode);
}
