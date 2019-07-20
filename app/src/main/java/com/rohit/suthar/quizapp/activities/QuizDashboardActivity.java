package com.rohit.suthar.quizapp.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rohit.suthar.quizapp.R;

public class QuizDashboardActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
    }

    private void initialize() {
        mContext = QuizDashboardActivity.this;
    }
}
