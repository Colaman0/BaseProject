package com.lsj.colaman.quickproject;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lsj.colaman.quickproject.adapter.FeaturesAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;

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
    private FeaturesAdapter mAdapter;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_simple_item;
    }

    @Override
    protected void initView() {
        recyclerview = findViewById(R.id.recyclerview);
        mAdapter = new FeaturesAdapter(this)
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
                mAdapter.getDatas().add(0, new TestaViewModel(101));
                mAdapter.diffNotifydatasetchanged();
                break;
            case R.id.btn_2:
                mAdapter.getDatas().remove(0);
                mAdapter.diffNotifydatasetchanged();
                break;
            case R.id.btn_3:
                mAdapter.getDatas().clear();
                mAdapter.diffNotifydatasetchanged();
                break;
        }
    }
}
