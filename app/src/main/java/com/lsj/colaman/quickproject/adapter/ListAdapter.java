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

    public ListAdapter(Context context) {
        super(context);
    }

    public void add(RecyclerViewModel viewModel) {
        getDatas().add(viewModel);
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
        getDatas().remove(viewModel);
    }

    public void remove(int index) {
        getDatas().remove(index);
    }

    public void clear() {
        getDatas().clear();
    }

}
