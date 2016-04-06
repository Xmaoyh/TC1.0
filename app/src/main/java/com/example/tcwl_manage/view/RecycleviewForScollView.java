package com.example.tcwl_manage.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by suanzi on 2016/3/31.
 * 重新计算Recycleview高度
 */
public class RecycleviewForScollView extends RecyclerView {

    public RecycleviewForScollView(Context context) {
        super(context);
    }

    public RecycleviewForScollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecycleviewForScollView(Context context, AttributeSet attrs,
                                   int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    /**
     * 重写该方法，达到使Recycleview适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
