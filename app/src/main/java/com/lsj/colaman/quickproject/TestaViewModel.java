package com.lsj.colaman.quickproject;

import android.util.Log;
import android.widget.TextView;

import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.RecyclerViewModel;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public class TestaViewModel extends RecyclerViewModel {

    private final int mI;

    public TestaViewModel(int i) {
        mI = i;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_text_right;
    }

    public void bindView(BaseViewHolder holder) {
        super.bindView(holder);
        ((TextView) holder.getView(R.id.text)).setText("right" + String.valueOf(mI));
    }

    @Override
    public void onItemClick() {
        super.onItemClick();
        Log.d("cola", "viewmodel =" + mI);
    }

    @Override
    public void onViewAttached() {
        super.onViewAttached();
    }

    public void onViewDetached() {
        super.onViewDetached();
    }
}
