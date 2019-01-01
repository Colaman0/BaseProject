package com.lsj.colaman.quickproject.base;

import android.arch.lifecycle.Lifecycle;
import android.util.Log;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public abstract class RecyclerViewModel extends BaseViewModel {
    public abstract int getLayoutRes();

    public void bindView(BaseViewHolder holder) {
        if (holder != null && holder.getConvertView() != null) {
            holder.getConvertView().setTag(this);
        }
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
}
