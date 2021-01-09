package com.example.pyatiminutka.ui.tests;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Chronometer;
import androidx.appcompat.widget.Toolbar;

import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.ui.result.Activity_result_term;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.pagetabsother.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Activity_quiz_term extends AppCompatActivity {

    public ViewPager viewPager;
    public TabLayout tabs;

    private Chronometer chronometer_test_term;

    private int difficult;

    private long timerTime = Long.MIN_VALUE;
    private long timerTime1;
    private long timerTime2;

    private Toolbar toolbar;

    private QuestionTest questionTest = new QuestionTest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        fClearAnswers(); //очистка выбранных ответов

        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        StatusBarColor.StatusBarColor(R.color.colorPrimary, R.color.colorPrimaryNight,this);

        setContentView(R.layout.activity_quiz_term);

        findById();

        settingsToolBar();

        //Настройка табов
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(questionTest.QuestionTest[AppConstants.map_test_number.get("test_num")][AppConstants.map_difficult.get("Difficult")-1].length); //Не обновлять табы при переключении
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        //Запуск таймера
        chronometer_test_term.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
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
        } else if (id == android.R.id.home){
            //Место для уточнения выхода
            exitAlert();

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        //Место для уточнения выхода
        exitAlert();
    }

    private void fClearAnswers(){
        for (int i = 0; i < QuestionTest.results.length; i++){
            QuestionTest.results[i] = 0;
        }
        for (int i = 0; i < QuestionTest.incorrect_results.length; i++){
            QuestionTest.incorrect_results[i] = 0;
        }
        for (int i = 0; i < QuestionTest.choosed_answers1.length; i++){
            QuestionTest.choosed_answers1[i] = 0;
        }
        for (int i = 0; i < QuestionTest.choosed_answers2.length; i++){
            QuestionTest.choosed_answers2[i] = 0;
        }
        for (int i = 0; i < QuestionTest.choosed_answers3.length; i++){
            QuestionTest.choosed_answers3[i] = 0;
        }
        for (int i = 0; i < questionTest.choosed_answers4.length; i++){
            QuestionTest.choosed_answers4[i] = 0;
        }
        for (int i = 0; i < questionTest.QuestionTest[AppConstants.map_test_number.get("test_num")][AppConstants.map_difficult.get("Difficult")-1].length; i++){
            QuestionTest.skip_answers[i] = 1;
        }
    }

    private void settingsToolBar(){
        setSupportActionBar(toolbar);
        //Кнопка назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void findById() {
        viewPager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        chronometer_test_term = findViewById(R.id.chronometer_test_term);
        toolbar = findViewById(R.id.toolbar);
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

}