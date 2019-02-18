package com.lsj.colaman.quickproject.sample;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.common.view.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxjavaActivity extends BaseActivity {


    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_rxjava;
    }

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


    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                LivedataCreater.getInstance().sendData1();
                break;
            case R.id.btn_2:
                LivedataCreater.getInstance().sendData2();
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                goToAcitivty(DiffActivity.class);
                break;
        }
    }
}
