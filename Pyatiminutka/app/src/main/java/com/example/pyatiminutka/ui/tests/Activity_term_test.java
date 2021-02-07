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
import androidx.cardview.widget.CardView;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import org.w3c.dom.Text;

public class Activity_term_test extends AppCompatActivity implements View.OnClickListener {


    private RadioGroup radioGroup;

    private Button btn_start_quiz;

    private CardView cardView_easy;
    private CircularProgressBar progressBar_easy_last_score;
    private TextView text_easy_last_score;
    private TextView text_percent_easy_last_score;
    private CircularProgressBar progressBar_easy_score;
    private TextView text_easy_high_score;
    private TextView text_percent_easy_high_score;
    private TextView text_view_last_score_time_easy;
    private TextView text_view_score_time_easy;


    private CardView cardView_medium;
    private CircularProgressBar progressBar_medium_last_score;
    private TextView text_medium_last_score;
    private TextView text_percent_medium_last_score;
    private TextView text_view_time_medium;
    private CircularProgressBar progressBar_medium_score;
    private TextView text_medium_high_score;
    private TextView text_percent_medium_high_score;
    private TextView text_view_last_score_time_medium;
    private TextView text_view_score_time_medium;

    private CardView cardView_hard;
    private CircularProgressBar progressBar_hard_last_score;
    private TextView text_hard_last_score;
    private TextView text_percent_hard_last_score;
    private TextView text_view_time_hard;
    private CircularProgressBar progressBar_hard_score;
    private TextView text_hard_high_score;
    private TextView text_percent_hard_high_score;
    private TextView text_view_last_score_time_hard;
    private TextView text_view_score_time_hard;

    private int score_easy_value;
    private int score_medium_value;
    private int score_hard_value;
    private int last_score_easy_value;
    private int last_score_medium_value;
    private int last_score_hard_value;

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

        toolbar.setTitle(QuestionTest.Question_title[test_num]);

