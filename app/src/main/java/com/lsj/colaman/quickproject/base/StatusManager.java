package com.lsj.colaman.quickproject.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.lsj.colaman.quickproject.Constants;
import com.lsj.colaman.quickproject.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by kyle on 2018/9/27
 * Function :
 */
public class StatusManager {
    private View mDataView;
    private ViewGroup mRootView;
    private Context mContext;
    private Map<String, View> mLayoutMap = new HashMap<>();
    private View mLastShowView;

    public StatusManager() {
    }

    public StatusManager init(Context context, @LayoutRes int layoutRes, @NonNull ViewGroup rootView) {
        mRootView = rootView;
        mContext = context;
        mDataView = LayoutInflater.from(context).inflate(layoutRes, mRootView, false);
        mRootView.addView(mDataView);
        mDataView.setVisibility(View.VISIBLE);
        mLayoutMap.put(Constants.STATUS_NORMAL, mDataView);
        mLastShowView = mDataView;
        return this;
    }

    public StatusManager add(String layoutType, @LayoutRes int layoutRes, boolean isDelayInflate) {
        if (isDelayInflate) {
            ViewStub viewStub = new ViewStub(mContext, layoutRes);
            add(layoutType, viewStub);
        } else {
            add(layoutType, LayoutInflater.from(mContext).inflate(layoutRes, mRootView, false));
        }
        return this;
    }

    public StatusManager add(String layoutType, View layoutView) {
        layoutView.setVisibility(View.GONE);
        mLayoutMap.put(layoutType, layoutView);
        if (layoutView.getParent() != null) {
            ((ViewGroup) layoutView.getParent()).removeView(layoutView);
        }
        mRootView.addView(layoutView);
        return this;
    }

    public void switchLayout(String layoutType) {
        View view = mLayoutMap.get(layoutType);
        if (view != null) {
            if (view instanceof ViewStub) {
                mLayoutMap.put(layoutType, ((ViewStub) view).inflate());
            }
            view.setVisibility(View.VISIBLE);
            if (mLastShowView != null) {
                mLastShowView.setVisibility(View.GONE);
                mLastShowView = view;
            }
        }
    }

    public void destory() {
        mContext = null;
        mDataView = null;
    }
}
