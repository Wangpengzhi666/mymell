package com.wpzmall.mymall.view.Event;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/10  09:56
 * <p>
 * 思路：
 */


public class MessageEvent {
    private String message;  //删除数据需要的值
    private String cart;     //给购物车添加完数据需要的值

    public String getGoCart() {
        return goCart;
    }

    public void setGoCart(String goCart) {
        this.goCart = goCart;
    }

    private String goCart;

    public MessageEvent() {
    }

    //删除的数据
    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

}
