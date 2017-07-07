package com.wpzmall.mymall.view.frgament;

import android.content.Context;
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
import com.wpzmall.mymall.model.Bean.cart.CartBean;
import com.wpzmall.mymall.presenter.CartPresenter;
import com.wpzmall.mymall.view.adapter.CartListAdapter;
import com.wpzmall.mymall.view.iview.ICartView;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/9  16:36
 * <p>
 * 思路：
 */


public class CartFragment extends Fragment implements View.OnClickListener, ICartView<CartBean> {
    private TextView cartTotalAmount;
    private Button cartSettlement;
    private int piece = 0;
    private int money = 0;
    private List<CartBean.DatasBean.CartListBean.GoodsBean> List = new ArrayList<>();
    private SharedPreferences spf;
    private CartPresenter cartPresenter;
    private ListView cartList;
    private CartListAdapter cartListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_cart, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        spf = getActivity().getSharedPreferences("mymall", Context.MODE_PRIVATE);
        String login_key = spf.getString("login_key", "a");
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
        String str = "共<font color='#FF5001'>" + piece + "</font>件商品,共<font color='#FF5001'>" + money + "</font>元";
        cartTotalAmount.setTextSize(18);
        cartTotalAmount.setText(Html.fromHtml(str));
        cartSettlement = (Button) getActivity().findViewById(R.id.cart_settlement);
        cartSettlement.setOnClickListener(this);
        cartList = (ListView) getActivity().findViewById(R.id.cart_list);
        cartListAdapter = new CartListAdapter(getActivity());
        cartList.setAdapter(cartListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_settlement:

                break;
        }
    }

    @Override
    public void callbackCartData(CartBean cartBean) {
        List = cartBean.getDatas().getCart_list().get(0).getGoods();
        Log.e("asdasdas", cartBean.getDatas().getCart_list().get(0).getGoods().get(0).getGoods_name() + "");
    }

    @Override
    public void callbackCartErrer(String errcode) {


    }
}
