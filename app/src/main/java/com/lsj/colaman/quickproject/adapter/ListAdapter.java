package com.lsj.colaman.quickproject.adapter;

import android.content.Context;

import com.lsj.colaman.quickproject.base.RecyclerViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Create by kyle on 2019/1/9
 * Function : 操作数据源的adapter
 */
public class ListAdapter<T extends BaseAdapter> extends BaseAdapter<T> {
    private List<RecyclerViewModel> mDatas = new ArrayList<>();

    public ListAdapter(Context context) {
        super(context);
    }


    public List<RecyclerViewModel> getDatas() {
        return mDatas;
    }

    public void add(RecyclerViewModel viewModel) {
        mDatas.add(viewModel);
    }

    public void add(int index, RecyclerViewModel viewModel) {
        mDatas.add(index, viewModel);
    }

    public void addAll(Collection<RecyclerViewModel> list) {
        mDatas.addAll(list);
    }

    public void addAll(int index, Collection<RecyclerViewModel> list) {
        mDatas.addAll(index, list);
    }

    public void remove(RecyclerViewModel viewModel) {
        mDatas.remove(viewModel);
    }

    public void remove(int index) {
        mDatas.remove(index);
    }

    public void clear() {
        mDatas.clear();
    }

}
