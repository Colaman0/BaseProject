package com.lsj.colaman.quickproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lsj.colaman.quickproject.base.BaseLoadmoreVModel;
import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.BaseViewModel;
import com.lsj.colaman.quickproject.base.CommonDiffCallBack;
import com.lsj.colaman.quickproject.common.helper.GlideImageLoader;
import com.lsj.colaman.quickproject.common.imp.IImageLoad;
import com.lsj.colaman.quickproject.common.imp.ILoadMore;

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
    // 是否开始loadmore的标记
    private boolean mDisableLoadmore = false;
    private BaseLoadmoreVModel mILoadMore;

    public FeaturesAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder getHolder(Context context, ViewGroup viewGroup, int itemType) {
        return getDefaultBuilder(context, viewGroup, itemType)
                .setImageLoader(getIImageLoad())
                .build();
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoadmoreVisible(position)) {
            return getLoadMoreView().getLayoutRes();
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        return super.onCreateViewHolder(viewGroup, itemType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (isLoadmoreVisible(position)) {
            getLoadMoreView().bindView((BaseViewHolder) viewHolder);
            getLoadMoreView().bindLife(getLifeCycle());
            if (!getLoadMoreView().isLoading()) {
                getLoadMoreView().OnStartLoadMore();
                getLoadMoreView().setLoading(true);
            }
        } else {
            super.onBindViewHolder(viewHolder, position);
        }
    }

    @Override
    public int getItemCount() {
        return getDatas().size() + (mDisableLoadmore ? 1 : 0);
    }

    public void handleAdapterResult() {
        handleAdapterResult(true);
    }

    public void handleAdapterResult(boolean isSuccess) {
        handleLoadmoreStatus(isSuccess);
    }

    public void handleLoadmoreStatus(boolean success) {
        if (mDisableLoadmore == false) {
            return;
        }
        getLoadMoreView().setLoading(false);
        if (success) {
            getLoadMoreView().OnLoadMoreSuccess();
        } else {
            getLoadMoreView().OnLoadMoreFailed();
        }
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
     * insert/remove掉loadmoreviewmodel
     */
    private void switchLoadMore() {
        if (mDisableLoadmore) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
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

    private BaseLoadmoreVModel getLoadMoreView() {
        if (mILoadMore == null) {

        }
        return mILoadMore;
    }

    public FeaturesAdapter setLoadMoreView(BaseLoadmoreVModel loadMoreView) {
        if (loadMoreView == null) {
            throw new RuntimeException("loadmore viewmodel can not be null");
        }
        mDisableLoadmore = true;
        mILoadMore = loadMoreView;
        return this;
    }

    /**
     * 是否开启loadmore
     *
     * @param disableLoadmore 是否允许loadmore
     */
    public void canLoadMore(boolean disableLoadmore) {
        if (disableLoadmore != mDisableLoadmore) {
            mDisableLoadmore = disableLoadmore;
            // 避免异步处理数据的时候抛出异常
            getRecyclerView().post(this::switchLoadMore);
        }
    }

    /**
     * 判断loadmore的item是否允许显示
     *
     * @param position
     * @return
     */
    private boolean isLoadmoreVisible(int position) {
        return position == getItemCount() - 1 && mDisableLoadmore;
    }
}
