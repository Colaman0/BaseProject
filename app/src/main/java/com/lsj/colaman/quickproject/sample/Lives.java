package com.lsj.colaman.quickproject.sample;

import com.lsj.colaman.quickproject.common.rx.RxLife;
import com.lsj.colaman.quickproject.common.rx.RxLivedata;
import com.lsj.colaman.quickproject.common.rx.RxObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/3/2
 *     desc   :
 * </pre>
 */
public class Lives {
    static RxLivedata<Long> mLongRxLivedata = new RxLivedata<>();


    public static RxLivedata<Long> getLiveData() {
        return mLongRxLivedata;
    }

    public static void start() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return aLong*10;
                    }
                })
                .compose(RxLife.bindLiveData(mLongRxLivedata))
                .subscribe(new RxObserver<>());

    }
}
