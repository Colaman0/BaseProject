package com.lsj.colaman.quickproject.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsj.colaman.quickproject.Data;
import com.lsj.colaman.quickproject.MultiData;
import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.CommonDiffCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by kyle on 2018/9/21
 * Function :
 */
public class SimpleAdapter extends BaseQuickAdapter<Data, BaseViewHolder> {
    private List<Data> mOldDatas = new ArrayList<>();

    public SimpleAdapter(int layoutResId, @Nullable List<Data> data) {
        super(layoutResId, data);
        mOldDatas.addAll(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final Data item) {
        helper.setText(R.id.text, item.id);
        helper.getView(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOldDatas.remove(item);
                updateUi();
            }
        });
    }

    public void updateUi(List<Data> datas) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CommonDiffCallBack<>(mOldDatas, datas));
        diffResult.dispatchUpdatesTo(this);
        getData().clear();
        getData().addAll(datas);
        mOldDatas.clear();
        mOldDatas.addAll(datas);
    }

    private void updateUi() {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CommonDiffCallBack<>(getData(), mOldDatas));
        diffResult.dispatchUpdatesTo(this);
        getData().clear();
        getData().addAll(mOldDatas);
    }
}
