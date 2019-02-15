package com.lsj.colaman.quickproject.common.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.lsj.colaman.quickproject.R;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/2/15
 *     desc   : 带有tablayout的viewpager
 * </pre>
 */
public class TabViewPager extends LinearLayout {

    private Context mContext;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private CommonViewPagerAdapter mCommonViewPagerAdapter;

    public TabViewPager(Context context) {
        this(context, null);
    }

    public TabViewPager(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabViewPager(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.include_tab_viewpager, this, true);
        setSlidingTabLayout(view.findViewById(R.id.include_tab));
        setViewPager(view.findViewById(R.id.viewpager));
    }

    public SlidingTabLayout getSlidingTabLayout() {
        return mSlidingTabLayout;
    }

    public void setSlidingTabLayout(SlidingTabLayout slidingTabLayout) {
        mSlidingTabLayout = slidingTabLayout;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public void setViewPager(ViewPager viewPager) {
        mViewPager = viewPager;
    }

    public TabViewPager setDatas(FragmentManager manager, List<Fragment> fragments) {
        mCommonViewPagerAdapter = new CommonViewPagerAdapter(manager, fragments);
        getViewPager().setOffscreenPageLimit(fragments.size());
        return this;
    }

    public TabViewPager show() {
        getViewPager().setAdapter(mCommonViewPagerAdapter);
        getSlidingTabLayout().setViewPager(getViewPager());
        return this;
    }

    public TabViewPager setTitles(List<String> titles) {
        mCommonViewPagerAdapter.setTitles(titles);
        return this;
    }

    public TabViewPager setSelectTabColor(int color) {
        getSlidingTabLayout().setTextSelectColor(color);
        return this;
    }

    public TabViewPager setUnSelectTabColor(int color) {
        getSlidingTabLayout().setTextUnselectColor(color);
        return this;
    }

    public TabViewPager setCorner(float corner) {
        getSlidingTabLayout().setIndicatorCornerRadius(corner);
        return this;
    }

    public TabViewPager setIndicatorWidth(float width) {
        getSlidingTabLayout().setIndicatorWidth(width);
        return this;
    }

    public TabViewPager setIndicatorColor(int color) {
        getSlidingTabLayout().setIndicatorColor(color);
        return this;
    }
}
