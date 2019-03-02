package com.lsj.colaman.quickproject.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lsj.colaman.quickproject.R;
import com.lsj.colaman.quickproject.TestaViewModel;
import com.lsj.colaman.quickproject.adapter.FeaturesAdapter;

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
public class TabFragment extends Fragment {
    public int position;
    FeaturesAdapter adapter;
    private RecyclerView mRecyclerView;

    public TabFragment setPage(int position) {
        this.position = position;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.include_page, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FeaturesAdapter(getContext())
                .bindRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(adapter);
        adapter.add(new TestaViewModel(1));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        adapter.add(new TestaViewModel(1));
//        adapter.add(new TestaViewModel(1));

    }
}
