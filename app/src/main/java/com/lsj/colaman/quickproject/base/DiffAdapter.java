package com.lsj.colaman.quickproject.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.util.DiffUtil;

import com.lsj.colaman.quickproject.adapter.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by kyle on 2019/1/8
 * Function : 带有diffutil刷新的adapter
 */
public class DiffAdapter extends BaseAdapter {

    public DiffAdapter(Context context) {
        super(context);
    }


}
