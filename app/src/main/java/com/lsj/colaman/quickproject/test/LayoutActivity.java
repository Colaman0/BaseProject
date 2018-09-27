package com.lsj.colaman.quickproject.test;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lsj.colaman.quickproject.Constants;
import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class LayoutActivity extends BaseActivity {
    private int num = 1;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_layout;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initView() {
        Observable.interval(10, 2, TimeUnit.SECONDS)
                .take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        switchLayout(Constants.STATUS_EMPTY);
                    }
                });
    }
}
