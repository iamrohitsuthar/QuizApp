package com.rohit.suthar.quizapp.activities;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rohit.suthar.quizapp.R;
import com.rohit.suthar.quizapp.models.QuestionHolder;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizDashboardActivity extends AppCompatActivity {
    private Context mContext;
    private TextView mTvQuestionNo, mTvQuestion;
    private Button mBtnOptionA, mBtnOptionB, mBtnOptionC, mBtnOptionD;
    private ArrayList<QuestionHolder> questionHolderArrayList;
    private int questionTracker;
    private Button which;
    private boolean isCorrect = false;
    private HashMap<String,Button> optionsMapping;

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
        mBtnOptionA = findViewById(R.id.a);
        mBtnOptionB = findViewById(R.id.b);
        mBtnOptionC = findViewById(R.id.c);
        mBtnOptionD = findViewById(R.id.d);
        questionTracker = 0;
        questionHolderArrayList = new ArrayList<>();
        optionsMapping = new HashMap<>();
        optionsMapping.put("a",mBtnOptionA);
        optionsMapping.put("b",mBtnOptionB);
        optionsMapping.put("c",mBtnOptionC);
        optionsMapping.put("d",mBtnOptionD);
    }

    private void loadQuestions() {
        mTvQuestionNo.setText(String.valueOf(questionTracker+1));
        mTvQuestion.setText(questionHolderArrayList.get(questionTracker).getQuestion());
        mBtnOptionA.setText(questionHolderArrayList.get(questionTracker).getOptionA());
        mBtnOptionB.setText(questionHolderArrayList.get(questionTracker).getOptionB());
        mBtnOptionC.setText(questionHolderArrayList.get(questionTracker).getOptionC());
        mBtnOptionD.setText(questionHolderArrayList.get(questionTracker).getOptionD());
    }

    private void checkQuestion(final String options) {
        boolean isCorrect = true;
        if(options.trim().equals(questionHolderArrayList.get(questionTracker).getOptionCorrect())) {
            optionsMapping.get(options).setBackground(getResources().getDrawable(R.drawable.custom_button_correct));
        }
        else {
            optionsMapping.get(options).setBackground(getResources().getDrawable(R.drawable.custom_button_wrong));
            optionsMapping.get(questionHolderArrayList.get(questionTracker).getOptionCorrect().trim()).setBackground(getResources().getDrawable(R.drawable.custom_button_correct));
            isCorrect = false;
        }
        final boolean finalIsCorrect = isCorrect;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!finalIsCorrect)
                    optionsMapping.get(options).setBackground(getResources().getDrawable(R.drawable.custom_button));
                optionsMapping.get(questionHolderArrayList.get(questionTracker).getOptionCorrect().trim()).setBackground(getResources().getDrawable(R.drawable.custom_button));
                updateQuestion();
            }
        },800);
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

    public void optionAClicked(View view) {
        checkQuestion("a");
    }

    public void optionBClicked(View view) {
        checkQuestion("b");
    }

    public void optionCClicked(View view) {
        checkQuestion("c");
    }

    public void optionDClicked(View view) {
        checkQuestion("d");
    }
}
