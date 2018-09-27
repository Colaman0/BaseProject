package com.lsj.colaman.quickproject.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.gyf.barlibrary.ImmersionBar;
import com.lsj.colaman.quickproject.Constants;
import com.lsj.colaman.quickproject.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import butterknife.ButterKnife;


/**
 * Create by kyle on 2018/9/19
 * Function : baseActivity
 */
public abstract class BaseActivity extends AppCompatActivity {
    // 状态栏颜色
    private int mDefaultStatusBarColorRes = R.color.colorPrimary;
    private ImmersionBar mImmersionBar;
    private ViewGroup mRootView;
    private StatusManager mStatusManager = new StatusManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.include_status, (ViewGroup) getWindow().getDecorView().getRootView(),false);
        setContentView(mRootView);
        ButterKnife.bind(this, this);
        initStatusBar();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initStatusLayout(initLayoutRes(), mRootView);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusManager.destory();
        destoryStatusBar();
    }

    @LayoutRes
    protected abstract int initLayoutRes();

    protected abstract void initView();

    /**
     * 设置状态栏颜色
     */
    private void initStatusBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar
                .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
                .keyboardEnable(true)
                .statusBarDarkFont(true, 0.2f)
                .statusBarColor(setStatusBarColor())
                .init();
    }

    private void initStatusLayout(int layoutRes, ViewGroup rootView) {
        mStatusManager.init(this, layoutRes, rootView)
                .add(Constants.STATUS_EMPTY, R.layout.include_status_empty, true)
                .add(Constants.STATUS_ERROR, R.layout.include_status_error, true);

    }

    /**
     * 释放关于状态栏的资源
     */
    private void destoryStatusBar() {
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }

    /**
     * 设置状态栏颜色
     *
     * @return
     */
    @ColorRes
    protected int setStatusBarColor() {
        return mDefaultStatusBarColorRes;
    }

    public Context getContext() {
        return this;
    }

    public Activity getActivity() {
        return this;
    }

    public Intent getDefaultIntent(Activity activity) {
        return new Intent(activity, getClass());
    }

    public void goToAcitivty(Activity activity) {
        startActivity(getDefaultIntent(activity));
    }

    public void switchLayout(String layoutType) {
        mStatusManager.switchLayout(layoutType);
    }
}
