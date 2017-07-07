package com.wpzmall.mymall.view.frgament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.Class.ExpandableBean;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.presenter.ClassExpandPresenter;
import com.wpzmall.mymall.presenter.ClassPresenter;
import com.wpzmall.mymall.view.adapter.ClassExpandableAdapter;
import com.wpzmall.mymall.view.adapter.ClassListLeftAdapter;
import com.wpzmall.mymall.view.iview.IClassExpandView;
import com.wpzmall.mymall.view.iview.IClassView;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/9  16:35
 * <p>
 * 思路：
 */


public class ClassFragment extends Fragment implements IClassView<LeftListBean>,View.OnClickListener,IClassExpandView<ExpandableBean> {
    private ListView ClassListLeft;
    private ClassListLeftAdapter classListLeftAdapter;
    private List<LeftListBean.DatasBean.ClassListBean> class_list;
    private List<ExpandableBean.DatasBean.ClassListBean> grouplist = new ArrayList<>();
    private List<ExpandableBean.DatasBean.ClassListBean> childlist=new ArrayList<>();
    private List<ExpandableBean.DatasBean.ClassListBean> class_Expand2;
    private List<ExpandableBean.DatasBean.ClassListBean> class_Expand3;
    private ClassPresenter classPresenter;
    private ExpandableListView ClassExpandable;
    private ClassExpandPresenter classExpandPresenter;
    private ClassExpandableAdapter classExpandableAdapter;
    private int classIndex = 0;
    private int class2Index = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_class, container, false);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {




        //左侧分类列表
        ClassListLeft = (ListView) getView().findViewById(R.id.Class_list_left);
        classPresenter = new ClassPresenter();
        classPresenter.setmT(this);
        classPresenter.getClassData();
        classListLeftAdapter = new ClassListLeftAdapter(getActivity());
        ClassListLeft.setAdapter(classListLeftAdapter);
        ClassListLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                classIndex = position;
                classExpandPresenter.getClassExpanderData2(class_list.get(classIndex).getGc_id());
            }
        });

        ClassExpandable = (ExpandableListView) getView().findViewById(R.id.Class_Expandable);
        classExpandPresenter = new ClassExpandPresenter();
        classExpandPresenter.setmT(this);

        classExpandableAdapter = new ClassExpandableAdapter(getActivity());
        ClassExpandable.setAdapter(classExpandableAdapter);


        ClassExpandable.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                class2Index = groupPosition;
                classExpandPresenter.getClassExpandData3(class_Expand2.get(class2Index).getGc_id());
                return true;
            }
        });
        ClassExpandable.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i = 0; i < class_Expand2.size(); i++) {
                    if (groupPosition != i){
                        ClassExpandable.collapseGroup(i);
                    }
                }
            }
        });

    }

    @Override
    public void callbackData(LeftListBean leftListBean) {
        class_list = leftListBean.getDatas().getClass_list();
        classListLeftAdapter.getData(class_list);
        classListLeftAdapter.notifyDataSetChanged();
        classExpandPresenter.getClassExpanderData2(class_list.get(classIndex).getGc_id());
    }

    @Override
    public void callbackErrer(String errcode) {
        Toast.makeText(getActivity(), "" + errcode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        ClassExpandable.setOnClickListener(this);
    }

    @Override
    public void CollBackViewData2(ExpandableBean expandableBean) {
        class_Expand2 = expandableBean.getDatas().getClass_list();
        grouplist.clear();
        grouplist.addAll(class_Expand2);
        classExpandableAdapter.getExpandList(grouplist);
        classExpandableAdapter.notifyDataSetChanged();
        classExpandPresenter.getClassExpandData3(class_Expand2.get(0).getGc_id());
    }

    @Override
    public void CollBackViewData3(ExpandableBean expandableBean) {
        class_Expand3 = expandableBean.getDatas().getClass_list();
        childlist.clear();
        childlist.addAll(class_Expand3);
        classExpandableAdapter.getExpandGridList(childlist);
        classListLeftAdapter.notifyDataSetChanged();
        ClassExpandable.expandGroup(class2Index);
    }
}
