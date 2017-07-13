package com.wpzmall.mymall.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.cart.CartAddBean;
import com.wpzmall.mymall.model.Bean.details.DetailsBean;
import com.wpzmall.mymall.presenter.CartAddPresenter;
import com.wpzmall.mymall.presenter.DetailsPresenter;
import com.wpzmall.mymall.view.Event.MessageEvent;
import com.wpzmall.mymall.view.adapter.DetailsListAdapter;
import com.wpzmall.mymall.view.iview.ICartAddView;
import com.wpzmall.mymall.view.iview.IDetailsView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  10:52
 * <p>
 * 思路：
 */


public class DetailsActivity extends Activity implements View.OnClickListener, IDetailsView<DetailsBean>, ICartAddView<CartAddBean> {

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
    private View parent;
    private View view;
    private PopupWindow pop;
    private RadioButton customer_serverce;
    private RadioButton cart;
    private RadioButton make_in_cart;
    private RadioButton details_now;
    private RadioGroup details_radiogroup;
    private ImageView intoCartImage;
    private TextView intoCartName;
    private TextView intoCartPrice;
    private TextView intoCartNum;
    private TextView intoCartSubtract;
    private TextView intoCartBuyNum;
    private TextView intoCartAdd;
    private TextView intoCartOk;
    private TextView intoCartBuynow;
    private DetailsBean.DatasBean datas;
    private SharedPreferences spf;
    private CartAddPresenter cartPresenter;
    private int cartQuantity = 1;
    private ImageView back;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        goods_id = this.getIntent().getStringExtra("goods_id");
//        Toast.makeText(this, this.goods_id + "654564654", Toast.LENGTH_SHORT).show();
        detailsPresenter = new DetailsPresenter();
        detailsPresenter.setmT(this);
        detailsPresenter.getDetailsData(this.goods_id);
        cartPresenter = new CartAddPresenter();
        cartPresenter.setmT(this);


        spf = getSharedPreferences("mymall", Context.MODE_PRIVATE);

        initView();
        initPop();
    }

    private void initPop() {

        view = View.inflate(DetailsActivity.this, R.layout.inculde_details_pop, null);
        parent = View.inflate(DetailsActivity.this, R.layout.activity_details, null);


        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 550);
        pop.setOutsideTouchable(true); //设置周围区域可以触摸
        pop.setBackgroundDrawable(new BitmapDrawable());//设置背景
        pop.setFocusable(true); //窗体默认没有焦点 设置成true  让他可以被点击

        //pop的控件
        intoCartImage = (ImageView) view.findViewById(R.id.intoCart_image);  //展示图片
        intoCartName = (TextView) view.findViewById(R.id.intoCart_name);  //展示商品名
        intoCartPrice = (TextView) view.findViewById(R.id.intoCart_price);  //展示商品价格
        intoCartNum = (TextView) view.findViewById(R.id.intoCart_num);  //
        intoCartSubtract = (TextView) view.findViewById(R.id.intoCart_subtract);  //减少数量
        intoCartSubtract.setOnClickListener(this);
        intoCartBuyNum = (TextView) view.findViewById(R.id.intoCart_buyNum);  //商品数量
        intoCartAdd = (TextView) view.findViewById(R.id.intoCart_add);  //增加数量
        intoCartAdd.setOnClickListener(this);
        intoCartOk = (TextView) view.findViewById(R.id.intoCart_ok);  //加入购物车
        intoCartOk.setOnClickListener(this);
        intoCartBuynow = (TextView) view.findViewById(R.id.intoCart_buynow);  //立即购买

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customer_serverce:
                break;
            //加入购物车
            case R.id.make_in_cart:
                pop.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
                Glide.with(this)
                        .load(datas.getGoods_image())
                        .placeholder(R.mipmap.ic_action_add)
                        .into(intoCartImage);
                intoCartName.setText(datas.getGoods_info().getGoods_name());
                intoCartPrice.setText(datas.getGoods_info().getGoods_promotion_price());
                break;
            case R.id.details_now:
                break;
            //跳转到购物车界面
            case R.id.cart:
                //EventBus传值
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putExtra("Details",3);
                startActivity(intent);
