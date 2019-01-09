package com.lsj.colaman.quickproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.util.DiffUtil;

import com.lsj.colaman.quickproject.base.BaseViewModel;
import com.lsj.colaman.quickproject.base.CommonDiffCallBack;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by kyle on 2019/1/8
 * Function : 带有diffutil刷新的adapter
 */
public class DiffAdapter extends ListAdapter<DiffAdapter> {
    private List<BaseViewModel> oldDatas = new ArrayList<>();

    public DiffAdapter(Context context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void diffNotifydatasetchanged() {
        // TODO: 2019/1/8 加入生命周期的监听 autodisposable
        Observable.just("")
                .subscribeOn(Schedulers.computation())
                .map(s -> DiffUtil.calculateDiff(getDiffCallback(), false))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(diffResult -> diffResult.dispatchUpdatesTo(DiffAdapter.this))
                .doOnComplete(() -> {
                    oldDatas.clear();
                    oldDatas.addAll(getDatas());
                })
                .subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
    }

    private DiffUtil.Callback getDiffCallback() {
        return new CommonDiffCallBack(oldDatas, getDatas());
    }
}
