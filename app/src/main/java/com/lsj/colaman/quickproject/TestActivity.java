package com.lsj.colaman.quickproject;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lsj.colaman.quickproject.adapter.BaseAdapter;
import com.lsj.colaman.quickproject.adapter.SimpleAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.layoutmanager.LinearLayoutManagerWrapper;
import com.lsj.colaman.quickproject.test.Data;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;

public class TestActivity extends BaseActivity {

    RecyclerView recyclerview;
    private BaseAdapter mAdapter;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_simple_item;
    }

    @Override
    protected void initView() {
        recyclerview = findViewById(R.id.recyclerview);
        mAdapter = new BaseAdapter(this);
        recyclerview.setLayoutManager(new LinearLayoutManagerWrapper(this, LinearLayoutManager.VERTICAL, false));
        recyclerview.setAdapter(mAdapter);
        for (int i = 0; i < 100; i++) {
            mAdapter.add(new TestaViewModel(i));
            mAdapter.add(new TestViewModel(this, i));
        }
        mAdapter.notifyDataSetChanged();
        Observable.interval(3, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                    }
                })
                .subscribe(Functions.emptyConsumer());
    }
}
