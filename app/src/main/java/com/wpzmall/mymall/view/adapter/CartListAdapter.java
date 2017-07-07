package com.wpzmall.mymall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.cart.CartBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  21:37
 * <p>
 * 思路：
 */


public class CartListAdapter extends BaseAdapter {
    private Context context;
    private List<CartBean.DatasBean.CartListBean.GoodsBean> list = new ArrayList<>();

    public CartListAdapter(Context context) {
        this.context = context;
    }

    public void getData(List<CartBean.DatasBean.CartListBean.GoodsBean> list) {
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.item_cart_list, null);
        }
        return convertView;
    }

    class ViewHolder {
        public View rootView;
        public ImageView cartLvImage;
        public TextView cartLvName;
        public TextView cartLvPrice;
        public TextView cartLvNum;
        public TextView cartLvNum2;
        public TextView cartLvPrice2;
        public TextView cartLvDelete;
        public TextView cartLvSubtract;
        public TextView cartLvBuyNum;
        public TextView cartLvAdd;
    }
}
