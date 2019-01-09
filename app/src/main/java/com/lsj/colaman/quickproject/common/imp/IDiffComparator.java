package com.lsj.colaman.quickproject.common.imp;

/**
 * Create by kyle on 2019/1/8
 * Function : diffutil比较接口，recyclerview的item的item实现这个接口，判断是否需要刷新
 */
public interface IDiffComparator<T> {
    boolean isSameData(T t);
}
