package com.example.pyatiminutka.ui.result;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.Adapters.ResultListAdapter;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.tests.Activity_term_test;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.Arrays;

public class Activity_result_term extends AppCompatActivity {

    private static final int UNBOUNDED = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

    private int count_correct_answers = 0;
    private int count_incorrect_answers = 0;
    private int count_skip_answers = 0;

    //Информация о тетсе
    private int difficult = AppConstants.map_difficult.get("Difficult")-1;
    private int test_num = AppConstants.map_test_number.get("test_num");

    private TextView text_new_record;
    private TextView text_result_correct_ans;
    private TextView text_result_incorrect_ans;
    private TextView text_result_skip_ans;
    private TextView test_name_final;
    private TextView test_time;
    private TextView test_title;

    //Статистика
    private TextView text_percent_right;
    private TextView text_percent_wrong;
    private TextView text_percent_skip;
    private CircularProgressBar progress_right;
    private CircularProgressBar progress_wrong;
    private CircularProgressBar progress_skip;

    private ResultListAdapter resultListAdapter;
    private RecyclerView recyclerView;

    private ConstraintLayout block_two_final_term;

    private final QuestionTest questionTest = new QuestionTest();


    private final int[] mQuestions_easy = questionTest.QuestionTest[test_num][0];

    private final int[] mQuestions_medium = questionTest.QuestionTest[test_num][1];

    private final int[] mQuestions_hard = questionTest.QuestionTest[test_num][2];

    int[] mIcons = {R.drawable.ic_baseline_done_green_48, R.drawable.ic_baseline_close_24};

    private final QuestionTest questionTest1 = new QuestionTest();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        StatusBarColor.StatusBarColor(R.color.background2, R.color.colorBackgroundBlocks, this);

        setContentView(R.layout.activity_result_term);
        findById();


        //Кнопка назад
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if (difficult == 0) {
            resultListAdapter = new ResultListAdapter(questionTest.QuestionTest[test_num][difficult].length, mQuestions_easy, mIcons, this);

            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(resultListAdapter);
        } else if (difficult == 1) {
            resultListAdapter = new ResultListAdapter(questionTest.QuestionTest[test_num][difficult].length, mQuestions_medium, mIcons, this);

            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(resultListAdapter);
        } else if (difficult == 2) {
            resultListAdapter = new ResultListAdapter(questionTest.QuestionTest[test_num][difficult].length, mQuestions_hard, mIcons, this);

            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(resultListAdapter);
        }

        //Получение времени
        Intent intent = getIntent();
        String time = intent.getStringExtra("time");
        test_time.setText(getString(R.string.text_time_pass) + " " + time);

        Log.d("myLogs", "Массив правильных результатов" + Arrays.toString(QuestionTest.results));
        Log.d("myLogs", "Массив неправильных результатов" + Arrays.toString(QuestionTest.incorrect_results));

        //Установка нового рекорда


        viewHeaderInf(); //Блок с выводом основной информацией

        notificationViewNewScore(); //Блок, уведомляющий о новом рекорде

        saveTestInf(); //Сохранение информации

        //Диаграмма
        count_correct_answers = count_correct_answers * 100 / questionTest.QuestionTest[test_num][difficult].length;
        count_incorrect_answers = count_incorrect_answers * 100 / questionTest.QuestionTest[test_num][difficult].length;
        count_skip_answers = count_skip_answers * 100 / questionTest.QuestionTest[test_num][difficult].length;

        text_percent_right.setText(getString(R.string.text_correct) + " - " + count_correct_answers + "%");
        text_percent_wrong.setText(getString(R.string.text_incorrect) + " - " + count_incorrect_answers + "%");
        text_percent_skip.setText(getString(R.string.text_skip) + " - " + count_skip_answers + "%");

