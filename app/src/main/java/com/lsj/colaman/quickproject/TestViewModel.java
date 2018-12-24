package com.lsj.colaman.quickproject;

import android.app.Activity;
import android.widget.TextView;

import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.RecyclerViewModel;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public class TestViewModel extends RecyclerViewModel {

    private int mI;
    private final Activity mActivity;

    public TestViewModel(Activity activity, int i) {
        mI = i;
        mActivity = activity;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_text;
    }

    @Override
    public void bindView(BaseViewHolder holder) {
        ((TextView) holder.getView(R.id.text)).setText(String.valueOf(mI));
    }
}
