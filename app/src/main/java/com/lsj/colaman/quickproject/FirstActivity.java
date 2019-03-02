package com.lsj.colaman.quickproject;

import android.util.Log;

import com.blankj.utilcode.util.ScreenUtils;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.common.rx.RxConsumer;
import com.lsj.colaman.quickproject.sample.Lives;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/2/18
 *     desc   :
 * </pre>
 */
public class FirstActivity extends BaseActivity {
    @Override
    protected int initLayoutRes() {
        return R.layout.activity_first;
    }

    @Override
    protected void initView() {
        ScreenUtils.setFullScreen(this);
        Lives.getLiveData().observe(this, new RxConsumer<Long>() {
            @Override
            public void onComplete() {
                super.onComplete();
                Log.d("abc", "FirstActivity = " + "onComplete");
            }

            @Override
            public void onUnsucrible() {
                super.onUnsucrible();
                Log.d("abc", "FirstActivity = " + "onUnsucrible");

            }

            @Override
            public void onNext(Long aLong) {
                Log.d("abc", "FirstActivity = " + String.valueOf(aLong));
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("abc", "FirstActivity  error = " + throwable.getMessage());
            }
        });
    }
}
