package com.wpzmall.mymall.view.iview;

public interface ILoginView<T> extends IMvpView {
    void callbackData(T t);
    void callbackErrer(String errcode);

}
