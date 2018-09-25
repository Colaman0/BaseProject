package com.lsj.colaman.quickproject.test;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.adapter.SimpleAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.layoutmanager.LinearLayoutManagerWrapper;

import java.util.ArrayList;

import butterknife.BindView;

public class SimpleItemActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshlayout)
    SwipeRefreshLayout refreshlayout;
    private ArrayList<Data> mData = new ArrayList<>();
    private SimpleAdapter mAdapter;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_simple_item;
    }

    @Override
    protected void initView() {
        for (int i = 0; i < 10; i++) {
            mData.add(new Data(String.valueOf(mData.size())));
        }
        mAdapter = new SimpleAdapter(R.layout.item_text, mData);
        recyclerview.setLayoutManager(new LinearLayoutManagerWrapper(this, LinearLayoutManager.VERTICAL, false));
        recyclerview.setAdapter(mAdapter);
        add();
        refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                add();
            }
        });
    }

    private void add() {
        for (int i = 0; i < 10; i++) {
            mData.add(new Data(String.valueOf(mData.size())));
        }
        refreshlayout.setRefreshing(false);
        mAdapter.updateUi(mData);
    }
}
