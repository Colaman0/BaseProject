package com.lsj.colaman.quickproject.common.rx;

import android.arch.lifecycle.MutableLiveData;

import com.lsj.colaman.quickproject.common.imp.IRxData;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/3/2
 *     desc   : 实现了IRxData，负责把网络请求的observable数据封装状态，通过livedata发射出去
 * </pre>
 */
public class RxLivedata<T> extends MutableLiveData<RxData<T>> implements IRxData<T> {

    @Override
    public void onNext(T t) {
        postData(new RxData<>(t));
    }

    @Override
    public void onError(Throwable throwable) {
        postData(new RxData<>(throwable));
    }

    @Override
    public void onComplete() {
        postData(new RxData<>(RxData.STATUS.COMPLETE));
    }

    @Override
    public void onUnsucrible() {
        postData(new RxData<>(RxData.STATUS.UNSUSCRIBE));
    }

    @Override
    public void postData(RxData<T> data) {
        if (data != null) {
            setValue(data);
        }
    }
}
