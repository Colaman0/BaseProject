package com.lsj.colaman.quickproject.adapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsj.colaman.quickproject.test.Data;
import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.CommonDiffCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by kyle on 2018/9/21
 * Function :
 */
public class SimpleAdapter extends BaseQuickAdapter<Data, BaseViewHolder> {
    private List<Data> mDatas;

    public SimpleAdapter(int layoutResId, @Nullable List<Data> data) {
        super(layoutResId);
        mDatas = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, Data item) {
        final Data data = item;
        helper.setText(R.id.text, item.id);
        helper.getView(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData().remove(data);
                notifyDataSetChanged();
            }
        });
    }

    public void updateUi() {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CommonDiffCallBack<>(getData(), mDatas), false);
        diffResult.dispatchUpdatesTo(this);
        getData().clear();
        getData().addAll(mDatas);
    }
}
