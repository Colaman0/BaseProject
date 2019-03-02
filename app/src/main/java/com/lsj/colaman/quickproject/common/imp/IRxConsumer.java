package com.lsj.colaman.quickproject.common.imp;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/3/2
 *     desc   : livedata和rxjava联动中共有处理的几个方法，让view层有跟rxjava相同的回调，
 *              但是实际数据是从livedata处理过后发射出来的
 * </pre>
 */
public interface IRxConsumer<T> {
    /**
     * 四个方法都是给网络请求返回的observable调用
     *
     * @param t
     */
    void onNext(T t);

    void onError(Throwable throwable);

    void onComplete();

    void onUnsucrible();
}
