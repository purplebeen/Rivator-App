package com.rinc.bong.rivatorproject.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.activitys.MainActivity;

public class StudentSignUpActivity extends AppCompatActivity {
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        setCustomActionbar();

    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //기존의 액티비티 모든 스택 제거
        startActivity(intent);
    }

    private void setCustomActionbar() {
        actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        View mCustomView = LayoutInflater.from(this).inflate(R.layout.layout_actionbar_type_cancle, null);
        TextView textView = (TextView) mCustomView.findViewById(R.id.title);
        textView.setText("프로필 작성");

        ImageButton imageButton = (ImageButton) mCustomView.findViewById(R.id.btnClose);
        imageButton.setOnClickListener( v-> {
            finish();
        });
        actionBar.setCustomView(mCustomView);
    }
}
