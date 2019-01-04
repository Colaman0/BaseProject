package com.lsj.colaman.quickproject.adapter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.lsj.colaman.quickproject.base.BaseViewHolder;
import com.lsj.colaman.quickproject.base.RecyclerViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Create by kyle on 2018/12/24
 * Function :
 */
public class BaseAdapter extends RecyclerView.Adapter {
    private Lifecycle mLifeCycle;
    private List<RecyclerViewModel> mDatas = new ArrayList<>();
    private Context mContext;
    private SparseArray<Integer> itemViews = new SparseArray<>();
    private RecyclerView mRecyclerView;

    public BaseAdapter(Context context) {
        this(Collections.<RecyclerViewModel>emptyList(), context);
    }

    public BaseAdapter(List<RecyclerViewModel> datas, Context context) {
        mDatas.addAll(datas);
        mContext = context;
        if (mContext instanceof LifecycleOwner) {
            mLifeCycle = ((LifecycleOwner) mContext).getLifecycle();
        }
    }

    private void initConfig() {
        handleRecyclerViewScroll();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        return BaseViewHolder.get(mContext, viewGroup, itemType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (i < 0 || i >= mDatas.size()) {
            return;
        }
        if (viewHolder instanceof BaseViewHolder) {
            RecyclerViewModel recyclerViewModel = mDatas.get(i);
            recyclerViewModel.bindView((BaseViewHolder) viewHolder);
            recyclerViewModel.bindLife(mLifeCycle);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 0 || position >= mDatas.size()) {
            return 0;
        }
        return mDatas.get(position).getLayoutRes();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public List<RecyclerViewModel> getDatas() {
        return mDatas;
    }

    public void add(RecyclerViewModel viewModel) {
        mDatas.add(viewModel);
    }

    public void remove(RecyclerViewModel viewModel) {
        mDatas.remove(viewModel);
    }

    public Lifecycle getLifeCycle() {
        return mLifeCycle;
    }

    public BaseAdapter bindRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        initConfig();
        return this;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    /**
     * 处理recyclerview滑动相关
     */
    private void handleRecyclerViewScroll() {
        /**
         * 这里处理的是view的可见/不可见的回调，通过把recycleViewModel作为一个tag附着到view上，因为view是通用复用的
         * 所以通过bindView的时候，把recycleviewmodel作为tag set在viewholder上，然后再回调方法里，getTag
         * 就可以知道这个view对应哪个viewmodel
         */
        if (getRecyclerView() != null) {
            getRecyclerView().addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
                @Override
                public void onChildViewAttachedToWindow(@NonNull View view) {
                    if (view.getTag() instanceof RecyclerViewModel) {
                        ((RecyclerViewModel) view.getTag()).onViewAttached();
                    }
                }

                @Override
                public void onChildViewDetachedFromWindow(@NonNull View view) {
                    if (view.getTag() instanceof RecyclerViewModel) {
                        ((RecyclerViewModel) view.getTag()).onViewDetached();
                    }
                }
            });
        }
    }

}
