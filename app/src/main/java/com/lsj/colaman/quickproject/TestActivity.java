package com.lsj.colaman.quickproject;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lsj.colaman.quickproject.adapter.BaseAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.common.helper.RecyclerViewHelper;
import com.lsj.colaman.quickproject.common.imp.OnItemClickListener;

import butterknife.BindView;
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
                .bindRecyclerView(recyclerview)
                .addItemClickListener((position, itemView) -> Log.d("cola", "position = " + position));
        recyclerview.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
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
                mAdapter.getDatas().get(1).getConvertView().performClick();
                break;
            case R.id.btn_2:
                mAdapter.getDatas().get(3).getConvertView().performClick();
                break;
            case R.id.btn_3:
                RecyclerViewHelper.smoothScrollToPosition(recyclerview, 40, LinearSmoothScroller.SNAP_TO_END);
                break;
        }
    }
}
