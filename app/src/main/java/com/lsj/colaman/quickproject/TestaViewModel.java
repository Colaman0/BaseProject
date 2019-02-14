package com.lsj.colaman.quickproject;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.RecyclerViewModel;
import com.lsj.colaman.quickproject.common.helper.AnimationHelper;

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
        TextView view = (TextView) holder.getView(R.id.text);
        view.setText("right" + String.valueOf(mI));

    }

    @Override
    protected void onBindView(BaseViewHolder holder) {

    }

    @Override
    public void onItemClick() {
        super.onItemClick();
        AnimationHelper.scrollY(10,getViewHolder().getView(R.id.text),200);
    }

    @Override
    public void onViewAttached() {
        super.onViewAttached();
    }

    public void onViewDetached() {
        super.onViewDetached();
    }

    @Override
    public boolean isSameData(Object o) {
        return false;
    }
}
