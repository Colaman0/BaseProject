package com.lsj.colaman.quickproject.adapter;

import android.content.Context;

import com.lsj.colaman.quickproject.base.RecyclerViewModel;

import java.util.Collection;

/**
 * Create by kyle on 2019/1/9
 * Function : 操作数据源的adapter
 */
public class ListAdapter<T extends BaseAdapter> extends BaseAdapter<T> {

    public ListAdapter(Context context) {
        super(context);
    }

    public int size() {
        return getDatas().size();
    }

    public RecyclerViewModel get(int index) {
        return getDatas().get(index);
    }

    public void add(RecyclerViewModel viewModel) {
        if (canHandleData()) {
            getDatas().add(viewModel);
        } else {
            getRecyclerView().post(() -> getDatas().add(viewModel));
        }
    }

    public void add(int index, RecyclerViewModel viewModel) {
        getDatas().add(index, viewModel);
    }

    public void addAll(Collection<RecyclerViewModel> list) {
        getDatas().addAll(list);
    }

    public void addAll(int index, Collection<RecyclerViewModel> list) {
        getDatas().addAll(index, list);
    }

    public void remove(RecyclerViewModel viewModel) {
        if (canHandleData()) {
            getDatas().remove(viewModel);
        } else {
            getRecyclerView().post(() -> getDatas().remove(viewModel));
        }
    }

    public void remove(int index) {
        if (canHandleData()) {
            getDatas().remove(index);
        } else {
            getRecyclerView().post(() -> getDatas().remove(index));
        }
    }

    public void clear() {
        if (canHandleData()) {
            getDatas().clear();
        } else {
            getRecyclerView().post(() -> getDatas().clear());
        }
    }

    private boolean canHandleData() {
        return !getRecyclerView().isComputingLayout();
    }

}
