package com.example.pyatiminutka.ui.tests;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.Func.ToolBarSettings;
import com.example.pyatiminutka.ui.result.Activity_result_term;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.pagetabsother.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

public class Activity_quiz_term extends AppCompatActivity {

    public ViewPager viewPager;
    public TabLayout tabs;

    private Chronometer chronometer_test_term;


    private long timerTime = Long.MIN_VALUE;
    private long timerTime1;
    private long timerTime2;

    private Toolbar toolbar;

    private CardView button_finish;
    private ImageView button_back;

    private TextView text_title_test;

    private QuestionTest questionTest = new QuestionTest();

    private final int test_num = AppConstants.map_test_number.get("test_num");
    private final int difficult = AppConstants.map_difficult.get("Difficult") - 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        fClearAnswers(); //очистка выбранных ответов

        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        setContentView(R.layout.activity_quiz_term);

        findById();

        text_title_test.setText(QuestionTest.Question_title[test_num]);

        //Настройка табов
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(questionTest.QuestionTest[test_num][difficult].length); //Не обновлять табы при переключении
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        //Настройка таймера перед запуском
        chronometer_test_term.setBase(SystemClock.elapsedRealtime());

        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder1 = new AlertDialog.Builder(Activity_quiz_term.this);
                a_builder1.setMessage("Вы хотите завершить тест?")
                        .setCancelable(true)
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer_test_term.getBase();
                                chronometer_test_term.stop();
                                Intent intent = new Intent(Activity_quiz_term.this, Activity_result_term.class);
                                intent.putExtra(AppConstants.KEY_INTENT_TIME_TEXT, chronometer_test_term.getText().toString());
                                intent.putExtra(AppConstants.KEY_INTENT_TIME_MLS, elapsedMillis);
                                Log.d("myLogs", "Полученное время " + elapsedMillis);

                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder1.create();
                alert.setTitle("Завершение теста");
                alert.show();
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitAlert();
            }
        });

        //Запуск таймера
        chronometer_test_term.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.end_test) {
            AlertDialog.Builder a_builder1 = new AlertDialog.Builder(Activity_quiz_term.this);
            a_builder1.setMessage("Вы хотите завершить тест?")
                    .setCancelable(true)
                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            chronometer_test_term.stop();
                            //Log.d("myLogs", String.valueOf(chronometer_test_term.getText().toString()));
                            Intent intent = new Intent(Activity_quiz_term.this, Activity_result_term.class);
                            intent.putExtra("time", chronometer_test_term.getText().toString());
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = a_builder1.create();
            alert.setTitle("Завершение теста");
            alert.show();
        } else if (id == android.R.id.home) {
            //Место для уточнения выхода
            exitAlert();

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //Место для уточнения выхода
        exitAlert();
    }


    private void findById() {
        viewPager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        chronometer_test_term = findViewById(R.id.chronometer_test_term);
        toolbar = findViewById(R.id.toolbar);
        button_finish = findViewById(R.id.button_finish);
        button_back = findViewById(R.id.button_back);
        text_title_test = findViewById(R.id.text_title_test);
    }

    private void exitAlert() {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(Activity_quiz_term.this);
        a_builder.setMessage("При выходе из незаконченного теста данные не сохраняются")
                .setCancelable(true)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent refresh = new Intent(Activity_quiz_term.this, Activity_term_test.class);
                        startActivity(refresh);//Start the same Activity
                        finish(); //finish Activity.
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Закрытие теста");
        alert.show();
    }

    private void fClearAnswers() {
        Arrays.fill(QuestionTest.results, 0);
        Arrays.fill(QuestionTest.incorrect_results, 0);
        Arrays.fill(QuestionTest.choosed_answers1, 0);
        Arrays.fill(QuestionTest.choosed_answers2, 0);
        Arrays.fill(QuestionTest.choosed_answers3, 0);
        Arrays.fill(QuestionTest.choosed_answers4, 0);
        for (int i = 0; i < questionTest.QuestionTest[test_num][difficult].length; i++) {
            QuestionTest.skip_answers[i] = 1;
        }

    }

}