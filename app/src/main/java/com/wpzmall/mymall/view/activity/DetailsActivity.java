package com.wpzmall.mymall.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.details.DetailsBean;
import com.wpzmall.mymall.presenter.DetailsPresenter;
import com.wpzmall.mymall.view.adapter.DetailsListAdapter;
import com.wpzmall.mymall.view.iview.IDetailsView;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  10:52
 * <p>
 * 思路：
 */


public class DetailsActivity extends Activity implements View.OnClickListener,IDetailsView<DetailsBean> {
    private ImageView detailsImage1;
    private TextView detailsName;
    private TextView detailsText1;
    private TextView detailsPrice;
    private TextView detailsNum;
    private TextView detailsAreaName;
    private TextView detailsYunfei;
    private TextView detailsGoodPercent;
    private TextView detailsEvaluation;
    private LinearLayout detailsJieshao;
    private TextView detailsDesccredit;
    private TextView detailsServicecredit;
    private TextView detailsDeliverycredit;
    private ListView detailsListview;
    private DetailsPresenter detailsPresenter;
    private String goods_id;
    private DetailsListAdapter detailsListAdapter;
    private List<DetailsBean.DatasBean.GoodsCommendListBean> detailslist = new ArrayList<>();
    private ScrollView detailsScroll;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        goods_id = this.getIntent().getStringExtra("goods_id");
        Toast.makeText(this, this.goods_id + "654564654", Toast.LENGTH_SHORT).show();
        detailsPresenter = new DetailsPresenter();
        detailsPresenter.setmT(this);
        detailsPresenter.getDetailsData(this.goods_id);
        initView();
    }

    @Override
    public void onClick(View v) {

    }

    private void initView() {
        detailsImage1 = (ImageView) findViewById(R.id.details_image1);
        detailsName = (TextView) findViewById(R.id.details_name);
        detailsText1 = (TextView) findViewById(R.id.details_text_1);
        detailsPrice = (TextView) findViewById(R.id.details_price);
        detailsNum = (TextView) findViewById(R.id.details_num);
        detailsAreaName = (TextView) findViewById(R.id.details_area_name);
        detailsYunfei = (TextView) findViewById(R.id.details_yunfei);
        detailsGoodPercent = (TextView) findViewById(R.id.details_good_percent);
        detailsEvaluation = (TextView) findViewById(R.id.details_evaluation);
        detailsJieshao = (LinearLayout) findViewById(R.id.details_jieshao);
        detailsDesccredit = (TextView) findViewById(R.id.details_desccredit);
        detailsServicecredit = (TextView) findViewById(R.id.details_servicecredit);
        detailsDeliverycredit = (TextView) findViewById(R.id.details_deliverycredit);

        detailsListview = (ListView) findViewById(R.id.details_listview);
        detailsListAdapter = new DetailsListAdapter(this);
        detailsListview.setAdapter(detailsListAdapter);


        detailsScroll = (ScrollView) findViewById(R.id.details_scroll);
        //解决ScrollView嵌套listview后显示不是在顶部
        detailsScroll.smoothScrollTo(0,20);

    }
    @Override
    public void callbackData(DetailsBean detailsBean) {
        Log.e("asdasdas",detailsBean.getDatas().getGoods_info().getGoods_name());
        setImageBackGroud(detailsBean.getDatas().getGoods_image(),detailsImage1);
        detailsName.setText(detailsBean.getDatas().getGoods_info().getGoods_name());
        detailsText1.setText(detailsBean.getDatas().getGoods_info().getGoods_jingle());
        detailsPrice.setText("￥"+detailsBean.getDatas().getGoods_info().getGoods_price());
        detailsNum.setText("销量"+detailsBean.getDatas().getGoods_info().getGoods_salenum());
        detailsAreaName.setText(detailsBean.getDatas().getGoods_hair_info().getArea_name());
        detailsYunfei.setText(detailsBean.getDatas().getGoods_hair_info().getIf_store_cn()+" "+detailsBean.getDatas().getGoods_hair_info().getContent());
        detailsGoodPercent.setText("好评率"+detailsBean.getDatas().getGoods_evaluate_info().getGood_percent()+"%");
        detailsEvaluation.setText(detailsBean.getDatas().getGoods_evaluate_info().getNormal()+"人评价");
        detailsDesccredit.setText(detailsBean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getText()+":"+detailsBean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getCredit());
        detailsServicecredit.setText(detailsBean.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getText()+":"+detailsBean.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getCredit());
        detailsDeliverycredit.setText(detailsBean.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getText()+":"+detailsBean.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getCredit());
        detailslist = detailsBean.getDatas().getGoods_commend_list();
        detailsListAdapter.getData(detailslist);
        setListViewHeightBasedOnChildren(detailsListview);
        detailsListAdapter.notifyDataSetChanged();
    }
    //设置scrollview嵌套list view只显示一个条目的问题
    public void setListViewHeightBasedOnChildren(ListView detailsListview) {
        // 获取ListView对应的Adapter
        DetailsListAdapter detailsListAdapter = (DetailsListAdapter) detailsListview.getAdapter();
        if (detailsListAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = detailsListAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = detailsListAdapter.getView(i, null, detailsListview);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = detailsListview.getLayoutParams();
        params.height = totalHeight+ (detailsListview.getDividerHeight() * (detailsListAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        detailsListview.setLayoutParams(params);
    }


    @Override
    public void callbackErrer(String errcode) {

    }


    //设置显示网络图片
    private void setImageBackGroud(String url,ImageView imageView) {
//        RequestOptions options = new RequestOptions()
//                .placeholder(R.mipmap.ic_launcher)    //设置占位符
//                .error(R.mipmap.ic_launcher);   //设置错误时显示的图片
//        Glide.with(this)
//                .load(url)
//                .apply(options)
//                .transition(new DrawableTransitionOptions().crossFade(2000))  //使用动画效果
//                .into(imageView);

        Glide.with(this)
                .load(url)
                .placeholder(R.mipmap.ic_action_add)
                .into(imageView);
    }
}
