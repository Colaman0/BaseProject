package com.lsj.colaman.quickproject.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lsj.colaman.quickproject.R;

import org.w3c.dom.Text;

import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/2/14
 *     desc   :
 * </pre>
 */
public class TabFragment extends SupportFragment {
    public int position;

    public TabFragment setPage(int position) {
        this.position = position;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return LayoutInflater.from(getContext()).inflate(R.layout.include_page, container, false);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        Log.d("cola", "page = " + position);
        ((TextView) getView().findViewById(R.id.text)).setText("page = " + position);
        ToastUtils.showShort(String.valueOf(position));
    }
}
