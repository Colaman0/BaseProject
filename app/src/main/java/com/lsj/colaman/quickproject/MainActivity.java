package com.lsj.colaman.quickproject;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lsj.colaman.quickproject.adapter.PositionAdapter;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.base.CommonDiffCallBack;
import com.lsj.colaman.quickproject.test.Data;
import com.lsj.colaman.quickproject.test.DataRight;
import com.lsj.colaman.quickproject.test.MultiData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshlayout)
    SwipeRefreshLayout refreshlayout;

    private PositionAdapter mAdapter;
    private List<MultiData> mData = new ArrayList<>();

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        add();
        refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                add();
            }
        });
        mAdapter = new PositionAdapter(mData);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                mData.remove(position);
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CommonDiffCallBack<>(mAdapter.getData(), mData));
                diffResult.dispatchUpdatesTo(mAdapter);
                mAdapter.setData(mData);
            }
        });
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                load();
            }
        });
        mAdapter.setStartUpFetchPosition(0);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerview.setAdapter(mAdapter);
    }

    @SuppressLint("CheckResult")
    private void add() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(1)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mData.clear();
                        for (int i = 0; i < 10; i++) {
                            if (i % 2 == 0) {
                                mData.add(new Data(String.valueOf(mData.size())));
                            } else {
                                mData.add(new DataRight(String.valueOf(mData.size())));

                            }
                        }
                        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CommonDiffCallBack<>(mAdapter.getData(), mData));
                        diffResult.dispatchUpdatesTo(mAdapter);
                        refreshlayout.setRefreshing(false);
                        mAdapter.setData(mData);
                        mAdapter.setEnableLoadMore(true);
                    }
                });
    }

    @SuppressLint("CheckResult")
    private void load() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(1)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        for (int i = 0; i < 10; i++) {
                            if (i % 2 == 0) {
                                mData.add(new Data(String.valueOf(mData.size())));
                            } else {
                                mData.add(new DataRight(String.valueOf(mData.size())));
                            }
                        }
                        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CommonDiffCallBack<>(mAdapter.getData(), mData));
                        diffResult.dispatchUpdatesTo(mAdapter);
                        mAdapter.setData(mData);
                        mAdapter.loadMoreComplete();
                    }
                });
    }

    @Override
    protected int setStatusBarColor() {
        return R.color.colorAccent;
    }
}
