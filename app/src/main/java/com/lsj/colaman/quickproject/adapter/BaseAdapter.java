package com.lsj.colaman.quickproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.RecyclerViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public class BaseAdapter extends RecyclerView.Adapter {

    private List<RecyclerViewModel> mDatas = new ArrayList<>();
    private Context mContext;
    private SparseArray<Integer> itemViews = new SparseArray<>();

    public BaseAdapter(Context context) {
        this(Collections.<RecyclerViewModel>emptyList(), context);
    }

    public BaseAdapter(List<RecyclerViewModel> datas, Context context) {
        mDatas.addAll(datas);
        mContext = context;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        Log.d("cola", "onDetachedFromRecyclerView");
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        Log.d("cola", "onAttachedToRecyclerView");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        return BaseViewHolder.get(mContext, viewGroup, itemType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (i < 0 || i >= mDatas.size()) {
            return;
        }
        if (viewHolder instanceof BaseViewHolder) {
            mDatas.get(i).bindView((BaseViewHolder) viewHolder);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 0 || position >= mDatas.size()) {
            return 0;
        }
        return mDatas.get(position).getLayoutRes();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public List<RecyclerViewModel> getDatas() {
        return mDatas;
    }

    public void add(RecyclerViewModel viewModel) {
        mDatas.add(viewModel);
    }

    public void remove(RecyclerViewModel viewModel) {
        mDatas.remove(viewModel);
    }
}
