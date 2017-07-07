package com.wpzmall.mymall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.model.Bean.details.DetailsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  11:19
 * <p>
 * 思路：
 */


public class DetailsListAdapter extends BaseAdapter {
    private Context context;
    private List<DetailsBean.DatasBean.GoodsCommendListBean> list = new ArrayList<>();

    public DetailsListAdapter(Context context) {
        this.context = context;
    }
    public void getData(List<DetailsBean.DatasBean.GoodsCommendListBean> list) {
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
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = convertView.inflate(context, R.layout.item_details_list, null);
            viewHolder.item_details_list_name = (TextView) convertView.findViewById(R.id.item_details_list_name);
            viewHolder.item_details_list_price = (TextView) convertView.findViewById(R.id.item_details_list_price);
            viewHolder.item_details_list_image = (ImageView) convertView.findViewById(R.id.item_details_list_image);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (DetailsListAdapter.ViewHolder)convertView.getTag();
        }

        viewHolder.item_details_list_name.setText(list.get(position).getGoods_name());
        viewHolder.item_details_list_price.setText(list.get(position).getGoods_promotion_price());

        //逼格稍微高一点的Glide加载图片方法
        Glide.with(context)
                .load(list.get(position).getGoods_image_url())
                .placeholder(R.mipmap.ic_action_add)
                .into(viewHolder.item_details_list_image);
        return convertView;
    }

    class ViewHolder {
        public ImageView item_details_list_image;
        public TextView item_details_list_name;
        public TextView item_details_list_price;

    }
}
