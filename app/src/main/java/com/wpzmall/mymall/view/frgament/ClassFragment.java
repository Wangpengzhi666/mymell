package com.wpzmall.mymall.view.frgament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.Class.LeftListBean;
import com.wpzmall.mymall.presenter.ClassPresenter;
import com.wpzmall.mymall.view.adapter.ClassListLeftAdapter;
import com.wpzmall.mymall.view.iview.IClassView;

import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/9  16:35
 * <p>
 * 思路：
 */


public class ClassFragment extends Fragment implements IClassView<LeftListBean>{
    private ListView ClassListLeft;
    private ClassListLeftAdapter classListLeftAdapter;
    private List<LeftListBean.DatasBean.ClassListBean> class_list;
    private ClassPresenter classPresenter;

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
        ClassListLeft = (ListView) getView().findViewById(R.id.Class_list_left);
        classPresenter = new ClassPresenter();
        classPresenter.setmT(this);
        classPresenter.getClassData();
        classListLeftAdapter = new ClassListLeftAdapter(getActivity());
        ClassListLeft.setAdapter(classListLeftAdapter);
    }

    @Override
    public void callbackData(LeftListBean leftListBean) {
        class_list = leftListBean.getDatas().getClass_list();
//        Toast.makeText(getActivity(), "++" + class_list.get(0).getGc_name(), Toast.LENGTH_SHORT).show();
        classListLeftAdapter.getData(class_list);
        classListLeftAdapter.notifyDataSetChanged();
    }

    @Override
    public void callbackErrer(String errcode) {
        Toast.makeText(getActivity(), "" + errcode, Toast.LENGTH_SHORT).show();
    }
}
