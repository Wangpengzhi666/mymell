package com.wpzmall.mymall.view.frgament;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.cart.CartAddBean;
import com.wpzmall.mymall.model.Bean.cart.CartBean;
import com.wpzmall.mymall.presenter.CartAddPresenter;
import com.wpzmall.mymall.presenter.CartDellPresenter;
import com.wpzmall.mymall.presenter.CartPresenter;
import com.wpzmall.mymall.view.Event.MessageEvent;
import com.wpzmall.mymall.view.activity.CommitOrderActivity;
import com.wpzmall.mymall.view.adapter.CartListAdapter;
import com.wpzmall.mymall.view.iview.ICartDeleteView;
import com.wpzmall.mymall.view.iview.ICartView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/9  16:36
 * <p>
 * 思路：
 */


public class CartFragment extends Fragment implements View.OnClickListener, ICartView<CartBean>,ICartDeleteView<CartAddBean> {
    private TextView cartTotalAmount;
    private Button cartSettlement;
    private int piece = 0;
    private int money = 0;
    private List<CartBean.DatasBean.CartListBean.GoodsBean> list = new ArrayList<>();
    private SharedPreferences spf;
    private CartPresenter cartPresenter;
    private ListView cartList;
    private CartListAdapter cartListAdapter;
    private int code;
    private CartDellPresenter cartDellPresenter;
    private String login_key;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_cart, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        EventBus.getDefault().register(this);

        //删除的Presenter层
        cartDellPresenter = new CartDellPresenter();
        cartDellPresenter.setmT(this);
        //判断登录的sharedPreFerences
        spf = getActivity().getSharedPreferences("mymall", Context.MODE_PRIVATE);
        login_key = spf.getString("login_key", "a");

        if (!login_key.equals("a")) {
            cartPresenter = new CartPresenter();
            cartPresenter.setmT(this);
            cartPresenter.getCartData(login_key);
        } else {
            Toast.makeText(getActivity(), "请先去登录", Toast.LENGTH_SHORT).show();
        }
        initView();
    }

    private void initView() {
        cartTotalAmount = (TextView) getActivity().findViewById(R.id.cart_total_amount);

        cartSettlement = (Button) getActivity().findViewById(R.id.cart_settlement);
        cartSettlement.setOnClickListener(this);
        cartList = (ListView) getActivity().findViewById(R.id.cart_list);
        cartListAdapter = new CartListAdapter(getActivity());
        cartList.setAdapter(cartListAdapter);
        cartListAdapter.setText(cartTotalAmount);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_settlement:
                Toast.makeText(getActivity(), "下单了昂", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < list.size(); i++) {
                    Log.e("shuju",list.get(i).getCart_check() + "");
                    if (list.get(i).getCart_check()){
                        String cart_id = list.get(i).getCart_id();
                        String goods_num = list.get(i).getGoods_num();
                        StringBuffer s1 = new StringBuffer(cart_id);
                        s1.append("|" + goods_num);
                        s1.append("," + s1);
                        Toast.makeText(getActivity(), s1, Toast.LENGTH_SHORT).show();
                    }else {

                    }
                }
                Intent intent = new Intent(getActivity(), CommitOrderActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void callbackCartData(CartBean cartBean) {
        list = cartBean.getDatas().getCart_list().get(0).getGoods();
        cartListAdapter.setData(list);
        cartListAdapter.notifyDataSetChanged();
    }

    @Override
    public void callbackCartErrer(String errcode) {


    }

    @Override
    public void callbackCartDelData(CartAddBean cartAddBean) {
        code = cartAddBean.getCode();
    }

    @Override
    public void callbackCartDelErrer(String errcode) {

    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvent(MessageEvent messageEvent) {
        Log.e("wpz6666666666666",  messageEvent.getMessage() + "                666");
        cartDellPresenter.getcertdellData(login_key,messageEvent.getMessage());
        cartPresenter.getCartData(login_key);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvents(MessageEvent messageEvent) {
        Log.e("wpz6666666666666",  messageEvent.getCart() + "                666");
        if (messageEvent.getCart().equals("1")){
            cartPresenter.getCartData(login_key);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
