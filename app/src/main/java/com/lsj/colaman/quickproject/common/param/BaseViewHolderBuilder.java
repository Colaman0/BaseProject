package com.lsj.colaman.quickproject.common.param;

import android.content.Context;
import android.support.v4.util.Consumer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsj.colaman.quickproject.base.BaseViewHolder;

/**
 * Create by kyle on 2019/1/6
 * Function : 构建baseviewholder所需要的参数
 */
public class BaseViewHolderBuilder {
    private Context mContext;
    private ViewGroup mViewGroup;
    private int mLayoutId;
    private View mItemView;
    private Consumer<BaseViewHolder> mItemClickConsumer;


    public BaseViewHolderBuilder(Context context, ViewGroup viewGroup, int layoutId) {
        mContext = context;
        mViewGroup = viewGroup;
        mLayoutId = layoutId;
    }

    public Context getContext() {
        return mContext;
    }

    public BaseViewHolderBuilder setContext(Context context) {
        mContext = context;
        return this;
    }

    public ViewGroup getViewGroup() {
        return mViewGroup;
    }

    public BaseViewHolderBuilder setViewGroup(ViewGroup viewGroup) {
        mViewGroup = viewGroup;
        return this;
    }

    public int getLayoutId() {
        return mLayoutId;
    }

    public BaseViewHolderBuilder setLayoutId(int layoutId) {
        mLayoutId = layoutId;
        return this;
    }

    public View getItemView() {
        return mItemView;
    }

    public BaseViewHolderBuilder setItemView(View itemView) {
        mItemView = itemView;
        return this;
    }

    public BaseViewHolder build() {
        if (getContext() != null) {
            setItemView(LayoutInflater.from(getContext()).inflate(getLayoutId(), getViewGroup(), false));
        }
        return new BaseViewHolder(this);
    }

    public Consumer<BaseViewHolder> getItemClickConsumer() {
        return mItemClickConsumer;
    }

    public BaseViewHolderBuilder setItemClickConsumer(Consumer<BaseViewHolder> itemClickConsumer) {
        mItemClickConsumer = itemClickConsumer;
        return this;
    }
}
