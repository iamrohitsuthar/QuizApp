package com.rohit.suthar.quizapp.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.rohit.suthar.quizapp.R;

public class QuizDashboardActivity extends AppCompatActivity {
    private Context mContext;
    private TextView mTvQuestionNo, mTvQuestion;
    private Button mBtnOptionA, mBtnOptionB, mBtnOptionC, mBtnOptionD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        initialize();
    }

    private void initialize() {
        mContext = QuizDashboardActivity.this;
        mTvQuestion = findViewById(R.id.tv_question);
        mTvQuestionNo = findViewById(R.id.tv_question_no);

    }
}
