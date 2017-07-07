package com.wpzmall.mymall.view.iview;



import com.wpzmall.mymall.model.Bean.Class.ExpandableBean;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.view.activity.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/17  08:53
 * <p>
 * 思路：
 */


public interface IClassBiz {
    //分类页面一级列表请求方法
    @GET(Constant.FCLASSISY_LISTVIEW_URL)
    Observable<LeftListBean> getData();

    //分类页面二、三级列表请求方法
    @GET(Constant.FCLASSISY_LISTVIEW_URL)
    Observable<ExpandableBean> getData2(@Query("gc_id") String gc_id);


}
