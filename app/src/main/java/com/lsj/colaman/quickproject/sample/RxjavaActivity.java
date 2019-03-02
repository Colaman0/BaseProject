package com.lsj.colaman.quickproject.sample;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lsj.colaman.quickproject.FirstActivity;
import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.common.rx.RxConsumer;
import com.lsj.colaman.quickproject.common.view.TitleBar;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableEmitter;

public class RxjavaActivity extends BaseActivity {


    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    private ObservableEmitter<String> mEmitter;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_rxjava;
    }

    @SuppressLint("AutoDispose")
    @Override
    protected void initView() {
        LivedataCreater.getInstance().getLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                Log.d("cola", "发射 = " + integer);
            }
        });
        LivedataCreater.getInstance().sendData3();
        ((TitleBar) findViewById(R.id.title)).addViewToRight(TitleBar.getIconView(getContext(), R.mipmap.ic_launcher, null));
        ((TitleBar) findViewById(R.id.title)).addViewToRight(TitleBar.getTextView(getContext(), "保存", null));
        MutableLiveData<Long>  liveData = new MutableLiveData<>();
        Lives.getLiveData().observe(this, new RxConsumer<Long>() {
            @Override
            public void onComplete() {
                super.onComplete();
                Log.d("abc", "rxjavaActivity = " + "onComplete");
            }

            @Override
            public void onUnsucrible() {
                super.onUnsucrible();
                Log.d("abc", "rxjavaActivity = " + "onUnsucrible");

            }

            @Override
            public void onNext(Long aLong) {
                if (aLong == 5) {
                    goToAcitivty(FirstActivity.class);
                }
                Log.d("abc", "rxjavaActivity = " + String.valueOf(aLong));
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("abc", "rxjavaActivity  error = " + throwable.getMessage());
            }
        });
        Lives.start();
    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                break;
            case R.id.btn_2:
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:

                break;
        }
    }
}
