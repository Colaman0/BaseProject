package com.lsj.colaman.quickproject.base;

import android.content.Context;
import android.hardware.camera2.params.OisSample;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.lsj.colaman.quickproject.common.imp.OnItemClickListener;
import com.lsj.colaman.quickproject.common.param.BaseViewHolderBuilder;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final BaseViewHolderBuilder mBuilder;
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private ViewGroup mParent;

    public BaseViewHolder(BaseViewHolderBuilder builder) {
        super(builder.getItemView());
        mBuilder = builder;
        mContext = builder.getContext();
        mConvertView = builder.getItemView();
        mParent = builder.getViewGroup();
        mViews = new SparseArray<>();
        initConfig(builder);
    }

    private void initConfig(BaseViewHolderBuilder builder) {
        setItemClickListener();
    }

    /**
     * 设置item的点击事件
     */
    private void setItemClickListener() {
        // TODO: 2019/1/6 考虑优化一下点击的处理，这里直接设置点击事件，如果viewmodel对应也设置了点击事件无法回调了
        if (getConvertView() != null) {
            getConvertView().setOnClickListener(v -> {
                if (mBuilder != null && mBuilder.getItemClickConsumer() != null) {
                    mBuilder.getItemClickConsumer().accept(BaseViewHolder.this);
                }
            });
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

}
