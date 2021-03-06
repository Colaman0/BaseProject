package com.lsj.colaman.quickproject.sample;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;

import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.common.view.TabViewPager;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;


public class TabActivity extends BaseActivity {
    @BindView(R.id.tab_viewpager)
    TabViewPager mTabViewPager;


    @Override
    protected int initLayoutRes() {
        return R.layout.activity_tab;
    }

    @SuppressLint("AutoDispose")
    @Override
    protected void initView() {
        mTabViewPager.setDatas(getSupportFragmentManager(), getFragments())
                .setTitles(getTitles())
                .show();

    }

    private List<Fragment> getFragments() {
        return Arrays.asList(
                new TabFragment().setPage(0),
                new TabFragment().setPage(1),
                new TabFragment().setPage(2),
                new TabFragment().setPage(3),
                new TabFragment().setPage(4)
        );
    }

    private List<String> getTitles() {
        return Arrays.asList("1", "22", "333", "4444", "55555");
    }
}
