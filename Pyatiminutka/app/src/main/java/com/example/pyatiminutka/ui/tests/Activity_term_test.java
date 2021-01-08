package com.example.pyatiminutka.ui.tests;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class Activity_term_test extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private TextView text_view_highscore;
    private TextView last_result_onstart;

    private RadioGroup radioGroup;

    private Button button;

    private CircularProgressBar progressBar_score;
    private CircularProgressBar progressBar_last_score;
    private TextView text_percent_score;
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

    private int test_num = AppConstants.map_test_number.get("test_num");

    private QuestionTest questionTest = new QuestionTest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Проверка установленной темы
        LoadTheme.LoadTheme(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        StatusBarColor.StatusBarColor(R.color.background2, R.color.colorBackgroundBlocks, this);



        setContentView(R.layout.activity_term_test);



        findById();
        //Получение номера выбранного теста

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
        test_title.setText(QuestionTest.Question_title[AppConstants.map_test_number.get("test_num")]);

        //Рекорд
        if (AppConstants.map_test_number.get("test_num") == 0) {
            if (myPreferences.contains("score_easy")) {
                startScoreAnimationEasy(0, score_easy_value, "/10", text_view_highscore); //Анимация рекорда
                startScoreAnimationEasy(0, score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_score);  //Анимация рекорда в процентах

                startScoreAnimationEasy(0, last_score_easy_value, "/10", last_result_onstart); //Анимация последнего результата в процентах
                startScoreAnimationEasy(0, last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах

                progressBar_score.setProgressWithAnimation(score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                progressBar_last_score.setProgressWithAnimation(last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);

                u1 = score_easy_value;
                u2 = last_score_easy_value;
            } else if (myPreferences.contains("score_medium")) {
                startScoreAnimationEasy(0, score_medium_value, "/10", text_view_highscore); //Анимация рекорда
                startScoreAnimationEasy(0, score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_score);  //Анимация рекорда в процентах

                startScoreAnimationEasy(0, last_score_medium_value, "/10", last_result_onstart); //Анимация последнего результата в процентах
                startScoreAnimationEasy(0, last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах

                progressBar_score.setProgressWithAnimation(score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                progressBar_last_score.setProgressWithAnimation(last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);

                u1 = score_medium_value;
                u2 = last_score_medium_value;
            } else if (myPreferences.contains("score_hard")) {
                startScoreAnimationEasy(0, score_hard_value, "/10", text_view_highscore); //Анимация рекорда
                startScoreAnimationEasy(0, score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_score);  //Анимация рекорда в процентах

                startScoreAnimationEasy(0, last_score_hard_value, "/10", last_result_onstart); //Анимация последнего результата в процентах
                startScoreAnimationEasy(0, last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах

                progressBar_score.setProgressWithAnimation(score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                progressBar_last_score.setProgressWithAnimation(last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);

                u1 = score_hard_value;
                u2 = last_score_hard_value;
            }
        }


        //Кнопка назад
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
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

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        switch (i) {

            case R.id.easyButton:
                AppConstants.map_difficult.remove("Difficult");
                AppConstants.map_difficult.put("Difficult", 1);

                difficult_num = 0;

                if (AppConstants.map_test_number.get("test_num") == 0) {
                    if (myPreferences.contains("score_easy")) {
                        startScoreAnimationEasy(u1, score_easy_value, "/10", text_view_highscore); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, last_score_easy_value, "/10", last_result_onstart); //Анимация последнего результата в процентах
                        startScoreAnimationEasy(u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах

                        progressBar_score.setProgressWithAnimation(score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(last_score_easy_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                    } else {
                        progressBar_score.setProgressWithAnimation(0f, (long) 700);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 700);
                        startScoreAnimationEasy(u1, 0, "/10", text_view_highscore); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, 0, "%", text_percent_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, 0, "/10", last_result_onstart); //Анимация последнего результата
                        startScoreAnimationEasy(u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, 0, "%", text_percent_last_score); //Анимация последнего результата в процентах
                    }

                    u1 = score_easy_value;
                    u2 = last_score_easy_value;
                }


                break;


            case R.id.mediumButton:
                AppConstants.map_difficult.remove("Difficult");
                AppConstants.map_difficult.put("Difficult", 2);

                difficult_num = 1;

                if (AppConstants.map_test_number.get("test_num") == 0) {
                    if (myPreferences.contains("score_medium")) {
                        startScoreAnimationEasy(u1, score_medium_value, "/10", text_view_highscore); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, last_score_medium_value, "/10", last_result_onstart); //Анимация последнего результата в процентах
                        startScoreAnimationEasy(u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах

                        progressBar_score.setProgressWithAnimation(score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(last_score_medium_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                    } else {
                        progressBar_score.setProgressWithAnimation(0f, (long) 700);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 700);
                        progressBar_score.setProgressWithAnimation(0f, (long) 700);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 700);
                        startScoreAnimationEasy(u1, 0, "/10", text_view_highscore); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, 0, "%", text_percent_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, 0, "/10", last_result_onstart); //Анимация последнего результата в процентах
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

                if (AppConstants.map_test_number.get("test_num") == 0) {
                    if (myPreferences.contains("score_hard")) {
                        startScoreAnimationEasy(u1, score_hard_value, "/10", text_view_highscore); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, last_score_hard_value, "/10", last_result_onstart); //Анимация последнего результата
                        startScoreAnimationEasy(u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, "%", text_percent_last_score); //Анимация последнего результата в процентах

                        progressBar_score.setProgressWithAnimation(score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                        progressBar_last_score.setProgressWithAnimation(last_score_hard_value * 100 / questionTest.QuestionTest[test_num][difficult_num].length, (long) 1000);
                    } else {
                        progressBar_score.setProgressWithAnimation(0f, (long) 700);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 700);
                        progressBar_score.setProgressWithAnimation(0f, (long) 700);
                        progressBar_last_score.setProgressWithAnimation(0f, (long) 700);
                        startScoreAnimationEasy(u1, 0, "/10", text_view_highscore); //Анимация рекорда
                        startScoreAnimationEasy(u1 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, 0, "%", text_percent_score);  //Анимация рекорда в процентах

                        startScoreAnimationEasy(u2, 0, "/10", last_result_onstart); //Анимация последнего результата в процентах
                        startScoreAnimationEasy(u2 * 100 / questionTest.QuestionTest[test_num][difficult_num].length, 0, "%", text_percent_last_score); //Анимация последнего результата в процентах в процентах
                    }

                    u1 = score_hard_value;
                    u2 = last_score_hard_value;
                }

                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void findById() {
        last_result_onstart = findViewById(R.id.text_last_score);
        text_view_highscore = findViewById(R.id.text_score);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button_start_quiz);

        progressBar_score = findViewById(R.id.progressBar_score);
        progressBar_last_score = findViewById(R.id.ProgressBar_last_score);
        text_percent_score = findViewById(R.id.text_percent_score);
        text_percent_last_score = findViewById(R.id.text_percent_last_score);
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

    private void startScoreLastAnimationEasy(Long seconds, Integer startCount, Integer last_score_value, final String str, final TextView textView) {
        ValueAnimator animator = ValueAnimator.ofInt(startCount, last_score_value); //0 is min number, 600 is max number
        animator.setDuration(seconds); //Duration is in milliseconds
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(animation.getAnimatedValue().toString() + str);
            }
        });
        animator.start();
    }

    public void click_previous(View view) {
        this.finish();
    }
}