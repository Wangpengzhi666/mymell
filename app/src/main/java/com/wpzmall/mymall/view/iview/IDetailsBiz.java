package com.wpzmall.mymall.view.iview;

import android.database.Observable;

import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.model.Bean.details.DetailsBean;
import com.wpzmall.mymall.view.activity.Constant;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  11:22
 * <p>
 * 思路：
 */


public interface IDetailsBiz {
    @GET(Constant.ACTIVITY_DETAILS_URL)
    io.reactivex.Observable<DetailsBean> getData(@Query("goods_id") String goods_id);
}
