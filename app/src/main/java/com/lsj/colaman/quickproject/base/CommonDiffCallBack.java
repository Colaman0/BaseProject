package com.lsj.colaman.quickproject.base;

import android.support.v7.util.DiffUtil;
import android.util.Log;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lsj.colaman.quickproject.test.Data;

import java.util.List;

/**
 * Create by kyle on 2018/9/3
 * Function : 通用的diffutilzh
 */
public class CommonDiffCallBack<T> extends DiffUtil.Callback {
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

    /**
     * 先判断是不是同一个class
     * 再判断是不是同一个type 如果是多类型布局可以instance of MultiItemEntity，再去判断type，
     * 如果是普通布局，就直接通过key去判断，一般来说根据id判断就可以
     *
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        T oldData = oldDatas.get(oldItemPosition);
        T newData = newDatas.get(newItemPosition);
        if (oldData.getClass() != newData.getClass()) {
            return false;
        }
        if (oldData instanceof MultiItemEntity) {
            return ((MultiItemEntity) oldData).getItemType() == ((MultiItemEntity) newData).getItemType();
        }
        if (oldData instanceof Comparator) {
            return ((Comparator) oldData).judgmentKey().equals(((Comparator) newData).judgmentKey());
        }
        return oldData.equals(newData);
    }

    /**
     * 这里直接用toString()来判断两个数据里的值是否相同，记得要重写toString()
     *
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        T oldData = oldDatas.get(oldItemPosition);
        T newData = newDatas.get(newItemPosition);
        if (oldData instanceof Data) {
            return ((Data) oldData).id.equals(((Data) newData).id);
        }
        return oldData.toString().equals(newData.toString());
    }
}
