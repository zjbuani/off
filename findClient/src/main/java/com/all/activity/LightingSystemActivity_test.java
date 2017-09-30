package com.all.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.fengxun.base.BaseActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.utils.MPCU;
import com.utils.ToastShowUtil;
import com.zhy.sample.folderlayout.R;

/**
 * 照明系统
 * Created by fengx on 2017/9/19.
 */

public class LightingSystemActivity_test extends BaseActivity {
    private LineChart mChart;
    private RadioButton mRbHome;
    private RadioButton mRb_man;
    private ViewPager mLight_pager;
    private RadioGroup mRg_group;

    @Override
    protected int initLayout() {
        return R.layout.light_fragment_layout;

    }

    @Override
    protected void initView() {
        //用来预览就加载
        mLight_pager = (ViewPager) findViewById(R.id.light_pager);
        mRg_group = (RadioGroup) findViewById(R.id.rg_group);

    }




    @Override
    protected void cancel() {   //取消titleBar
        cancelTitleBar();
    }


}

