package com.lsj.colaman.quickproject.common.view;

import android.support.v4.content.ContextCompat;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseLoadmoreVModel;
import com.lsj.colaman.quickproject.base.BaseViewHolder;

import androidx.annotation.ColorRes;

/**
 * Create by kyle on 2019/1/22
 * Function : 通用底部loadmore，包含一个progressbar以及提示
 */
public class LoadMoreView extends BaseLoadmoreVModel {

    private String mSuccessTips;
    private String mLoadingTips;
    private String mFailedTips;
    @ColorRes
    private int mProgressColor = R.color.colorAccent;


    @Override
    public int getLayoutRes() {
        return R.layout.item_loadmore;
    }

    @Override
    protected void onBindView(BaseViewHolder holder) {
        ((ColorProgressBar) holder.getView(R.id.loading_progress)).setProgressColor(ContextCompat.getColor(holder.getContext(), mProgressColor));
    }

    @Override
    public void onViewAttached() {
        super.onViewAttached();
    }

    @Override
    public void OnStartLoadMore() {
        getViewHolder().setText(R.id.tv_status, mLoadingTips);
    }

    @Override
    public void OnLoadMoreFailed() {
        getViewHolder().setText(R.id.tv_status, mFailedTips);
    }

    @Override
    public void OnLoadMoreSuccess() {
        getViewHolder().setText(R.id.tv_status, mSuccessTips);
    }

    public LoadMoreView setSuccessTips(String tips) {
        mSuccessTips = tips;
        return this;
    }

    public LoadMoreView setLoadingTips(String tips) {
        mLoadingTips = tips;
        return this;
    }

    public LoadMoreView setFailedTips(String tips) {
        mFailedTips = tips;
        return this;
    }

    public LoadMoreView setProgressColor(@ColorRes int color) {
        mProgressColor = color;
        return this;
    }
}
