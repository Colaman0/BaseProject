package com.lsj.colaman.quickproject.common.imp;

import com.lsj.colaman.quickproject.common.rx.RxData;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/3/2
 *     desc   : 作为rxjava以及livadata之间的抽象关系，方便后续如果不用livedata用其他方法发射数据
 *     function : 1.有rxjava常规的几个方法
 *                2.能和view层进行通信，把rxjava发射过来的数据转换成通用的数据格式 (RxData)
 *
 * </pre>
 */
public interface IRxData<T> extends IRxConsumer<T> {
    /**
     * 发送数据给view层
     *
     * @param data
     */
    void postData(RxData<T> data);
}