        //Настройка toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //SharedPref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if (myPreferences.contains("score_easy")){
            score_easy_value = myPreferences.getInt("score_easy", 0);
            text_view_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_1,""));
            text_view_last_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_1,""));
        }
        if (myPreferences.contains("score_medium")){
            score_medium_value = myPreferences.getInt("score_medium", 0);
            text_view_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_1,""));
            text_view_last_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_1,""));
        }


        if (myPreferences.contains("score_hard")){
            score_hard_value = myPreferences.getInt("score_hard", 0);
            text_view_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_1,""));
            text_view_last_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_1,""));
        }


        if (myPreferences.contains("last_result_test_term_easy"))
            last_score_easy_value = myPreferences.getInt("last_result_test_term_easy", 0);
        if (myPreferences.contains("last_result_test_term_medium"))
            last_score_medium_value = myPreferences.getInt("last_result_test_term_medium", 0);
        if (myPreferences.contains("last_result_test_term_hard"))
            last_score_hard_value = myPreferences.getInt("last_result_test_term_hard", 0);

        progressBar_easy_last_score.setProgressWithAnimation(
                last_score_easy_value * 100 / questionTest.QuestionTest[test_num][0].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                last_score_easy_value,
                "/10",
                text_easy_last_score); //Анимация последнего результата в цифрах
        startScoreAnimationEasy(
                0,
                last_score_easy_value * 100 / questionTest.QuestionTest[test_num][0].length,
                "%",
                text_percent_easy_last_score); //Анимация последнего результата в процентах


        progressBar_medium_last_score.setProgressWithAnimation(
                last_score_medium_value * 100 / questionTest.QuestionTest[test_num][1].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                last_score_medium_value,
                "/10",
                text_medium_last_score); //Анимация последнего результата в цифрах
        startScoreAnimationEasy(
                0,
                last_score_medium_value * 100 / questionTest.QuestionTest[test_num][1].length,
                "%",
                text_percent_medium_last_score); //Анимация последнего результата в процентах


        progressBar_hard_last_score.setProgressWithAnimation(
                last_score_hard_value * 100 / questionTest.QuestionTest[test_num][2].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                last_score_hard_value,
                "/10",
                text_hard_last_score); //Анимация последнего результата в цифрах
        startScoreAnimationEasy(
                0,
                last_score_hard_value * 100 / questionTest.QuestionTest[test_num][2].length,
                "%",
                text_percent_hard_high_score); //Анимация последнего результата в процентах


        //Анимации с рекордом
        progressBar_easy_score.setProgressWithAnimation(
                score_easy_value * 100 / questionTest.QuestionTest[test_num][0].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                score_easy_value,
                "/10",
                text_easy_high_score); //Анимация последнего результата в цифрах
        startScoreAnimationEasy(
                0,
                score_easy_value * 100 / questionTest.QuestionTest[test_num][0].length,
                "%",
                text_percent_easy_high_score); //Анимация последнего результата в процентах


        progressBar_medium_score.setProgressWithAnimation(score_medium_value * 100 / questionTest.QuestionTest[test_num][1].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                score_medium_value,
                "/10",
                text_medium_high_score); //Анимация последнего результата в цифрах
        startScoreAnimationEasy(
                0,
                score_medium_value * 100 / questionTest.QuestionTest[test_num][1].length,
                "%",
                text_percent_medium_high_score); //Анимация последнего результата в процентах


        progressBar_hard_score.setProgressWithAnimation(
                score_hard_value * 100 / questionTest.QuestionTest[test_num][2].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                score_hard_value,
                "/10",
                text_hard_high_score); //Анимация последнего результата в цифрах
        startScoreAnimationEasy(
                0,
                score_hard_value * 100 / questionTest.QuestionTest[test_num][2].length,
                "%",
                text_percent_hard_high_score); //Анимация последнего результата в процентах

        cardView_easy.setOnClickListener(this);
        cardView_medium.setOnClickListener(this);
        cardView_hard.setOnClickListener(this);
    }

    private void findById() {

        toolbar = findViewById(R.id.toolbar);

        cardView_easy = findViewById(R.id.cardView_easy);
        progressBar_easy_last_score = findViewById(R.id.progressBar_easy_last_score);
        text_easy_last_score = findViewById(R.id.text_easy_last_score);
        text_percent_easy_last_score = findViewById(R.id.text_percent_easy_last_score);
        progressBar_easy_score = findViewById(R.id.progressBar_easy_score);
        text_easy_high_score = findViewById(R.id.text_easy_high_score);
        text_percent_easy_high_score = findViewById(R.id.text_percent_easy_high_score);
        text_view_last_score_time_easy = findViewById(R.id.text_view_last_score_time_easy);
        text_view_score_time_easy = findViewById(R.id.text_view_score_time_easy);

        cardView_medium = findViewById(R.id.cardView_medium);
        progressBar_medium_last_score = findViewById(R.id.progressBar_medium_last_score);
        text_medium_last_score = findViewById(R.id.text_medium_last_score);
        text_percent_medium_last_score = findViewById(R.id.text_percent_medium_last_score);
        progressBar_medium_score = findViewById(R.id.progressBar_medium_score);
        text_medium_high_score = findViewById(R.id.text_medium_high_score);
        text_percent_medium_high_score = findViewById(R.id.text_percent_medium_high_score);
        text_view_last_score_time_medium = findViewById(R.id.text_view_last_score_time_medium);
        text_view_score_time_medium = findViewById(R.id.text_view_score_time_medium);

        cardView_hard = findViewById(R.id.cardView_hard);
        progressBar_hard_last_score = findViewById(R.id.progressBar_hard_last_score);
        text_hard_last_score = findViewById(R.id.text_hard_last_score);
        text_percent_hard_last_score = findViewById(R.id.text_percent_hard_last_score);
        progressBar_hard_score = findViewById(R.id.progressBar_hard_score);
        text_hard_high_score = findViewById(R.id.text_hard_high_score);
        text_percent_hard_high_score = findViewById(R.id.text_percent_hard_high_score);
        text_view_last_score_time_hard = findViewById(R.id.text_view_last_score_time_hard);
        text_view_score_time_hard = findViewById(R.id.text_view_score_time_hard);

        text_view_score_time_easy = findViewById(R.id.text_view_score_time_easy);
        text_view_score_time_medium = findViewById(R.id.text_view_score_time_medium);
        text_view_score_time_hard = findViewById(R.id.text_view_score_time_hard);
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


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), Activity_quiz_term.class);

        switch (v.getId()) {
            case R.id.cardView_easy:
                AppConstants.map_difficult.put("Difficult", 1);
                startActivity(intent);
                finish();
                break;
            case R.id.cardView_medium:
                AppConstants.map_difficult.put("Difficult", 2);
                startActivity(intent);
                finish();
                break;
            case R.id.cardView_hard:
                AppConstants.map_difficult.put("Difficult", 3);
                startActivity(intent);
                finish();
                break;
        }
    }
}