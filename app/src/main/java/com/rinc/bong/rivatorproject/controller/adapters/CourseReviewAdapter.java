package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseReview;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baehy on 2017. 9. 23..
 */

public class CourseReviewAdapter extends ArrayAdapter<CourseReview> {
    private List<CourseReview> listViewItem = new ArrayList<CourseReview>();
    private Context context;
    private int srsc;

    public CourseReviewAdapter(Context context, int srsc, List<CourseReview> items) {
        super(context,srsc,items);
        this.context = context;
        this.srsc = srsc;
        this.listViewItem = items;
    }
    @Override
    public int getCount() {
        return listViewItem.size();
    }

    @Override
    public CourseReview getItem(int position) {
        return listViewItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        View view = convertView;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(srsc,null);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.name);
        TextView subject = view.findViewById(R.id.category);
        TextView score = view.findViewById(R.id.score);

        CourseReview item = listViewItem.get(position);
        Glide.with(context).load("http://n0rr.kro.kr:7001/users/" + item.getUser().getUserId() + "/profile-image.jpg").centerCrop().into(imageView);
        name.setText(item.getUser().getUserName());
        score.setText(Double.toString(item.getScore()));
        if(item.getContent().length() > 10)
            subject.setText(item.getContent().substring(0,10) + "...");
        else
            subject.setText(item.getContent());
        return view;
    }
}
