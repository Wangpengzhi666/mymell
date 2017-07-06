package com.wpzmall.mymall.view.frgament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
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
    private List<ExpandableBean.DatasBean.ClassListBean> class_Expand2;
    private List<ExpandableBean.DatasBean.ClassListBean> class_Expand3;
    private ClassPresenter classPresenter;
    private ExpandableListView ClassExpandable;
    private ClassExpandPresenter classExpandPresenter;
    private ClassExpandableAdapter classExpandableAdapter;

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

        ClassExpandable = (ExpandableListView) getView().findViewById(R.id.Class_Expandable);
        classExpandPresenter = new ClassExpandPresenter();
        classExpandPresenter.setmT(this);
        classExpandableAdapter = new ClassExpandableAdapter(getActivity());
        ClassExpandable.setAdapter(classExpandableAdapter);
    }

    @Override
    public void callbackData(LeftListBean leftListBean) {
        class_list = leftListBean.getDatas().getClass_list();
//        Toast.makeText(getActivity(), "++" + class_list.get(0).getGc_name(), Toast.LENGTH_SHORT).show();
        classListLeftAdapter.getData(class_list);
        classListLeftAdapter.notifyDataSetChanged();
        classExpandPresenter.getClassExpanderData2(class_list.get(0).getGc_id());
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
        classExpandableAdapter.getExpandList(class_Expand2);
        classListLeftAdapter.notifyDataSetChanged();
        classExpandPresenter.getClassExpandData3(class_Expand2.get(0).getGc_id());
    }

    @Override
    public void CollBackViewData3(ExpandableBean expandableBean) {
        class_Expand3 = expandableBean.getDatas().getClass_list();
        classExpandableAdapter.getExpandGridList(class_Expand3);
        classListLeftAdapter.notifyDataSetChanged();
    }
}
