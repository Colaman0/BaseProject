package com.lsj.colaman.quickproject.test;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.base.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

public class ImageActivity extends BaseActivity {


    @BindView(R.id.imageview)
    ImageView imageview;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_image;
    }

    @Override
    @SuppressLint("CheckResult")
    protected void initView() {
        ImageLoader.getInstance().downLoadBitmap(this,"https://pic2.zhimg.com/80/v2-fbbb97b977b5cebc66dc3cefab0ac981_hd.jpg")
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap bitmap) throws Exception {
                        imageview.setImageBitmap(bitmap);
                    }
                });
    }
}
