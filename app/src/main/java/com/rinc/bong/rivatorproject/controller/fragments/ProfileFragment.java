package com.rinc.bong.rivatorproject.controller.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.StringSignature;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.ContestManagementActivity;
import com.rinc.bong.rivatorproject.controller.activitys.EasterEggActivity;
import com.rinc.bong.rivatorproject.controller.activitys.HomeActivity;
import com.rinc.bong.rivatorproject.controller.activitys.HomeWorkActivity;
import com.rinc.bong.rivatorproject.controller.activitys.CourseManagementActivity;
import com.rinc.bong.rivatorproject.controller.activitys.NoticeActivity;
import com.rinc.bong.rivatorproject.controller.activitys.ProfileModifyActivity;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectActivity;


public class ProfileFragment extends Fragment {
    private static String IMAGE_URL="http://n0rr.kro.kr:7001/users/";
    private View view = null;

    private User user;
    private de.hdodenhof.circleimageview.CircleImageView profile;
    private TextView name;
    private TextView subject;
    private LinearLayout notice_btn = null;
    private LinearLayout homework_btn = null;
    private LinearLayout course_btn = null;
    private LinearLayout contest_btn = null;
    private LinearLayout project_btn = null;
    private LinearLayout profile_modify_btn = null;
    private LinearLayout profile_appinfo_btn = null;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        init();
        loadInfo();
        setListener();
        return view;
    }

    private void init() {
        profile = view.findViewById(R.id.profile);
        name = view.findViewById(R.id.name);
        subject = view.findViewById(R.id.subject);
        notice_btn = view.findViewById(R.id.profile_notice_btn);
        homework_btn = view.findViewById(R.id.profile_homework_btn);
        course_btn = view.findViewById(R.id.profile_course_btn);
        contest_btn = view.findViewById(R.id.profile_contest_btn);
        project_btn = view.findViewById(R.id.profile_project_btn);
        profile_modify_btn = view.findViewById(R.id.profile_modify_btn);
        profile_appinfo_btn = view.findViewById(R.id.profile_appinfo_btn);
    }

    private void loadInfo() {
        user = User.last(User.class);
        Glide.with(getContext()).load(IMAGE_URL + user.getUserId() + "/profile-image.jpg").diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true).crossFade().into(profile);
        name.setText(user.getUserName());
        subject.setText(user.getSubject());
    }

    private void setListener() {
        notice_btn.setOnClickListener(view -> {
           startActivity(new Intent(view.getContext(), NoticeActivity.class));
        });
        homework_btn.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), HomeWorkActivity.class));
        });
        project_btn.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), ProjectActivity.class));
        });
        course_btn.setOnClickListener(v -> {
            startActivity(new Intent(view.getContext(), CourseManagementActivity.class));
        });
        contest_btn.setOnClickListener(v -> {
            startActivity(new Intent(view.getContext(), ContestManagementActivity.class));
        });
        profile_modify_btn.setOnClickListener(v -> {
            startActivity(new Intent(view.getContext(), ProfileModifyActivity.class));
        });
        profile_appinfo_btn.setOnClickListener(v -> {
            startActivity(new Intent(view.getContext(), EasterEggActivity.class));
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("test","test");
        loadInfo();
    }
}
