package com.lsj.colaman.quickproject.common.imp;

/**
 * Create by kyle on 2019/1/21
 * Function : loadmore接口，表明loamoreview的状态
 */
public interface ILoadMore {
    public static final int LOADMORE = 1;

    void OnLoadMore();

    void OnLoadMoreFailed();

    void OnLoadMoreSuccess();

    boolean isLoading();

    void setLoading(boolean isLoading);
}
