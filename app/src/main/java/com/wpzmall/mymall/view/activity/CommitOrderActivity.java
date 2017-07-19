package com.wpzmall.mymall.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.commit.CommitBean;
import com.wpzmall.mymall.presenter.CommitPresenter;
import com.wpzmall.mymall.view.iview.ICommitView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/11  21:36
 * <p>
 * 思路：
 */


public class CommitOrderActivity extends Activity implements View.OnClickListener,ICommitView<CommitBean> {
    private ImageView mCommitBack;
    private TextView mCommitAddress;
    private TextView mAddress;
    private RadioButton mPayment;
    private RadioButton mDelivery;
    private RadioGroup mCommitRadiogroup1;
    private RadioButton mNoInvoice;
    private RadioButton mNeedInvoice;
    private RadioGroup mCommitRadiogroup2;
    private ListView mCommitListview;
    private ScrollView mCommitScrollview;
    private TextView mCommitSubmit;
    private CommitPresenter commitPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_order);
        commitPresenter = new CommitPresenter();
        commitPresenter.setmT(this);
        initView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.commit_back:

                break;
        }
    }

    private void initView() {
        mCommitBack = (ImageView) findViewById(R.id.commit_back);
        mCommitBack.setOnClickListener(this);
        mCommitAddress = (TextView) findViewById(R.id.commit_address);
        mAddress = (TextView) findViewById(R.id.address);
        mPayment = (RadioButton) findViewById(R.id.payment);
        mDelivery = (RadioButton) findViewById(R.id.delivery);
        mCommitRadiogroup1 = (RadioGroup) findViewById(R.id.commit_radiogroup1);
        mNoInvoice = (RadioButton) findViewById(R.id.no_invoice);
        mNeedInvoice = (RadioButton) findViewById(R.id.need_invoice);
        mCommitRadiogroup2 = (RadioGroup) findViewById(R.id.commit_radiogroup2);
        mCommitListview = (ListView) findViewById(R.id.commit_listview);
        mCommitScrollview = (ScrollView) findViewById(R.id.commit_scrollview);
        mCommitSubmit = (TextView) findViewById(R.id.commit_submit);
    }

    @Override
    public void callbackCommitData(CommitBean commitBean) {

    }

    @Override
    public void callbackCommitErrer(String errcode) {

    }
}
