package com.lsj.colaman.quickproject.base;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;
import com.lsj.colaman.quickproject.R;

import butterknife.ButterKnife;

/**
 * Create by kyle on 2018/9/19
 * Function : baseActivity
 */
public abstract class BaseActivity extends AppCompatActivity {
    // 状态栏颜色
    private int mDefaultStatusBarColorRes = R.color.colorPrimary;
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutRes());
        ButterKnife.bind(this,this);
        initStatusBar();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destoryStatusBar();
    }

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
}
