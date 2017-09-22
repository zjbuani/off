package com.all.activity;

import android.content.Intent;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.http.response.bean.SignInBean;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.zhy.sample.folderlayout.LeftMenuFragment;
import com.zhy.sample.folderlayout.R;
import com.zhy.sample.folderlayout.RightMenuFragment;

/**
 * Created by fengx on 2017/9/14.
 */

public class HomeActivity extends SlidingFragmentActivity implements View.OnClickListener {
    private static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
    private static final String TAG_RIGHT_MENU = "TAG_RIGHT_MENU";
    //左上角的 查看按钮
    private ImageView mHome_bl;
    //右上角的 设置按钮
    private ImageView mHome_set;
    private SlidingMenu slidingMenu;
    private ImageView mLightbtn;
    private ImageView mLightbtn1;
    private ImageView mCarbtn;
    private ImageView mEnvbtn;
    private ImageView mAdsbtn;
    private ImageView mWorkbtn;
    private ImageView mCarsharebtn;
    private SignInBean signInBean;


    protected int initLayout() {
        return R.layout.bolang;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initData();
        initListener();
        slidingMenu = getSlidingMenu();
        setBehindContentView(R.layout.left_menu);
        slidingMenu.setSecondaryMenu(R.layout.right_menu);
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        slidingMenu.setFadeEnabled(true);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 全屏触摸
        // slidingMenu.setBehindOffset(200);// 屏幕预留200像素宽度
        // 200/320 * 屏幕宽度
        WindowManager wm = getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        slidingMenu.setBehindOffset(width * 200 / 320);
        initFragment();
    }

    private void initData() {
        /**
         *  获取登录界面 发送过来的 内容
         */
        signInBean = (SignInBean) getIntent().getSerializableExtra("SignInBean");

    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();// 开始事务
        LeftMenuFragment leftMenuFragment = new LeftMenuFragment();
        if (signInBean != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("SignInBean", signInBean);
            leftMenuFragment.setArguments(bundle);
        }
        transaction.replace(R.id.fl_left_menu, leftMenuFragment,
                TAG_LEFT_MENU);// 用fragment替换帧布局;参1:帧布局容器的id;参2:是要替换的fragment;参3:标记
        transaction.replace(R.id.fl_right_menu, new RightMenuFragment(), TAG_RIGHT_MENU);
        transaction.commit();// 提交事务
    }

    protected void initView() {
        mHome_bl = (ImageView) findViewById(R.id.home_bl);
        mHome_set = (ImageView) findViewById(R.id.home_set);
        mLightbtn1 = (ImageView) findViewById(R.id.lightbtn);
        mCarbtn = (ImageView) findViewById(R.id.carbtn);
        mEnvbtn = (ImageView) findViewById(R.id.envbtn);
        mAdsbtn = (ImageView) findViewById(R.id.adsbtn);
        mWorkbtn = (ImageView) findViewById(R.id.workbtn);
        mCarsharebtn = (ImageView) findViewById(R.id.carsharebtn);

    }

    private void initListener() {
        mHome_bl.setOnClickListener(this);
        mHome_set.setOnClickListener(this);
        mLightbtn1.setOnClickListener(this);
        mCarbtn.setOnClickListener(this);
        mEnvbtn.setOnClickListener(this);
        mAdsbtn.setOnClickListener(this);
        mWorkbtn.setOnClickListener(this);
        mCarsharebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.home_bl:
                toggle();
                break;
            case R.id.home_set:
                intent = new Intent(this, HomeSettingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right, R.anim.left);
                break;
            case R.id.lightbtn:
                intent = new Intent(HomeActivity.this, LightingSystemActivity.class);
                startActivity(intent);
                break;
            case R.id.carbtn:
                intent = new Intent(HomeActivity.this, CarGuidanceSystemActivity.class);
                startActivity(intent);
                break;
            case R.id.envbtn:
                intent = new Intent(HomeActivity.this, EnvironmentSystemActivity.class);
                startActivity(intent);

                break;
            case R.id.adsbtn:
                intent = new Intent(HomeActivity.this, AdvertisementSystemActivity.class);
                startActivity(intent);
                break;
            case R.id.workbtn:
                intent = new Intent(HomeActivity.this, StationSystemActivity.class);
                startActivity(intent);
                break;
            case R.id.carsharebtn:
                intent = new Intent(HomeActivity.this, CarPointSystemActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 按钮被按下
     */
    private final static float[] BUTTON_PRESSED = new float[]{
            2.0f, 0, 0, 0, -50,
            0, 2.0f, 0, 0, -50,
            0, 0, 2.0f, 0, -50,
            0, 0, 0, 5, 0};

    /**
     * 按钮恢复原状
     */
    private final static float[] BUTTON_RELEASED = new float[]{
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0};

    private static final View.OnTouchListener touchListener = new View.OnTouchListener() {


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.getBackground().setColorFilter(new ColorMatrixColorFilter(BUTTON_PRESSED));
                v.setBackgroundDrawable(v.getBackground());
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                v.getBackground().setColorFilter(new ColorMatrixColorFilter(BUTTON_RELEASED));
                v.setBackgroundDrawable(v.getBackground());
            }
            return false;
        }
    };

    public static void setButtonStateChangeListener(ImageView v) {
        v.setOnTouchListener(touchListener);
    }


}

