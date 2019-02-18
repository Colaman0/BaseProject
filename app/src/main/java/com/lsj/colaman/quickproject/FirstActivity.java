package com.lsj.colaman.quickproject;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.lsj.colaman.quickproject.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

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
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                goToAcitivty(BottomTabActivity.class);
            }
        };
        new Timer().schedule(timerTask, 2*1000 );
    }
}
