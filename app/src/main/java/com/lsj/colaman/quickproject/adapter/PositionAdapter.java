package com.lsj.colaman.quickproject.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsj.colaman.quickproject.Info;
import com.lsj.colaman.quickproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by kyle on 2018/9/20
 * Function :
 */
public class PositionAdapter extends BaseQuickAdapter<Info, BaseViewHolder> {

    private List<Info> mData = new ArrayList<>();

    public PositionAdapter(int layoutResId, @Nullable List<Info> data) {
        super(layoutResId, data);
        mData.addAll(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Info item) {
        helper.setText(R.id.text, "position = " + helper.getLayoutPosition() + "  内容=" + item.id)
                .addOnClickListener(R.id.text);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }



    @NonNull
    @Override
    public List<Info> getData() {
        return mData;
    }
}
