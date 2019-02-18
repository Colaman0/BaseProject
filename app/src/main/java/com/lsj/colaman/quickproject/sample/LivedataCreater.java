package com.lsj.colaman.quickproject.sample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/2/16
 *     desc   :
 * </pre>
 */
public class LivedataCreater {
    public final MutableLiveData<Integer> mLiveData = new MutableLiveData<>();

    private LivedataCreater() {
    }

    public static LivedataCreater getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final LivedataCreater instance = new LivedataCreater();
    }

    public MutableLiveData<Integer> getLiveData() {
        return mLiveData;
    }

    public void sendData1() {
        Observable.just(1)
                .doOnNext(integer -> getLiveData().setValue(integer))
                .subscribe(Functions.emptyConsumer());
    }


    public void sendData2() {
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .take(5)
                .doOnNext(integer -> getLiveData().setValue((int) (integer/1)))
                .subscribe(Functions.emptyConsumer());
    }

    public void sendData3() {
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(integer -> getLiveData().setValue((int) (integer/1)))
                .subscribe(Functions.emptyConsumer());
    }
}
