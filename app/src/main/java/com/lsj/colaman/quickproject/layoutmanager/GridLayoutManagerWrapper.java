package com.lsj.colaman.quickproject.layoutmanager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

import com.lsj.colaman.quickproject.adapter.FeaturesAdapter;

/**
 * <p>
 * 修复使用DiffUtil异步比较数据后，切换到UI线程中刷新，出现Inconsistency detected. Invalid view holder adapter positionViewHolder错误问题
 * GridLayoutManager包装类，重写@see {@link #supportsPredictiveItemAnimations()}函数， return false。
 * </p>
 * Created by leo on 2018/8/28.
 */
public class GridLayoutManagerWrapper extends GridLayoutManager {
    public GridLayoutManagerWrapper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public GridLayoutManagerWrapper(Context context, int spanCount) {
        super(context, spanCount);
    }

    public GridLayoutManagerWrapper(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    /**
     * 有loadmore的情况下，调用此方法避免loadmore的item受到影响
     *
     * @param adapter
     * @return
     */
    public GridLayoutManagerWrapper fixLoadmore(FeaturesAdapter adapter) {
        if (adapter != null) {
            setSpanSizeLookup(new SpanSizeLookup() {
                @Override
                public int getSpanSize(int i) {
                    if (0 <= i && i < adapter.getItemCount() && adapter.isLoadmoreVisible(i)) {
                        return getSpanCount();
                    }
                    return 1;
                }
            });
        }
        return this;
    }

    @Override
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
