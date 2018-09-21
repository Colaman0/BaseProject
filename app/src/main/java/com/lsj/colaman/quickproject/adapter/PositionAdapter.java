package com.lsj.colaman.quickproject.adapter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsj.colaman.quickproject.Data;
import com.lsj.colaman.quickproject.DataRight;
import com.lsj.colaman.quickproject.MultiData;
import com.lsj.colaman.quickproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by kyle on 2018/9/20
 * Function :
 */
public class PositionAdapter extends BaseMultiItemQuickAdapter<MultiData, BaseViewHolder> {

    private List<MultiData> mDatas = new ArrayList<>();

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public PositionAdapter(List<MultiData> data) {
        super(data);
        addItemType(1, R.layout.item_text);
        addItemType(2, R.layout.item_text_right);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        Log.d("cola", "bind " + position);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiData item) {
        if (helper.getItemViewType() == 2) {
            helper.setText(R.id.text, "position = " + helper.getLayoutPosition() + "  内容=" + ((DataRight) item).className)
                    .addOnClickListener(R.id.text);
        } else {
            helper.setText(R.id.text, "position = " + helper.getLayoutPosition() + "  内容=" + ((Data) item).id)
                    .addOnClickListener(R.id.text);
        }
    }


    @NonNull
    @Override
    public List<MultiData> getData() {
        return mDatas;
    }

    public void setData(List<MultiData> datas) {
        mDatas.clear();
        mDatas.addAll(datas);
    }
}
