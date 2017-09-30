package com.all.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fengxun.base.BaseActivity;
import com.utils.PrefUtils;
import com.utils.ToastShowUtil;
import com.zhy.sample.folderlayout.R;

/**
 * Created by fengx on 2017/9/22.
 */

public class HomeSettingActivity extends BaseActivity implements View.OnClickListener {

    private TextView mtitle;
    private ImageView mString;
    private ImageView mBack;
    private Button mConnect;
    private TextView mConnect_tv;
    private String[] arr = {"外网", "内网"};
    private Button mLogout;

    @Override
    protected int initLayout() {
        return R.layout.setting_layout;
    }

    @Override
    protected void initView() {
        mtitle = (TextView) findViewById(R.id.title_bar);
        mString = (ImageView) findViewById(R.id.home_set);
        mBack = (ImageView) findViewById(R.id.home_bl);//返回按钮
        mConnect = (Button) findViewById(R.id.connect); //选择是内网还是外网
        mConnect_tv = (TextView) findViewById(R.id.connect_tv); //返回显示的事内网还是外网
        mLogout = (Button) findViewById(R.id.logout);   //用户注销

    }

    @Override
    protected void initData() {
        //设置title
        mtitle.setText("设置");
        //隐藏设置按钮
        mString.setVisibility(View.INVISIBLE);


    }

    /**
     * 注销用户登录
     */
    private void logOut() {
        PrefUtils.setString(this, "user", "");
        PrefUtils.setString(this, "mPostPwd", "");
        ToastShowUtil.showToast(this,"注销成功");
        mLogout.setEnabled(true);
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
        mConnect.setOnClickListener(this);
        mLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_bl:
                this.finish();
                break;
            case R.id.connect:
                showDialog();
                break;
            case R.id.logout:
                mLogout.setEnabled(false); //设置不可点击
                logOut();
                break;
        }

    }

    private void showDialog() {
        final AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
        mDialog.setSingleChoiceItems(arr, 1, new DialogInterface.OnClickListener() { // 参数2  设置默认选项
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mConnect_tv.setText(arr[which]);  //显示是内网 还是外网
                dialog.dismiss();
            }
        });
        mDialog.show();

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
    }


}
