package com.wpzmall.mymall.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.Class.ExpandableBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/17  14:49
 * <p>
 * 思路：
 */


public class ClassExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ExpandableBean.DatasBean.ClassListBean> list  = new ArrayList<>();
    private List<ExpandableBean.DatasBean.ClassListBean> gridlist = new ArrayList<>();
    private ClassExpandGridAdapter classExpandGridAdapter;

    public ClassExpandableAdapter(Context context) {
        this.context = context;
    }

    public void getExpandList(List<ExpandableBean.DatasBean.ClassListBean> list){
        this.list = list;
    }

    public void getExpandGridList(List<ExpandableBean.DatasBean.ClassListBean> gridlist){
        this.gridlist = gridlist;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    //小坑，因嵌套GridView需要返回1
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return gridlist.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = convertView.inflate(context, R.layout.item_class_expand_group,null);
        TextView text_1 = (TextView) convertView.findViewById(R.id.item_class_expand_text);
        text_1.setText(list.get(groupPosition).getGc_name());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = convertView.inflate(context, R.layout.item_class_expandable, null);
        GridView gridview = (GridView) convertView.findViewById(R.id.item_class_expand_grid);
        classExpandGridAdapter = new ClassExpandGridAdapter(context);
        gridview.setAdapter(classExpandGridAdapter);
        classExpandGridAdapter.getData(gridlist);
        classExpandGridAdapter.notifyDataSetChanged();
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
