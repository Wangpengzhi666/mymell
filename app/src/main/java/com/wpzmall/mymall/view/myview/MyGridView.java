package com.wpzmall.mymall.view.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/6  14:58
 * <p>
 * 思路：
 */


public class MyGridView extends GridView {
    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 重写该方法，达到使 GridView 适应 ExpandableListView 的效果
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
