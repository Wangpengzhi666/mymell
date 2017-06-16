package com.wpzmall.mymall.view.frgament;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.view.activity.LoginActivity;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/9  16:37
 * <p>
 * 思路：
 */


public class UserFragment extends Fragment implements View.OnClickListener{
    private TextView User_Login_Text;
    private TextView User_black_commodity;
    private TextView User_black_shop;
    private TextView User_black_foot;
    private TextView User_oeder_Unpaid;
    private TextView User_oeder_to_be_delivered;
    private TextView User_oeder_to_be_received;
    private TextView User_oeder_be_evaluated;
    private TextView User_oeder_Refunds;
    private TextView User_property_Pre_stored;
    private TextView User_property_Recharge;
    private TextView User_property_Vouchers;
    private TextView User_property_red;
    private TextView User_property_Pre_integral;
    private TextView User_address;
    private TextView User_setting;
    private ScrollView UserScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_user, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initOnClick();
    }

    private void initOnClick() {
        User_Login_Text.setOnClickListener(this);
        User_black_commodity.setOnClickListener(this);
        User_black_shop.setOnClickListener(this);
        User_black_foot.setOnClickListener(this);
        User_oeder_Unpaid.setOnClickListener(this);
        User_oeder_to_be_delivered.setOnClickListener(this);
        User_oeder_to_be_received.setOnClickListener(this);
        User_oeder_be_evaluated.setOnClickListener(this);
        User_oeder_Refunds.setOnClickListener(this);
        User_property_Pre_stored.setOnClickListener(this);
        User_property_Recharge.setOnClickListener(this);
        User_property_Vouchers.setOnClickListener(this);
        User_property_red.setOnClickListener(this);
        User_property_Pre_integral.setOnClickListener(this);
        User_address.setOnClickListener(this);
        User_setting.setOnClickListener(this);
    }

    private void initViews() {

        User_Login_Text = (TextView) getView().findViewById(R.id.User_Login_Text);
        User_black_commodity = (TextView) getView().findViewById(R.id.User_black_commodity);
        User_black_shop = (TextView) getView().findViewById(R.id.User_black_shop);
        User_black_foot = (TextView) getView().findViewById(R.id.User_black_foot);
        User_oeder_Unpaid = (TextView) getView().findViewById(R.id.User_oeder_Unpaid);
        User_oeder_to_be_delivered = (TextView) getView().findViewById(R.id.User_oeder_to_be_delivered);
        User_oeder_to_be_received = (TextView) getView().findViewById(R.id.User_oeder_to_be_received);
        User_oeder_be_evaluated = (TextView) getView().findViewById(R.id.User_oeder_be_evaluated);
        User_oeder_Refunds = (TextView) getView().findViewById(R.id.User_oeder_Refunds);
        User_property_Pre_stored = (TextView) getView().findViewById(R.id.User_property_Pre_stored);
        User_property_Recharge = (TextView) getView().findViewById(R.id.User_property_Recharge);
        User_property_Vouchers = (TextView) getView().findViewById(R.id.User_property_Vouchers);
        User_property_red = (TextView) getView().findViewById(R.id.User_property_red);
        User_property_Pre_integral = (TextView) getView().findViewById(R.id.User_property_Pre_integral);
        User_address = (TextView) getView().findViewById(R.id.User_address);
        User_setting = (TextView) getView().findViewById(R.id.User_setting);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.User_Login_Text:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in, R.anim.out);
                break;
        }

    }
}
