package com.lsj.colaman.quickproject;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lsj.colaman.quickproject.adapter.PositionAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.base.CommonDiffCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private BaseQuickAdapter mAdapter;
    private List<Info> mData = new ArrayList<>();

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        for (int i = 0; i < 10; i++) {
            mData.add(new Info((String.valueOf(i))));
        }
        mAdapter = new PositionAdapter(R.layout.item_text, mData);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                mAdapter.remove(position);
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerview.setAdapter(mAdapter);
    }

    @Override
    protected int setStatusBarColor() {
        return R.color.colorAccent;
    }

}
