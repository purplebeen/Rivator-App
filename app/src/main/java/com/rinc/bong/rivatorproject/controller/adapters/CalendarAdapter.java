package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.DetailCourse;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by baehy on 2017. 9. 23..
 */

public class CalendarAdapter extends ArrayAdapter<DetailCourse>{
    private List<DetailCourse> listViewItem = new ArrayList<DetailCourse>();
    private Context context;
    private int srsc;

    public CalendarAdapter(Context context, int srsc, List<DetailCourse> items) {
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
    public DetailCourse getItem(int position) {
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

        TextView title = (TextView) view.findViewById(R.id.item_course_title);
        TextView teacherName = (TextView) view.findViewById(R.id.item_course_teacherName);
        TextView subject = (TextView) view.findViewById(R.id.item_course_category);
        TextView unitTime = (TextView) view.findViewById(R.id.item_course_unitTime);

        DetailCourse item = listViewItem.get(position);
        teacherName.setText(item.getUser().getUserName());
        subject.setText(item.getCategory());

        return view;
    }
}
