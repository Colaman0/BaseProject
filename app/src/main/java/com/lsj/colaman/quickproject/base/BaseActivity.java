package com.lsj.colaman.quickproject.base;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.lsj.colaman.quickproject.R;

import butterknife.ButterKnife;


/**
 * Create by kyle on 2018/9/19
 * Function : baseActivity
 */
public abstract class BaseActivity extends AppCompatActivity {
    private LifecycleRegistry mLifecycleRegistry;

    // 状态栏颜色
    private int mDefaultStatusBarColorRes = R.color.colorPrimary;
    private ImmersionBar mImmersionBar;
    private ViewGroup mRootView;
    private StatusManager mStatusManager = new StatusManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutRes());
        initLifeCycle();
        ButterKnife.bind(this, this);
        initStatusLayout();
        initStatusBar();
        initView();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusManager.destory();
        destoryStatusBar();
    }

    private void initLifeCycle() {
        mLifecycleRegistry = new LifecycleRegistry(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
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

    /**
     * 加载多布局管理
     */
    private void initStatusLayout() {

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

    public Intent getDefaultIntent(Class activity) {
        return new Intent(this, activity);
    }

    public void goToAcitivty(Class activity) {
        startActivity(getDefaultIntent(activity));
    }

    public void switchLayout(String layoutType) {
//        contentLayout.switchLayout(layoutType);
    }
}
