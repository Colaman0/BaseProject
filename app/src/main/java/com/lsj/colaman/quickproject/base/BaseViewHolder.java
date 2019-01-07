package com.lsj.colaman.quickproject.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsj.colaman.quickproject.common.helper.GlideImageLoader;
import com.lsj.colaman.quickproject.common.imp.IImageLoad;
import com.lsj.colaman.quickproject.common.param.BaseViewHolderBuilder;

/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final BaseViewHolderBuilder mBuilder;
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private ViewGroup mParent;
    private IImageLoad mImageLoader;

    public BaseViewHolder(BaseViewHolderBuilder builder) {
        super(builder.getItemView());
        mBuilder = builder;
        mContext = builder.getContext();
        mConvertView = builder.getItemView();
        mParent = builder.getViewGroup();
        mViews = new SparseArray<>();
        initConfig(builder);
    }

    private void initConfig(BaseViewHolderBuilder builder) {
        setItemClickListener();
    }

    /**
     * 设置item的点击事件
     */
    private void setItemClickListener() {
        // TODO: 2019/1/6 考虑优化一下点击的处理，这里直接设置点击事件，如果viewmodel对应也设置了点击事件无法回调了
        if (getConvertView() != null) {
            getConvertView().setOnClickListener(v -> {
                if (mBuilder != null && mBuilder.getItemClickConsumer() != null) {
                    mBuilder.getItemClickConsumer().accept(BaseViewHolder.this);
                }
            });
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 给textview设置内容
     *
     * @param id
     * @param text
     * @return
     */
    public BaseViewHolder setText(@IdRes int id, String text) {
        View view = getView(id);
        if (view instanceof TextView) {
            ((TextView) view).setText(text);
        }
        return this;
    }

    /**
     * imageview加载图片
     *
     * @param id
     * @param url 网络图片资源
     * @return
     */
    public BaseViewHolder loadImage(@IdRes int id, String url) {
        View view = getView(id);
        if (view instanceof ImageView) {
            getImageLoader().loadImage(getContext(), url, (ImageView) view);
        }
        return this;
    }

    /**
     * imageview加载圆形图片
     *
     * @param id
     * @param url 网络图片资源
     * @return
     */
    public BaseViewHolder loadCircleImage(@IdRes int id, String url) {
        View view = getView(id);
        if (view instanceof ImageView) {
            getImageLoader().loadCircleImage(getContext(), url, (ImageView) view);
        }
        return this;
    }

    /**
     * imageview加载圆形图片
     *
     * @param id
     * @param drawableRes 本地drawable资源
     * @return
     */
    public BaseViewHolder loadDrawable(@IdRes int id, @DrawableRes int drawableRes) {
        View view = getView(id);
        if (view instanceof ImageView) {
            getImageLoader().loadDrawable(getContext(), (ImageView) view, drawableRes);
        }
        return this;
    }

    /**
     * imageview加载圆形图片
     *
     * @param id
     * @param drawable drawable
     * @return
     */
    public BaseViewHolder loadDrawable(@IdRes int id, @NonNull Drawable drawable) {
        View view = getView(id);
        if (view instanceof ImageView) {
            getImageLoader().loadDrawable(getContext(), (ImageView) view, drawable);
        }
        return this;
    }


    /**
     * 获取默认的ImageLoader，如果项目需要替换图片加载框架，直接替换即可
     *
     * @return
     */
    private IImageLoad getImageLoader() {
        return GlideImageLoader.getInstance();
    }

    public Context getContext() {
        return mContext;
    }
}
