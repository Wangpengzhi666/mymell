package com.wpzmall.mymall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.Class.ExpandableBean;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/5  20:20
 * <p>
 * 思路：
 */


public class ClassExpandGridAdapter extends BaseAdapter {

    private Context context;
    private List<ExpandableBean.DatasBean.ClassListBean> list = new ArrayList<>();

    public ClassExpandGridAdapter(Context context) {
        this.context = context;
    }

    public void getData(List<ExpandableBean.DatasBean.ClassListBean> class_list) {
        this.list = class_list;
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
        ClassExpandGridAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ClassExpandGridAdapter.ViewHolder();
            convertView = convertView.inflate(context, R.layout.item_class_expand_grid, null);
            viewHolder.itemClassExpendGridText = (TextView) convertView.findViewById(R.id.item_class_expand_grid_text);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ClassExpandGridAdapter.ViewHolder)convertView.getTag();
        }
        viewHolder.itemClassExpendGridText.setText(list.get(position).getGc_name());
        return convertView;
    }

    class ViewHolder {
        public TextView itemClassExpendGridText;
    }
}
