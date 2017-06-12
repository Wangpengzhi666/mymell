package com.wpzmall.mymall.presenter;

import android.widget.ImageView;

import com.wpzmall.mymall.view.iview.IMvpView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/11  15:41
 * <p>
 * 思路：
 */


public class BasePresenter<T extends IMvpView>{
    private T mT;

    public T getmT() {
        return mT;
    }

    public void setmT(T t) {
        this.mT = t;
    }
}
