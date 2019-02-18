package com.lsj.colaman.quickproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lsj.colaman.quickproject.base.BaseActivity;
import com.lsj.colaman.quickproject.common.helper.GlideImageLoader;
import com.lsj.colaman.quickproject.common.view.CommonViewPagerAdapter;
import com.lsj.colaman.quickproject.sample.TabFragment;
import com.zhihu.matisse.Matisse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/2/18
 *     desc   :
 * </pre>
 */
public class BottomTabActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    private List<Fragment> mFragments = Arrays.asList(
            new UserMineFragment(),
            new UserMineFragment(),
            new UserMineFragment(),
            new UserMineFragment()
    );


    @Override
    protected int initLayoutRes() {
        return R.layout.activity_user_home;
    }

    @Override
    protected int setStatusBarColor() {
        return R.color.transparent;
    }

    @Override
    protected void initView() {
        ArrayList<CustomTabEntity> datas = new ArrayList<>();
        datas.add(new TabEntity("首页", 0, 0));
        datas.add(new TabEntity("订单", 0, 0));
        datas.add(new TabEntity("购物车", 0, 0));
        datas.add(new TabEntity("我的", 0, 0));
        tabLayout.setTabData(datas);
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(new CommonViewPagerAdapter(getSupportFragmentManager(), getFragments()));
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                tabLayout.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private List<Fragment> getFragments() {
        return mFragments;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String photo = Matisse.obtainPathResult(data).get(0);
            ((UserMineFragment) mFragments.get(3)).setPhoto(photo);

        }
    }
}
