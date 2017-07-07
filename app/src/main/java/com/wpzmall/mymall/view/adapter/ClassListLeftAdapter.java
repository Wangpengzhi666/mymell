package com.wpzmall.mymall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/17  10:40
 * <p>
 * 思路：
 */


public class ClassListLeftAdapter extends BaseAdapter {

    private Context context;
    private List<LeftListBean.DatasBean.ClassListBean> list = new ArrayList<>();
    private int defItem;//声明默认选中的项

    public void getData(List<LeftListBean.DatasBean.ClassListBean> class_list) {
        this.list = class_list;
    }


    public ClassListLeftAdapter(Context context) {
        this.context = context;
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
            convertView = convertView.inflate(context, R.layout.item_class_left_list, null);
            viewHolder.itemClassListImage = (ImageView) convertView.findViewById(R.id.item_class_list_image);
            viewHolder.itemClassListText = (TextView) convertView.findViewById(R.id.item_class_list_text);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.itemClassListText.setText(list.get(position).getGc_name());
        //逼格稍微高一点的Glide加载图片方法
        Glide.with(context)
                .load(list.get(position).getImage())
                .placeholder(R.mipmap.ic_action_add)
                .into(viewHolder.itemClassListImage);

        return convertView;
    }


    class ViewHolder {
        public ImageView itemClassListImage;
        public TextView itemClassListText;
    }
}
