package com.wpzmall.mymall.view.iview;

import com.wpzmall.mymall.model.Bean.list.ListBean;
import com.wpzmall.mymall.view.activity.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/6  19:11
 * <p>
 * 思路：
 */


public interface IListBiz {

    //列表页
    @GET(Constant.ACTIVITY_LIST_URL)
    Observable<ListBean> getData(@Query("page") String page,
                                 @Query("gc_id") String gc_id);
}
