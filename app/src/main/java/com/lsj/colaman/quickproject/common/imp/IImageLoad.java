package com.lsj.colaman.quickproject.common.imp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.lsj.colaman.quickproject.base.ImageLoaderConfig;

import io.reactivex.Observable;

/**
 * Create by kyle on 2019/1/7
 * Function : 图片加载框架的接口规范
 */
public interface IImageLoad {
    void loadImage(Context context, String url, ImageView imageView);

    void loadImage(Context context, String url, ImageView imageView, @DrawableRes int loadingRes, @DrawableRes int errorRes);

    void loadCircleImage(Context context, String url, ImageView imageView);

    Observable<Bitmap> downLoadBitmap(Context context, final String source);

    void loadImage(Context context, String url, ImageView imageView, ImageLoaderConfig config);

}
