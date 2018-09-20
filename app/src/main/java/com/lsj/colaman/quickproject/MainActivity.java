package com.lsj.colaman.quickproject;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lsj.colaman.quickproject.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected int initLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected int setStatusBarColor() {
        return R.color.colorAccent;
    }
}
