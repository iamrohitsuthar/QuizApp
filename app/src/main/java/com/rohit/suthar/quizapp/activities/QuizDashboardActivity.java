package com.rohit.suthar.quizapp.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rohit.suthar.quizapp.R;
import com.rohit.suthar.quizapp.models.QuestionHolder;

import java.util.ArrayList;

public class QuizDashboardActivity extends AppCompatActivity {
    private Context mContext;
    private TextView mTvQuestionNo, mTvQuestion;
    private Button mBtnOptionA, mBtnOptionB, mBtnOptionC, mBtnOptionD;
    private ArrayList<QuestionHolder> questionHolderArrayList;
    private int questionTracker;
    private Button which;
    private boolean isCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        initialize();
        addQuestions();
        loadQuestions();
    }

    private void initialize() {
        mContext = QuizDashboardActivity.this;
        mTvQuestion = findViewById(R.id.tv_question);
        mTvQuestionNo = findViewById(R.id.tv_question_no);
        mBtnOptionA = findViewById(R.id.btn_a);
        mBtnOptionB = findViewById(R.id.btn_b);
        mBtnOptionC = findViewById(R.id.btn_c);
        mBtnOptionD = findViewById(R.id.btn_d);
        questionTracker = 0;
        questionHolderArrayList = new ArrayList<>();
    }

    private void loadQuestions() {
            mTvQuestionNo.setText(String.valueOf(questionTracker+1));
            mTvQuestion.setText(questionHolderArrayList.get(questionTracker).getQuestion());
            mBtnOptionA.setText(questionHolderArrayList.get(questionTracker).getOptionA());
            mBtnOptionB.setText(questionHolderArrayList.get(questionTracker).getOptionB());
            mBtnOptionC.setText(questionHolderArrayList.get(questionTracker).getOptionC());
            mBtnOptionD.setText(questionHolderArrayList.get(questionTracker).getOptionD());
            checkQuestion();
    }

    private void checkQuestion() {
        mBtnOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionHolderArrayList.get(questionTracker).getOptionCorrect().equals(mBtnOptionA.getText().toString())) {
                    //correct
                    mBtnOptionA.setBackground(getResources().getDrawable(R.drawable.custom_button_correct));
                }
                else {
                    mBtnOptionA.setBackground(getResources().getDrawable(R.drawable.custom_button_wrong));
                }
                updateQuestion();
            }
        });

        mBtnOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionHolderArrayList.get(questionTracker).getOptionCorrect().equals(mBtnOptionB.getText().toString())) {
                    //correct
                    mBtnOptionB.setBackground(getResources().getDrawable(R.drawable.custom_button_correct));
                }
                else {
                    mBtnOptionB.setBackground(getResources().getDrawable(R.drawable.custom_button_wrong));
                }
                updateQuestion();
            }
        });

        mBtnOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionHolderArrayList.get(questionTracker).getOptionCorrect().equals(mBtnOptionC.getText().toString())) {
                    //correct
                    mBtnOptionC.setBackground(getResources().getDrawable(R.drawable.custom_button_correct));
                }
                else {
                    mBtnOptionC.setBackground(getResources().getDrawable(R.drawable.custom_button_wrong));
                }
                updateQuestion();
            }
        });

        mBtnOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionHolderArrayList.get(questionTracker).getOptionCorrect().equals(mBtnOptionD.getText().toString())) {
                    //correct
                    mBtnOptionD.setBackground(getResources().getDrawable(R.drawable.custom_button_correct));
                }
                else {
                    mBtnOptionD.setBackground(getResources().getDrawable(R.drawable.custom_button_wrong));
                }
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        if(questionTracker+1 < questionHolderArrayList.size()) {
            questionTracker++;
            loadQuestions();
        }

    }

    private void addQuestions() {
        questionHolderArrayList.add(new QuestionHolder(getResources().getString(R.string.q1),getResources().getString(R.string.q1_a),getResources().getString(R.string.q1_b),getResources().getString(R.string.q1_c),getResources().getString(R.string.q1_d),getResources().getString(R.string.q1_ans)));
        questionHolderArrayList.add(new QuestionHolder(getResources().getString(R.string.q2),getResources().getString(R.string.q2_a),getResources().getString(R.string.q2_b),getResources().getString(R.string.q2_c),getResources().getString(R.string.q2_d),getResources().getString(R.string.q2_ans)));
    }
}
