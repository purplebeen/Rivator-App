package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.NoticeRecyclerAdapter;

/**
 * Created by Bong on 2017-07-30.
 */

public class HomeWorkNotSubmitFragment extends Fragment {

    private View view = null;
    private RecyclerView mRecyclerView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_management_default,container ,false);
        init();
        recyclerInit();
        return view;
    }

    private void init() {
        mRecyclerView = view.findViewById(R.id.recyclerview_default);
    }

    private void recyclerInit() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        NoticeRecyclerAdapter mNoticeRecyclerAdapter = new NoticeRecyclerAdapter(view.getContext());
        mRecyclerView.setAdapter(mNoticeRecyclerAdapter);
    }

    public static HomeWorkNotSubmitFragment newInstance() {

        Bundle args = new Bundle();

        HomeWorkNotSubmitFragment fragment = new HomeWorkNotSubmitFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