//                MessageEvent messageEvent = new MessageEvent();
//                messageEvent.setGoCart("3");
//                EventBus.getDefault().post(messageEvent);
                break;
            case R.id.details_radiogroup:
                break;
            //加入购物车pop中的确定按钮
            case R.id.intoCart_ok:
                String login_key = spf.getString("login_key", "a");
                if (!login_key.equals("a")) {
                    cartPresenter.getListData(login_key, goods_id, intoCartBuyNum.getText().toString());
                    pop.dismiss();
                } else {
                    Toast.makeText(this, "请先去登录", Toast.LENGTH_SHORT).show();
                }
                break;
            //减小数量按钮
            case R.id.intoCart_subtract:
                if (cartQuantity == 1) {
                    Toast.makeText(this,"已经是最小数量了，不诚心买就别点了", Toast.LENGTH_SHORT).show();
                } else {
                    cartQuantity--;
                    String s = Integer.toString(cartQuantity);
                    intoCartBuyNum.setText(s);
                }
                break;
            //增加数量按钮
            case R.id.intoCart_add:
                cartQuantity++;
                String s = Integer.toString(cartQuantity);
                intoCartBuyNum.setText(s);
                break;
            //返回按钮
            case R.id.back:

                break;
        }
    }

    private void initView() {
        detailsImage1 = (ImageView) findViewById(R.id.details_image1);  //详情页商品图片
        detailsName = (TextView) findViewById(R.id.details_name);  //详情页商品名
        detailsText1 = (TextView) findViewById(R.id.details_text_1);
        detailsPrice = (TextView) findViewById(R.id.details_price);  //详情页商品单价
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
        detailsScroll.smoothScrollTo(0, 20);


        customer_serverce = (RadioButton) findViewById(R.id.customer_serverce);
        customer_serverce.setOnClickListener(this);
        cart = (RadioButton) findViewById(R.id.cart);
        cart.setOnClickListener(this);
        make_in_cart = (RadioButton) findViewById(R.id.make_in_cart);
        make_in_cart.setOnClickListener(this);
        details_now = (RadioButton) findViewById(R.id.details_now);
        details_now.setOnClickListener(this);
        details_radiogroup = (RadioGroup) findViewById(R.id.details_radiogroup);
        details_radiogroup.setOnClickListener(this);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);

    }

    @Override
    public void callbackData(DetailsBean detailsBean) {
        Log.e("asdasdas", detailsBean.getDatas().getGoods_info().getGoods_name());
        setImageBackGroud(detailsBean.getDatas().getGoods_image(), detailsImage1);
        detailsName.setText(detailsBean.getDatas().getGoods_info().getGoods_name());
        detailsText1.setText(detailsBean.getDatas().getGoods_info().getGoods_jingle());
        detailsPrice.setText("￥" + detailsBean.getDatas().getGoods_info().getGoods_price());
        detailsNum.setText("销量" + detailsBean.getDatas().getGoods_info().getGoods_salenum());
        detailsAreaName.setText(detailsBean.getDatas().getGoods_hair_info().getArea_name());
        detailsYunfei.setText(detailsBean.getDatas().getGoods_hair_info().getIf_store_cn() + " " + detailsBean.getDatas().getGoods_hair_info().getContent());
        detailsGoodPercent.setText("好评率" + detailsBean.getDatas().getGoods_evaluate_info().getGood_percent() + "%");
        detailsEvaluation.setText(detailsBean.getDatas().getGoods_evaluate_info().getNormal() + "人评价");
        detailsDesccredit.setText(detailsBean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getText() + ":" + detailsBean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getCredit());
        detailsServicecredit.setText(detailsBean.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getText() + ":" + detailsBean.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getCredit());
        detailsDeliverycredit.setText(detailsBean.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getText() + ":" + detailsBean.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getCredit());


        detailslist = detailsBean.getDatas().getGoods_commend_list();
        detailsListAdapter.getData(detailslist);
        setListViewHeightBasedOnChildren(detailsListview);
        detailsListAdapter.notifyDataSetChanged();

        datas = detailsBean.getDatas();
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
        params.height = totalHeight + (detailsListview.getDividerHeight() * (detailsListAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        detailsListview.setLayoutParams(params);
    }


    @Override
    public void callbackErrer(String errcode) {

    }


    //设置显示网络图片
    private void setImageBackGroud(String url, ImageView imageView) {
        Glide.with(this)
                .load(url)
                .placeholder(R.mipmap.ic_action_add)
                .into(imageView);
    }

    @Override
    public void callbackCartAddData(CartAddBean cartAddBean) {
        int code = cartAddBean.getCode();
        if (code == 200) {
            Toast.makeText(this, "风里雨里,购物车等你", Toast.LENGTH_SHORT).show();
            //EventBus传值
            MessageEvent messageEvent = new MessageEvent();
            messageEvent.setCart("1");
            EventBus.getDefault().post(messageEvent);

        } else {
            Toast.makeText(this, "小问题", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void callbackCartAddErrer(String errcode) {

    }
}
