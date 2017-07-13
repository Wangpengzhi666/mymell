package com.wpzmall.mymall.view.iview;

import com.wpzmall.mymall.model.Bean.commit.CommitBean;
import com.wpzmall.mymall.view.activity.Constant;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/12  20:13
 * <p>
 * 思路：
 */


public interface ICommitBiz {

    //    购物车删除数据
    @FormUrlEncoded
    @POST(Constant.ACTIVITY_COMMIT_ORDER)
    Observable<CommitBean> postCommit(@Field("key") String Key,
                                      @Field("cart_id") String cart_id,
                                      @Field("Ifcart") String Ifcart);

}
