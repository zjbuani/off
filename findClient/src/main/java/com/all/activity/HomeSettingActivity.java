package com.all.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.adapter.SetItemAdapter;
import com.fengxun.base.BaseActivity;
import com.zhy.sample.folderlayout.R;

import java.util.ArrayList;

/**
 * Created by fengx on 2017/9/22.
 */

public class HomeSettingActivity extends BaseActivity  implements View.OnClickListener {

    private TextView mtitle;
    private ImageView mString;
    private ImageView mBack;
    private ListView mSetItemLv;

    @Override
    protected int initLayout() {
        return R.layout.setting_layout;
    }
    @Override
    protected void initView() {
        mtitle = (TextView) findViewById(R.id.title_bar);
        mString = (ImageView) findViewById(R.id.home_set);
//        mSetItemLv = (ListView) findViewById(R.id.set_item_lv);
        //返回按钮
        mBack = (ImageView) findViewById(R.id.home_bl);

    }
    @Override
    protected void initData() {
        //设置title
        mtitle.setText("设置");
        //隐藏设置按钮
        mString.setVisibility(View.INVISIBLE);
        ArrayList<String> list = new ArrayList<>();
        list.add("系统说明");
        list.add("版本信息");
        list.add("连接服务器地址  ");
        SetItemAdapter mAdapter = new SetItemAdapter(this, list);
        mSetItemLv.setAdapter(mAdapter);
    }
    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        this.finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_left,R.anim.activity_right);
    }


}
