package com.wpzmall.mymall.view.iview;

import com.wpzmall.mymall.model.Bean.cart.CartAddBean;
import com.wpzmall.mymall.model.Bean.cart.CartBean;
import com.wpzmall.mymall.view.activity.Constant;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  20:23
 * <p>
 * 思路：
 */


public interface ICartBiz {
    //加入购物车
    @FormUrlEncoded
    @POST(Constant.ACTIVITY_CART_Add_URL)
    Observable<CartAddBean> postCartAdd(@Field("key") String username,
                                         @Field("goods_id") String goods_id,
                                         @Field("quantity") String quantity);
    //购物车查询数据
    @FormUrlEncoded
    @POST(Constant.ACTIVITY_CART_URL)
    Observable<CartBean> postCart(@Field("key") String username);

//    购物车删除数据
    @FormUrlEncoded
    @POST(Constant.ACTIVITY_CART_DEL_URL)
    Observable<CartAddBean> postCartDell(@Field("key") String username,
                                         @Field("cart_id") String cart_id);

}
