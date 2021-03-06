package com.lsj.colaman.quickproject.common.rx;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.lsj.colaman.quickproject.common.imp.IRxObserverLife;


/**
 * <pre>
 *     author : kyle
 *     time   : 2019/3/4
 *     desc   : 增加观察者的start/end，作为涉及到UI或者其他需要开始/结束操作的基类，比如Loading的显示，toast的提示
 * </pre>
 */
public abstract class RxUIConsumer<T> extends RxConsumer<T> implements IRxObserverLife {
    private AppCompatActivity mActivity;
    private Lifecycle mLifecycle;

    public RxUIConsumer(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onUnsucrible() {
        super.onUnsucrible();
        if (isActive()) {
            onEnd(mActivity);
        }
    }

    @Override
    public void onSucrible() {
        super.onSucrible();
        if (isActive()) {
            onStart(mActivity);
        }
    }

    /**
     * 判断activity是否还活跃
     *
     * @return
     */
    private boolean isActive() {
        return mActivity != null && mActivity.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.DESTROYED);
    }

    public void onStart(Context context) {
    }


    public void onEnd(Context context) {
    }
}
