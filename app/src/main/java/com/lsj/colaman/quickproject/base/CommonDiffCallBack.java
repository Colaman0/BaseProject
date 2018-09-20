package com.lsj.colaman.quickproject.base;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Create by kyle on 2018/9/3
 * Function : 通用的diffutilzh
 */
public class CommonDiffCallBack<T extends Comparator> extends DiffUtil.Callback {
    List<T> oldDatas;
    List<T> newDatas;

    public CommonDiffCallBack(List<T> oldDatas, List<T> newDatas) {
        this.oldDatas = oldDatas;
        this.newDatas = newDatas;
    }

    @Override
    public int getOldListSize() {
        return oldDatas == null ? 0 : oldDatas.size();
    }

    @Override
    public int getNewListSize() {
        return newDatas == null ? 0 : newDatas.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        T oldData = oldDatas.get(oldItemPosition);
        T newData = newDatas.get(newItemPosition);
        return oldData.judgmentKey().equals(newData.judgmentKey());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        T oldData = oldDatas.get(oldItemPosition);
        T newData = newDatas.get(newItemPosition);
        return oldData.equals(newData);
    }
}
