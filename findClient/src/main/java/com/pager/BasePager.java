package com.pager;

import android.view.View;

import com.all.activity.LightingSystemActivity_test;

/**
 * 五个标签页的基类
 *
 * @author Kevin
 * @date 2015-10-18
 */
public abstract class BasePager {

    public LightingSystemActivity_test mActivity;
    public View mRootView;// 当前页面的布局对象

    public BasePager(LightingSystemActivity_test activity) {
        mActivity = activity;
        mRootView = initView();
    }

    protected abstract View initView();


    // 初始化数据
    public void initData() {

    }
}
