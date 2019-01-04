package com.lsj.colaman.quickproject.common.helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Create by kyle on 2019/1/4
 * Function : recyclerview 辅助类
 */
public class RecyclerViewHelper {

    /**
     * 定位到对应的position，item会在recyclerview顶部(不带动画)
     *
     * @param recyclerView 需要操作的recyclerview
     * @param position     要滚动到的position
     */
    public static void scrollToPosition(RecyclerView recyclerView, int position) {
        if (recyclerView == null || recyclerView.getAdapter() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null && position >= 0 && position < recyclerView.getAdapter().getItemCount()) {
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, 0);
                return;
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(position, 0);
                return;
            }
        }
    }

    /**
     * 定位到对应的position，item会在recyclerview中间(不带动画)
     *
     * @param recyclerView 需要操作的recyclerview
     * @param position     要滚动到的position
     */
    public static void scrollToPositionCenter(RecyclerView recyclerView, int position) {
        if (recyclerView == null || recyclerView.getAdapter() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null && position >= 0 && position < recyclerView.getAdapter().getItemCount()) {
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, 0);
                View item = layoutManager.getChildAt(0);
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, recyclerView.getHeight() / 2 - item.getMeasuredHeight() / 2);
                return;
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, 0);
                View item = layoutManager.getChildAt(0);
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, recyclerView.getHeight() / 2 - item.getMeasuredHeight() / 2);
                ;
                return;
            }
        }
    }


    /**
     * 定位到对应position(附带动画)
     *
     * @param recyclerView 需要操作的recyclerview
     * @param position     要滚动的position
     * @param scrollType   最终停止时item的位置策略
     *                     LinearSmoothScroller.SNAP_TO_START 使子视图的左侧或顶部与父视图的左侧或顶部对齐
     *                     LinearSmoothScroller.SNAP_TO_ANY 使子视图的右侧或底部与父视图的右侧面或底部对齐
     *                     LinearSmoothScroller.SNAP_TO_END 根据子视图的当前位置与父布局的关系，决定子视图是否从头到尾跟随。
     *                     如果子视图实际位于RecyclerView的左侧，SNAP_TO_ANY和SNAP_TO_START是没有差别的。
     */
    public static void smoothScrollToPosition(RecyclerView recyclerView, int position, int scrollType) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        if (layoutManager != null && position >= 0 && position < recyclerView.getAdapter().getItemCount()) {
            layoutManager.startSmoothScroll(getLinearSmoothScroller(recyclerView, position, scrollType));
        }
    }

    /**
     * 获取一个LinearSmoothScroller
     */
    @NonNull
    private static LinearSmoothScroller getLinearSmoothScroller(RecyclerView recyclerView, int position, int scrollType) {
        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
            @Override
            protected int getVerticalSnapPreference() {
                return scrollType;
            }

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 1f;
            }
        };
        smoothScroller.setTargetPosition(position);
        return smoothScroller;
    }
}
