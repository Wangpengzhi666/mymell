package com.wpzmall.mymall.view.iview;

import com.wpzmall.mymall.model.Bean.login.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ILoginBiz {
    @FormUrlEncoded
    @POST("mobile/index.php")
    Observable<LoginBean> postfix(@Field("act") String login,
                                @Field("username") String username,
                                @Field("password") String password,
                                @Field("client") String client );


}
