package com.all.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.fengxun.base.BaseActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.utils.MPCU;
import com.utils.ToastShowUtil;
import com.view.MyMarkerView;
import com.zhy.sample.folderlayout.R;

import java.util.ArrayList;

/**
 * 照明系统
 * Created by fengx on 2017/9/19.
 */

public class LightingSystemActivity extends BaseActivity implements RadioButton.OnCheckedChangeListener {
    private LineChart mChart;
    private RadioButton mRbHome;
    private RadioButton mRb_man;

    @Override
    protected int initLayout() {
        return R.layout.light_system_layout;

    }

    @Override
    protected void initView() {
        mChart = (LineChart) findViewById(R.id.chart1);
        mRbHome = (RadioButton) findViewById(R.id.rb_home);
        mRb_man = (RadioButton) findViewById(R.id.rb_man);

        View mLight_fault = findViewById(R.id.fault); //

    }

    @Override
    protected void initListener() {
        mRbHome.setOnCheckedChangeListener(this);
        mRb_man.setOnCheckedChangeListener(this);

    }
    @Override
    protected void initData() {

        MPCU.showLine(this,mChart,null);

    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ToastShowUtil.showToast(this, " " + isChecked);
        Intent mIntent = null;
        switch (((RadioButton) buttonView).getId()) {
            case R.id.rb_man:  // 这里点击的 是 管理中心
                if (mIntent == null) {
                    mIntent = new Intent(this, ManageMent.class);
                    startActivity(mIntent);
                    finish();
                }
                ToastShowUtil.showToast(this, "rb_man" + "isChecked  " + isChecked);
                break;
            case R.id.rb_home:
                if (mIntent == null) {
                    mIntent = new Intent(this, LightingSystemActivity.class);
                }
                ToastShowUtil.showToast(this, "rb_home" + "isChecked  " + isChecked);
                break;
        }
    }



    @Override
    protected void cancel() {   //取消titleBar
        cancelTitleBar();
    }


}

