package com.lsj.colaman.quickproject.common.imp;

import android.content.Context;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/3/4
 *     desc   : 规范observer的开始以及结束
 * </pre>
 */
public interface IRxObserverLife {
    void onStart(Context context);

    void onEnd(Context context);
}
