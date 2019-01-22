package com.lsj.colaman.quickproject.base;

import com.lsj.colaman.quickproject.common.imp.ILoadMore;

/**
 * Create by kyle on 2019/1/21
 * Function :
 */
public abstract class BaseLoadmoreVModel extends RecyclerViewModel implements ILoadMore {
    private boolean mLoading = false;
    private BaseViewHolder mViewHolder;

    @Override
    public boolean isSameData(Object o) {
        return true;
    }

    @Override
    public void bindView(BaseViewHolder holder) {
        super.bindView(holder);
        mViewHolder = holder;
    }

    public BaseViewHolder getViewHolder() {
        return mViewHolder;
    }

    @Override
    public boolean isLoading() {
        return mLoading;
    }

    @Override
    public void setLoading(boolean isLoading) {
        mLoading = isLoading;
    }
}
