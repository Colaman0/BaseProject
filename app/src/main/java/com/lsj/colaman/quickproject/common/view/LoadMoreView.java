package com.lsj.colaman.quickproject.common.view;

import android.util.Log;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseLoadmoreVModel;

/**
 * Create by kyle on 2019/1/22
 * Function :
 */
public class LoadMoreView extends BaseLoadmoreVModel {
    @Override
    public int getLayoutRes() {
        return R.layout.item_loadmore;
    }

    @Override
    public void OnLoadMore() {
        Log.d("cola", "loadmore");
        getViewHolder().setText(R.id.tv_status, "加载中");
    }

    @Override
    public void OnLoadMoreFailed() {
        Log.d("cola", "OnLoadMoreFailed");
        getViewHolder().setText(R.id.tv_status, "加载失败");
    }

    @Override
    public void OnLoadMoreSuccess() {
        Log.d("cola", "OnLoadMoreSuccess");
        getViewHolder().setText(R.id.tv_status, "加载成功");
    }


}