        progress_right.setProgressWithAnimation(count_correct_answers, (long) 1000);
        if (count_incorrect_answers != 0)
            progress_wrong.setProgressWithAnimation(count_incorrect_answers + count_correct_answers, (long) 800);
        if (count_skip_answers != 0)
            progress_skip.setProgressWithAnimation(100, (long) 600);




    }

    @Override
    public void onBackPressed() {
        Intent refresh = new Intent(this, Activity_term_test.class);
        startActivity(refresh);//Start the same Activity
        finish(); //finish Activity.
    }

    public void click_previous1(View view) {
        Intent refresh = new Intent(this, Activity_term_test.class);
        startActivity(refresh);//Start the same Activity
        finish(); //finish Activity.
    }

    private void findById() {
        text_new_record = findViewById(R.id.text_new_record);
        text_result_correct_ans = findViewById(R.id.text_result_correct_ans);
        text_result_incorrect_ans = findViewById(R.id.text_result_incorrect_ans);
        text_result_skip_ans = findViewById(R.id.text_result_skip_ans);
        block_two_final_term = findViewById(R.id.block_two_final_term);
        recyclerView = findViewById(R.id.list_view1); //Список
        test_time = findViewById(R.id.test_time); //Таймер
        test_name_final = findViewById(R.id.test_name_final); //Вывод уровня сложностиsc

        test_title = findViewById(R.id.test_title);

        //Статистика
        text_percent_right = findViewById(R.id.text_percent_right);
        text_percent_wrong = findViewById(R.id.text_percent_wrong);
        text_percent_skip = findViewById(R.id.text_percent_skip);
        progress_right = findViewById(R.id.progress_right);
        progress_wrong = findViewById(R.id.progress_wrong);
        progress_skip = findViewById(R.id.progress_skip);
    }

    private void viewHeaderInf() {
        //Кол-во правильных ответов
        for (int i1 = 0; i1 < questionTest1.QuestionTest[test_num][difficult].length; i1++) {
            if (QuestionTest.results[i1] == 1) {
                count_correct_answers += 1;
            }
        }
        text_result_correct_ans.setText(Integer.toString(count_correct_answers));

        //Кол-во пропущенных ответов
        for (int i2 = 0; i2 < QuestionTest.skip_answers.length; i2++) {
            count_skip_answers += QuestionTest.skip_answers[i2];
        }
        text_result_skip_ans.setText(Integer.toString(count_skip_answers));

        //Кол-во непраильных результатов
        for (int i3 = 0; i3 < QuestionTest.incorrect_results.length; i3++) {
            count_incorrect_answers += QuestionTest.incorrect_results[i3];
        }
        text_result_incorrect_ans.setText(Integer.toString(count_incorrect_answers));

        //Вывод уровня сложности и заголовка
        if (difficult == 0) {
            test_name_final.setText("("+ getResources().getString(R.string.text_difficult_easy2) + ")");
        } else if (difficult == 1) {
            test_name_final.setText("("+ getResources().getString(R.string.text_difficult_medium2) + ")");
        }
        if (difficult == 2) {
            test_name_final.setText("("+ getResources().getString(R.string.text_difficult_hard2) + ")");
        }

        test_title.setText(QuestionTest.Question_title[test_num]);
    }

    private void notificationViewNewScore() {
        //Shared Pref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor myEditor = myPreferences.edit();


        if (difficult== 0) {

            if (myPreferences.contains("score_easy")) {
                if (count_correct_answers == myPreferences.getInt("score_easy", 0)) {
                    block_two_final_term.setVisibility(View.GONE);
                } else if (count_correct_answers < myPreferences.getInt("score_easy", 0)) {
                    block_two_final_term.setVisibility(View.GONE);
                } else if (count_correct_answers > myPreferences.getInt("score_easy", 0)) {
                    myEditor.putInt("score_easy", count_correct_answers);
                    myEditor.commit();
                }
            } else if (count_correct_answers != 0) {
                myEditor.putInt("score_easy", count_correct_answers);
                myEditor.commit();
            } else if (count_correct_answers == 0) {
                block_two_final_term.setVisibility(View.GONE);
            }

        } else if (difficult == 1) {


            if (myPreferences.contains("score_medium")) {
                if (count_correct_answers == myPreferences.getInt("score_medium", 0)) {
                    block_two_final_term.setVisibility(View.GONE);
                } else if (count_correct_answers < myPreferences.getInt("score_medium", 0)) {
                    block_two_final_term.setVisibility(View.GONE);
                } else if (count_correct_answers > myPreferences.getInt("score_medium", 0)) {
                    myEditor.putInt("score_medium", count_correct_answers);
                    myEditor.commit();
                }
            } else if (count_correct_answers != 0) {
                myEditor.putInt("score_medium", count_correct_answers);
                myEditor.commit();
            } else if (count_correct_answers == 0) {
                block_two_final_term.setVisibility(View.GONE);
            }

        } else if (difficult == 2) {

            if (myPreferences.contains("score_hard")) {
                if (count_correct_answers == myPreferences.getInt("score_hard", 0)) {
                    block_two_final_term.setVisibility(View.GONE);
                } else if (count_correct_answers <= myPreferences.getInt("score_hard", 0)) {
                    block_two_final_term.setVisibility(View.GONE);
                } else if (count_correct_answers > myPreferences.getInt("score_hard", 0)) {
                    myEditor.putInt("score_hard", count_correct_answers);
                    myEditor.commit();
                }
            } else if (count_correct_answers != 0) {
                myEditor.putInt("score_hard", count_correct_answers);
                myEditor.commit();
            } else if (count_correct_answers == 0) {
                block_two_final_term.setVisibility(View.GONE);
            }

        }
        text_new_record.setText(String.valueOf(count_correct_answers));
    }

    private void saveTestInf() {
        //Shared Pref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor myEditor = myPreferences.edit();

        if (difficult == 0) {
            myEditor.putInt("last_result_test_term_easy", count_correct_answers);
            myEditor.apply();
        } else if (difficult == 1) {
            myEditor.putInt("last_result_test_term_medium", count_correct_answers);
            myEditor.commit();
        } else if (difficult == 2) {
            myEditor.putInt("last_result_test_term_hard", count_correct_answers);
            myEditor.commit();
        }
    }
}