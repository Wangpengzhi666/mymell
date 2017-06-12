package com.wpzmall.mymall.view.iview;



import com.wpzmall.mymall.model.Bean.Registered.RegisteredBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/12  21:21
 * <p>
 * 思路：
 */


public interface IRegBiz {
    @FormUrlEncoded
    @POST("index.php")
    Observable<RegisteredBean> postfix(@Field("act") String login,
                                       @Field("op") String op,
                                       @Field("username") String username,
                                       @Field("password") String password,
                                       @Field("password_confirm") String password_confirm,
                                       @Field("email") String email,
                                       @Field("client") String client );


}
