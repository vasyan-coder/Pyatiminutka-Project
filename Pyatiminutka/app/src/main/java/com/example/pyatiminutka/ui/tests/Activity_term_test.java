package com.example.pyatiminutka.ui.tests;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class Activity_term_test extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private RadioGroup radioGroup;

    private Button btn_start_quiz;

    private CircularProgressBar progressBar_score;
    private CircularProgressBar progressBar_last_score;
    private TextView text_high_score;
    private TextView text_last_score;
    private TextView text_percent_high_score;
    private TextView text_percent_last_score;

    private int u1 = 0;
    private int u2 = 0;

    private int score_easy_value;
    private int score_medium_value;
    private int score_hard_value;
    private int last_score_easy_value;
    private int last_score_medium_value;
    private int last_score_hard_value;

    private int difficult_num = 0;

    private final int test_num = AppConstants.map_test_number.get("test_num");

    private final QuestionTest questionTest = new QuestionTest();

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        setContentView(R.layout.activity_term_test);


        findById();

        //Настройка toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //SharedPref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if (myPreferences.contains("score_easy"))
            score_easy_value = myPreferences.getInt("score_easy", 0);
        if (myPreferences.contains("score_medium"))
            score_medium_value = myPreferences.getInt("score_medium", 0);
        if (myPreferences.contains("score_hard"))
            score_hard_value = myPreferences.getInt("score_hard", 0);

        if (myPreferences.contains("last_result_test_term_easy"))
            last_score_easy_value = myPreferences.getInt("last_result_test_term_easy", 0);
        if (myPreferences.contains("last_result_test_term_medium"))
            last_score_medium_value = myPreferences.getInt("last_result_test_term_medium", 0);
        if (myPreferences.contains("last_result_test_term_hard"))
            last_score_hard_value = myPreferences.getInt("last_result_test_term_hard", 0);


        AppConstants.map_difficult.put("Difficult", 1);

        //Заголовок
        TextView test_title = findViewById(R.id.test_title);
        test_title.setText(QuestionTest.Question_title[test_num]);

        //Рекорд
        if (test_num == 0) {
            if (myPreferences.contains("score_easy")) {

                //Анимации окна с рекордом
                startScoreAnimationEasy(
                        0,
                        score_easy_value,
                        "/10",
                        text_high_score); //Анимация рекорда в цифрах
                startScoreAnimationEasy(
                        0,
                        score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        "%",
                        text_percent_high_score);  //Анимация рекорда в процентах
                progressBar_score.setProgressWithAnimation(
                        score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        (long) 1000); //Анимация progressbar с рекордом

                //Анимации окна с последним результатом
                startScoreAnimationEasy(
                        0,
                        last_score_easy_value,
                        "/10",
                        text_last_score); //Анимация последнего результата в цифрах
                startScoreAnimationEasy(
                        0,
                        last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        "%",
                        text_percent_last_score); //Анимация последнего результата в процентах
                progressBar_last_score.setProgressWithAnimation(
                        last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        (long) 1000); //Анимация progressbar с последним результатом

                u1 = score_easy_value;
                u2 = last_score_easy_value;
            } else if (myPreferences.contains("score_medium")) {

                //Анимации окна с рекордом
                startScoreAnimationEasy(
                        0,
                        score_medium_value,
                        "/10",
                        text_high_score); //Анимация рекорда
                startScoreAnimationEasy(0,
                        score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        "%",
                        text_percent_high_score);  //Анимация рекорда в процентах
                progressBar_score.setProgressWithAnimation(
                        score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        (long) 1000); //Анимация progressbar с рекордом

                //Анимации окна с последним результатом
                startScoreAnimationEasy(
                        0,
                        last_score_medium_value,
                        "/10",
                        text_last_score); //Анимация последнего результата в цифрах
                startScoreAnimationEasy(0,
                        last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        "%",
                        text_percent_last_score); //Анимация последнего результата в процентах
                progressBar_last_score.setProgressWithAnimation(
                        last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        (long) 1000); //Анимация progressbar с последним результатом

                u1 = score_medium_value;
                u2 = last_score_medium_value;
            } else if (myPreferences.contains("score_hard")) {

                //Анимации окна с рекордом
                startScoreAnimationEasy(
                        0,
                        score_hard_value,
                        "/10",
                        text_high_score); //Анимация рекорда
                startScoreAnimationEasy(
                        0,
                        score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        "%",
                        text_percent_high_score);  //Анимация рекорда в процентах
                progressBar_score.setProgressWithAnimation(
                        score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        (long) 1000);//Анимация progressbar с рекордом

                //Анимации окна с последним результатом
                startScoreAnimationEasy(
                        0,
                        last_score_hard_value,
                        "/10",
                        text_last_score); //Анимация последнего результата в процентах
                startScoreAnimationEasy(
                        0,
                        last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        "%",
                        text_percent_last_score); //Анимация последнего результата в процентах в процентах
                progressBar_last_score.setProgressWithAnimation(
                        last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                        (long) 1000); //Анимация progressbar с последним результатом

                u1 = score_hard_value;
                u2 = last_score_hard_value;
            }
        }

        btn_start_quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent activity2Intent = new Intent(getApplicationContext(), Activity_quiz_term.class);
                startActivity(activity2Intent);
                finish();

            }

        });

        radioGroup.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //sharedPref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        switch (i) {

            case R.id.easyButton:
                AppConstants.map_difficult.remove("Difficult");
                AppConstants.map_difficult.put("Difficult", 1);

                difficult_num = 0;

                if (test_num == 0) {
                    if (myPreferences.contains("score_easy")) {
                        //Анимация окна с рекордом
                        startScoreAnimationEasy(
                                u1,
                                score_easy_value,
                                "/10",
                                text_high_score); //Анимация рекорда
                        startScoreAnimationEasy(
                                u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                "%", text_percent_high_score);  //Анимация рекорда в процентах
                        progressBar_score.setProgressWithAnimation(
                                score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                (long) 1000); //Анимация progressbar с рекордом

                        //Анимация окна с последним результатом
                        startScoreAnimationEasy(
                                u2,
                                last_score_easy_value,
                                "/10",
                                text_last_score); //Анимация последнего результата в процентах
                        startScoreAnimationEasy(
                                u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах
                        progressBar_last_score.setProgressWithAnimation(
                                last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                (long) 1000); //Анимация progressbar с последним результатом


                    } else {
                        progressBar_score.setProgressWithAnimation(0f, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 1000);
                        startScoreAnimationEasy(
                                u1,
                                0,
                                "/10",
                                text_high_score); //Анимация рекорда
                        startScoreAnimationEasy(
                                u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                0,
                                "%",
                                text_percent_high_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(
                                u2,
                                0,
                                "/10",
                                text_last_score); //Анимация последнего результата
                        startScoreAnimationEasy(
                                u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                0,
                                "%",
                                text_percent_last_score); //Анимация последнего результата в процентах
                    }

                    u1 = score_easy_value;
                    u2 = last_score_easy_value;
                }


                break;


            case R.id.mediumButton:
                AppConstants.map_difficult.remove("Difficult");
                AppConstants.map_difficult.put("Difficult", 2);

                difficult_num = 1;

                if (test_num == 0) {
                    if (myPreferences.contains("score_medium")) {
                        startScoreAnimationEasy(
                                u1,
                                score_medium_value,
                                "/10",
                                text_high_score); //Анимация рекорда
                        startScoreAnimationEasy(
                                u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                "%",
                                text_percent_high_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(
                                u2,
                                last_score_medium_value,
                                "/10",
                                text_last_score); //Анимация последнего результата в процентах
                        startScoreAnimationEasy(
                                u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                "%",
                                text_percent_last_score); //Анимация последнего результата в процентах в процентах

                        progressBar_score.setProgressWithAnimation(
                                score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(
                                last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                (long) 1000);
                    } else {
                        progressBar_score.setProgressWithAnimation(0f, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 1000);
                        progressBar_score.setProgressWithAnimation(0f, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 700);
                        startScoreAnimationEasy(u1, 0, "/10", text_high_score); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, 0, "%", text_percent_high_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, 0, "/10", text_last_score); //Анимация последнего результата в процентах
                        startScoreAnimationEasy(u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, 0, "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах
                    }

                    u1 = score_medium_value;
                    u2 = last_score_medium_value;
                }

                break;


            case R.id.hardButton:
                AppConstants.map_difficult.remove("Difficult");
                AppConstants.map_difficult.put("Difficult", 3);

                difficult_num = 2;

                if (test_num == 0) {
                    if (myPreferences.contains("score_hard")) {
                        startScoreAnimationEasy(u1, score_hard_value, "/10", text_high_score); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_high_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, last_score_hard_value, "/10", text_last_score); //Анимация последнего результата
                        startScoreAnimationEasy(u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_last_score); //Анимация последнего результата в процентах

                        progressBar_score.setProgressWithAnimation(
                                score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(
                                last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                (long) 1000);
                    } else {
                        progressBar_score.setProgressWithAnimation(0f, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 1000);
                        progressBar_score.setProgressWithAnimation(0f, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 1000);
                        startScoreAnimationEasy(
                                u1,
                                0,
                                "/10",
                                text_high_score); //Анимация рекорда
                        startScoreAnimationEasy(
                                u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                0,
                                "%",
                                text_percent_high_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(
                                u2,
                                0,
                                "/10",
                                text_last_score); //Анимация последнего результата в процентах
                        startScoreAnimationEasy(
                                u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length,
                                0,
                                "%",
                                text_percent_last_score); //Анимация последнего результата в процентах в процентах
                    }

                    u1 = score_hard_value;
                    u2 = last_score_hard_value;
                }

                break;
        }

    }

    private void findById() {
        text_last_score = findViewById(R.id.text_last_score);
        text_high_score = findViewById(R.id.text_high_score);
        radioGroup = findViewById(R.id.radioGroup);
        btn_start_quiz = findViewById(R.id.button_start_quiz);

        progressBar_score = findViewById(R.id.progressBar_score);
        progressBar_last_score = findViewById(R.id.ProgressBar_last_score);
        text_percent_high_score = findViewById(R.id.text_percent_high_score);
        text_percent_last_score = findViewById(R.id.text_percent_last_score);

        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void startScoreAnimationEasy(Integer startCount, Integer last_score_value, final String str, final TextView textView) {
        ValueAnimator animator = ValueAnimator.ofInt(startCount, last_score_value); //0 is min number, 600 is max number
        animator.setDuration(1000); //Duration is in milliseconds
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(animation.getAnimatedValue().toString() + str);
            }
        });
        animator.start();
    }


}