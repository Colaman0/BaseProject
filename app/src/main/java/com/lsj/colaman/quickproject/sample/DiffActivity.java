package com.lsj.colaman.quickproject.sample;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.TestActivity;
import com.lsj.colaman.quickproject.TestaViewModel;
import com.lsj.colaman.quickproject.adapter.FeaturesAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.common.view.LoadMoreView;

import butterknife.BindView;
import butterknife.OnClick;

public class DiffActivity extends BaseActivity {

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

    @SuppressLint("AutoDispose")
    @Override
    protected void initView() {
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new FeaturesAdapter(this)
                .addItemClickListener((position, itemView) -> Log.d("cola", "position = " + position));
        recyclerview.setAdapter(mAdapter);
        mAdapter.add(new TestaViewModel(123));
        mAdapter.add(new TestaViewModel(123));
//        mAdapter.diffNotifydatasetchanged();

    }

    private LoadMoreView getLoadMoreView() {
        return new LoadMoreView().setProgressColor(R.color.dracula_album_dropdown_thumbnail_placeholder);
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                goToAcitivty(TestActivity.class);
                mAdapter.notifyDataSetChanged();
                mAdapter.canLoadMore(true);
                break;
            case R.id.btn_2:
                mAdapter.add(new TestaViewModel(123));
//                mAdapter.diffNotifydatasetchanged();
//                mAdapter.canLoadMore(false);
                break;
            case R.id.btn_3:
                mAdapter.getDatas().clear();
                mAdapter.diffNotifydatasetchanged();
                break;
        }
    }


}
