package com.lsj.colaman.quickproject.test;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lsj.colaman.quickproject.Constants;
import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;

public class LayoutActivity extends BaseActivity {
    private int num = 1;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_layout;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initView() {
        Observable.just(0)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer>0;
                    }
                })
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("cola", "first int =" + integer);
                    }
                })
                .subscribe(Functions.emptyConsumer());

        Observable.just(0)
                .defaultIfEmpty(-1)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer>0;
                    }
                })
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("cola", "second int =" + integer);
                    }
                })
                .subscribe(Functions.emptyConsumer());
        Observable.interval(2, 2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        String type = "";
                        switch (num %= 3) {
                            case 1:
                                type = Constants.STATUS_EMPTY;
                                break;
                            case 2:
                                type = Constants.STATUS_ERROR;
                                break;
                            case 0:
                                type = Constants.STATUS_NORMAL;
                                break;
                        }
                        switchLayout(type);
                        num++;
                    }
                });
    }
}
