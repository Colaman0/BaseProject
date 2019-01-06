package com.lsj.colaman.quickproject.base;

import android.arch.lifecycle.Lifecycle;
import android.util.Log;
import android.view.View;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public abstract class RecyclerViewModel extends BaseViewModel {

    private BaseViewHolder mHolder;

    public abstract int getLayoutRes();

    public void bindView(BaseViewHolder holder) {
        mHolder = holder;
        if (holder != null && holder.getConvertView() != null) {
            holder.getConvertView().setTag(this);
        }
    }

    /**
     * 获取viewmodel的根view
     * @return
     */
    public View getConvertView() {
        if (mHolder == null) {
            return null;
        }
        return mHolder.getConvertView();
    }


    @Override
    public void bindLife(Lifecycle lifecycle) {
        if (getLifecycle() != null) {
            return;
        }
        super.bindLife(lifecycle);
    }

    public void onViewAttached() {
    }

    public void onViewDetached() {
    }

    public void onItemClick() {

    }
}
