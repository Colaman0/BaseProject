package com.lsj.colaman.quickproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.BaseViewModel;
import com.lsj.colaman.quickproject.base.CommonDiffCallBack;
import com.lsj.colaman.quickproject.common.helper.GlideImageLoader;
import com.lsj.colaman.quickproject.common.imp.IImageLoad;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by kyle on 2019/1/8
 * Function : 带有diffutil刷新的adapter
 */
public class FeaturesAdapter extends ListAdapter<FeaturesAdapter> {
    private IImageLoad mIImageLoad;
    private List<BaseViewModel> oldDatas = new ArrayList<>();

    public FeaturesAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder getHolder(Context context, ViewGroup viewGroup, int itemType) {
        return getDefaultBuilder(context, viewGroup, itemType)
                .setImageLoader(getIImageLoad())
                .build();
    }

    @SuppressLint("CheckResult")
    public void diffNotifydatasetchanged() {
        // TODO: 2019/1/8 加入生命周期的监听 autodisposable
        Observable.just("")
                .subscribeOn(Schedulers.computation())
                .map(s -> DiffUtil.calculateDiff(getDiffCallback(), false))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(diffResult -> diffResult.dispatchUpdatesTo(FeaturesAdapter.this))
                .doOnComplete(() -> {
                    oldDatas.clear();
                    oldDatas.addAll(getDatas());
                })
                .subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
    }

    private DiffUtil.Callback getDiffCallback() {
        return new CommonDiffCallBack(oldDatas, getDatas());
    }

    /**
     * 设置图片加载类
     *
     * @param imageLoader
     * @return
     */
    public FeaturesAdapter setImageLoader(IImageLoad imageLoader) {
        mIImageLoad = imageLoader == null ? getDefaultImageLoader() : imageLoader;
        return this;
    }

    public IImageLoad getIImageLoad() {
        return mIImageLoad;
    }

    /**
     * 默认用Glide加载图片
     *
     * @return
     */
    protected IImageLoad getDefaultImageLoader() {
        return GlideImageLoader.getInstance();
    }
}
