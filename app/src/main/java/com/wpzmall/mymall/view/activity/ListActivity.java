package com.wpzmall.mymall.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.list.ListBean;
import com.wpzmall.mymall.presenter.ListPresenter;
import com.wpzmall.mymall.view.adapter.ListRecyclerAdapter;
import com.wpzmall.mymall.view.iview.IListBiz;
import com.wpzmall.mymall.view.iview.IListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  08:25
 * <p>
 * 思路：
 */


public class ListActivity extends Activity implements IListView<ListBean> {

    private String id;
    private RecyclerView listRecycler;
    private ListPresenter listPresenter;
    private List<ListBean.DatasBean.GoodsListBean> recyclerlist = new ArrayList<>();
    private ListRecyclerAdapter listRecyclerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState
    ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle bundle = this.getIntent().getExtras();
        id = bundle.getString("id");
//        Toast.makeText(this, id + "", Toast.LENGTH_SHORT).show();
        listPresenter = new ListPresenter();
        listPresenter.setmT(this);
        listPresenter.getListData(id);
        initView();
        setRecyclerClick();
    }


    private void initView() {
        //找到recycler
        listRecycler = (RecyclerView) findViewById(R.id.list_recycler);
        listRecyclerAdapter = new ListRecyclerAdapter(this);
        listRecycler.setAdapter(listRecyclerAdapter);

    }


    private void setRecyclerClick() {
        listRecyclerAdapter.setOnItemClinckListener(new ListRecyclerAdapter.OnClickListenerr() {
            @Override
            public void onItemClickListener(View view, int position) {

                String goods_id = recyclerlist.get(position).getGoods_id();
//                Toast.makeText(ListActivity.this, goods_id + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                intent.putExtra("goods_id",goods_id);
                startActivity(intent);
            }

            @Override
            public void onLongItemClickListener(View view, int possition) {

            }
        });
    }

    @Override
    public void callbackData(ListBean listBean) {
        recyclerlist = listBean.getDatas().getGoods_list();
        Log.e("ASD",recyclerlist.get(0).getGoods_name());
        Log.e("ASD",listBean.getDatas().getGoods_list().size()+"");
        listRecyclerAdapter.setList(recyclerlist);
        listRecycler.setLayoutManager(new LinearLayoutManager(this));
        listRecyclerAdapter.notifyDataSetChanged();

    }


    @Override
    public void callbackErrer(String errcode) {

    }
}
