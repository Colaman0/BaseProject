package com.lsj.colaman.quickproject.sample;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.RecyclerViewModel;
import com.lsj.colaman.quickproject.common.imp.IDiffComparator;

import java.util.function.IntToDoubleFunction;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public class DiffViewModel extends RecyclerViewModel implements IDiffComparator<DiffViewModel> {

    private final int mI;

    public DiffViewModel(int i) {
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
    }

    @Override
    public void onViewAttached() {
        super.onViewAttached();
    }

    public void onViewDetached() {
        super.onViewDetached();
    }

    @Override
    public boolean isSameData(DiffViewModel diffViewModel) {
        return mI == diffViewModel.mI;
    }
}
