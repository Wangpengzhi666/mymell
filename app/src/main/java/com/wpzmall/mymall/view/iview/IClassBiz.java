package com.wpzmall.mymall.view.iview;



import com.wpzmall.mymall.model.Bean.Class.LeftListBean;

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
    @GET("mobile/index.php")
    Observable<LeftListBean> getData(@Query("act") String goods_class);


    //分类页面二级列表请求方法
//    @GET(Constant.FCLASSISY_LISTVIEW_URL)
//    Observable<FClassifyViewBean2> getData2(@Query("gc_id") String gc_id);
}
