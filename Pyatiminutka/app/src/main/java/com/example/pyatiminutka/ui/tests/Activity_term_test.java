package com.example.pyatiminutka.ui.tests;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.pyatiminutka.ui.result.Activity_result_term;
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

        for (int i = 0; i < 11; i++) {
            QuestionTest.skip_answers[i] = 0;
        }

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

        if (test_num == 0) {
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_1)) {
                text_view_last_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_1, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_1)) {
                text_view_last_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_1, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_1)) {
                text_view_last_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_1, ""));
            }


            if (myPreferences.contains("score_easy")) {
                score_easy_value = myPreferences.getInt("score_easy", 0);
                text_view_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_1, ""));

            }
            if (myPreferences.contains("score_medium")) {
                score_medium_value = myPreferences.getInt("score_medium", 0);
                text_view_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_1, ""));
            }


            if (myPreferences.contains("score_hard")) {
                score_hard_value = myPreferences.getInt("score_hard", 0);
                text_view_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_1, ""));
            }


            if (myPreferences.contains("last_result_test_term_easy"))
                last_score_easy_value = myPreferences.getInt("last_result_test_term_easy", 0);
            if (myPreferences.contains("last_result_test_term_medium"))
                last_score_medium_value = myPreferences.getInt("last_result_test_term_medium", 0);
            if (myPreferences.contains("last_result_test_term_hard"))
                last_score_hard_value = myPreferences.getInt("last_result_test_term_hard", 0);

        } else if (test_num == 1) {
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_2)) {
                text_view_last_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_2, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_2)) {
                text_view_last_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_2, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_2)) {
                text_view_last_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_2, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_2)) {
                score_easy_value = myPreferences.getInt(AppConstants.KEY_SCORE_EASY_2, 0);
                text_view_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_2, ""));

            }
            if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_2)) {
                score_medium_value = myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_2, 0);
                text_view_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_2, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_2)) {
                score_hard_value = myPreferences.getInt(AppConstants.KEY_SCORE_HARD_2, 0);
                text_view_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_2, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_EASY_2))
                last_score_easy_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_EASY_2, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_MEDIUM_2))
                last_score_medium_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_MEDIUM_2, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_HARD_2))
                last_score_hard_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_HARD_2, 0);


        } else if (test_num == 2) {
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_3)) {
                text_view_last_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_3, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_3)) {
                text_view_last_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_3, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_3)) {
                text_view_last_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_3, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_3)) {
                score_easy_value = myPreferences.getInt(AppConstants.KEY_SCORE_EASY_3, 0);
                text_view_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_3, ""));

            }
            if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_3)) {
                score_medium_value = myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_3, 0);
                text_view_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_3, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_3)) {
                score_hard_value = myPreferences.getInt(AppConstants.KEY_SCORE_HARD_3, 0);
                text_view_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_3, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_EASY_3))
                last_score_easy_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_EASY_3, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_MEDIUM_3))
                last_score_medium_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_MEDIUM_3, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_HARD_3))
                last_score_hard_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_HARD_3, 0);
        } else if (test_num == 3) {
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_4)) {
                text_view_last_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_4, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_4)) {
                text_view_last_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_4, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_4)) {
                text_view_last_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_4, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_4)) {
                score_easy_value = myPreferences.getInt(AppConstants.KEY_SCORE_EASY_4, 0);
                text_view_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_4, ""));

            }
            if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_4)) {
                score_medium_value = myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_4, 0);
                text_view_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_4, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_4)) {
                score_hard_value = myPreferences.getInt(AppConstants.KEY_SCORE_HARD_4, 0);
                text_view_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_4, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_EASY_4))
                last_score_easy_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_EASY_4, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_MEDIUM_4))
                last_score_medium_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_MEDIUM_4, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_HARD_4))
                last_score_hard_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_HARD_4, 0);
        } else if (test_num == 4) {
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_5)) {
                text_view_last_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_5, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_5)) {
                text_view_last_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_5, ""));
            }
            if (myPreferences.contains(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_5)) {
                text_view_last_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_5, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_5)) {
                score_easy_value = myPreferences.getInt(AppConstants.KEY_SCORE_EASY_5, 0);
                text_view_score_time_easy.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_5, ""));

            }
            if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_5)) {
                score_medium_value = myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_5, 0);
                text_view_score_time_medium.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_5, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_5)) {
                score_hard_value = myPreferences.getInt(AppConstants.KEY_SCORE_HARD_5, 0);
                text_view_score_time_hard.setText(myPreferences.getString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_5, ""));
            }


            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_EASY_5))
                last_score_easy_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_EASY_5, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_MEDIUM_5))
                last_score_medium_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_MEDIUM_5, 0);
            if (myPreferences.contains(AppConstants.KEY_LAST_SCORE_HARD_5))
                last_score_hard_value = myPreferences.getInt(AppConstants.KEY_LAST_SCORE_HARD_5, 0);
        }

        progressBar_easy_last_score.setProgressWithAnimation(
                last_score_easy_value * 100 / questionTest.QuestionTest[test_num][0].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                last_score_easy_value,
                "/" + String.valueOf(questionTest.QuestionTest[test_num][0].length),
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
                "/" + String.valueOf(questionTest.QuestionTest[test_num][1].length),
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
                "/" + String.valueOf(questionTest.QuestionTest[test_num][2].length),
                text_hard_last_score); //Анимация последнего результата в цифрах
        startScoreAnimationEasy(
                0,
                last_score_hard_value * 100 / questionTest.QuestionTest[test_num][2].length,
                "%",
                text_percent_hard_last_score); //Анимация последнего результата в процентах

        //Анимации с рекордом
        progressBar_easy_score.setProgressWithAnimation(
                score_easy_value * 100 / questionTest.QuestionTest[test_num][0].length, (long) 1000);
        startScoreAnimationEasy(
                0,
                score_easy_value,
                "/" + String.valueOf(questionTest.QuestionTest[test_num][0].length),
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
                "/" + String.valueOf(questionTest.QuestionTest[test_num][1].length),
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
                "/" + String.valueOf(questionTest.QuestionTest[test_num][2].length),
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
                cardView_medium.setEnabled(false);
                cardView_hard.setEnabled(false);
                AppConstants.map_difficult.put("Difficult", 1);
                startActivity(intent);
                finish();
                break;
            case R.id.cardView_medium:
                cardView_easy.setEnabled(false);
                cardView_hard.setEnabled(false);
                AppConstants.map_difficult.put("Difficult", 2);
                startActivity(intent);
                finish();
                break;
            case R.id.cardView_hard:
                SharedPreferences myPreferences
                        = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor myEditor = myPreferences.edit();

                if (!myPreferences.contains("hard" + test_num)) {
                    myEditor.putString("hard" + test_num, "0");
                    myEditor.apply();
                }


                Log.d("myLogs", "ПЕРВОЕ ВЫПОЛЕНО");
                if (myPreferences.getString("hard" + test_num, "") == "0") {
                    Log.d("myLogs", "ВТОРОЕ ВЫПОЛЕНО");
                    AlertDialog.Builder a_builder1 = new AlertDialog.Builder(Activity_term_test.this);
                    a_builder1.setMessage(getResources().getString(R.string.text_alert_rating))
                            .setCancelable(true)
                            .setPositiveButton(getResources().getString(R.string.text_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Log.d("myLogs", String.valueOf(chronometer_test_term.getText().toString()));
                                    cardView_easy.setEnabled(false);
                                    cardView_medium.setEnabled(false);
                                    AppConstants.map_difficult.put("Difficult", 3);
                                    Intent intent = new Intent(Activity_term_test.this, Activity_quiz_term.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setNegativeButton(getResources().getString(R.string.text_no), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = a_builder1.create();
                    alert.setTitle("");
                    alert.show();
                } else {
                    cardView_easy.setEnabled(false);
                    cardView_medium.setEnabled(false);
                    AppConstants.map_difficult.put("Difficult", 3);
                    Intent intent1 = new Intent(Activity_term_test.this, Activity_quiz_term.class);
                    startActivity(intent1);
                    finish();
                }


//                startActivity(intent);
//                finish();
                break;
        }
    }


}