package com.wpzmall.mymall.view.frgament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wpzmall.mymall.R;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/9  16:36
 * <p>
 * 思路：
 */


public class CartFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_cart, container, false);
        return inflate;
    }
}
