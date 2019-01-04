package com.lsj.colaman.quickproject.rx;


import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import androidx.lifecycle.LifecycleOwner;

/**
 * Create by kyle on 2018/12/25
 * Function : 绑定生命周期相关
 */
public class RxLife {
    private RxLife() {

    }

    public static <T> AutoDisposeConverter<T> bindLife(LifecycleOwner lifecycleOwner) {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner));
    }
}
