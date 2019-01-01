package com.lsj.colaman.quickproject;

import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.lsj.colaman.quickproject.adapter.BaseAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {

    RecyclerView recyclerview;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    private BaseAdapter mAdapter;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_simple_item;
    }

    @Override
    protected void initView() {
        recyclerview = findViewById(R.id.recyclerview);
        mAdapter = new BaseAdapter(this)
                .bindRecyclerView(recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerview.setAdapter(mAdapter);
        for (int i = 0; i < 100; i++) {
            mAdapter.add(new TestaViewModel(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                ((LinearLayoutManager) recyclerview.getLayoutManager()).scrollToPositionWithOffset(0, 0);
                break;
            case R.id.btn_2:
                ((LinearLayoutManager) recyclerview.getLayoutManager()).scrollToPositionWithOffset(mAdapter.getItemCount() / 2, 0);
                break;
            case R.id.btn_3:
                ((LinearLayoutManager) recyclerview.getLayoutManager()).scrollToPositionWithOffset(mAdapter.getItemCount() - 1, 0);
                break;
        }
    }
}
