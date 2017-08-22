package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CurrentCourse;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 7. 23..
 */

public class LectureAdapter extends RecyclerView.Adapter<LectureViewHolder> {
    private Context context;
    private ArrayList<CurrentCourse> items;
    public LectureAdapter(Context context, ArrayList<CurrentCourse> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public LectureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_card_view, null);
        return new LectureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LectureViewHolder holder, int position) {
        CurrentCourse item = items.get(position);
        holder.getTitle().setText(item.getTitle());
        holder.getTeacherName().setText(item.getTeacherName());
        holder.getUnit().setText(Integer.toString(item.getUnitTime())+"시간");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}