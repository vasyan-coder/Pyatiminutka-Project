package com.example.pyatiminutka.ui.result;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pyatiminutka.Models.Adapters.ResultListAdapter;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.items.UserBool;
import com.example.pyatiminutka.Models.items.UserItem;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.profile.ProfileFragment;
import com.example.pyatiminutka.ui.tests.Activity_term_test;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Activity_result_term extends AppCompatActivity {

    private static final int UNBOUNDED = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

    private int count_correct_answers = 0;
    private int count_incorrect_answers = 0;
    private int count_skip_answers = 0;

    //Информация о тетсе
    private final int difficult = AppConstants.map_difficult.get("Difficult") - 1;
    private final int test_num = AppConstants.map_test_number.get("test_num");

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

    private NestedScrollView nestedScrollView;
    private ResultListAdapter resultListAdapter;
    private RecyclerView recyclerView;

    private ImageView imageView_win_cup;

    private Toolbar toolbar;

    private String time_str;
    private long time_long;

    private final QuestionTest questionTest = new QuestionTest();

    private int[] mQuestions_easy = questionTest.QuestionTest[test_num][0];

    private int[] mQuestions_medium = questionTest.QuestionTest[test_num][1];

    private int[] mQuestions_hard = questionTest.QuestionTest[test_num][2];

    int[] mIcons = {R.drawable.ic_baseline_done_green_48, R.drawable.ic_baseline_cross_24};

    private final QuestionTest questionTest1 = new QuestionTest();


    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    private DatabaseReference databaseReference;
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        setContentView(R.layout.activity_result_term);


        findById();

        toolbar.setTitle(QuestionTest.Question_title[test_num]);

        //Настройка toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

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

        recyclerView.setFocusable(false);

        //Получение времени
        Intent intent = getIntent();
        time_str = intent.getStringExtra(AppConstants.KEY_INTENT_TIME_TEXT);
        test_time.append(" " + time_str);

        time_long = intent.getLongExtra(AppConstants.KEY_INTENT_TIME_MLS, 0);

//        Log.d("myLogs", "Массив правильных результатов" + Arrays.toString(QuestionTest.results));
//        Log.d("myLogs", "Массив неправильных результатов" + Arrays.toString(QuestionTest.incorrect_results));

        //Установка нового рекорда




        viewHeaderInf(); //Блок с выводом основной информацией

        notificationViewNewScore(); //Блок, уведомляющий о новом рекорде

        saveTestInf(); //Сохранение информации

        //Проверка достижений
        //Shared Pref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor myEditor = myPreferences.edit();

        //int progress = myPreferences.getInt(AppConstants.KEY_2_ACHIEVEMENT,0);
//        Log.d("myLogs", "Код выполнен true" + progress);


        //Диаграмма
        count_correct_answers = count_correct_answers * 100 / questionTest.QuestionTest[test_num][difficult].length;
        count_incorrect_answers = count_incorrect_answers * 100 / questionTest.QuestionTest[test_num][difficult].length;
        Log.d("myLogs", String.valueOf(count_skip_answers) + " " + String.valueOf(questionTest.QuestionTest[test_num][difficult].length));
        count_skip_answers = count_skip_answers * 100 / questionTest.QuestionTest[test_num][difficult].length;

        text_percent_right.append(" - " + count_correct_answers + "%");
        text_percent_wrong.append(" - " + count_incorrect_answers + "%");
        text_percent_skip.append(" - " + count_skip_answers + "%");

        progress_right.setProgressWithAnimation(count_correct_answers, (long) 1000);
        if (count_incorrect_answers != 0)
            progress_wrong.setProgressWithAnimation(count_incorrect_answers + count_correct_answers, (long) 800);
        if (count_skip_answers != 0)
            progress_skip.setProgressWithAnimation(100, (long) 600);


        //Запись и проверка достижений
        if (!myPreferences.contains(AppConstants.KEY_1_ACHIEVEMENT)) {
            myEditor.putInt(AppConstants.KEY_1_ACHIEVEMENT, 1);
        }
        if (test_num == 0 && difficult == 2) {
            if (!myPreferences.contains(AppConstants.KEY_2_ACHIEVEMENT)) {
                int progress = count_correct_answers * questionTest.QuestionTest[test_num][difficult].length / 100;
                Log.d("myLogs", "Код выполнен if " + count_correct_answers);
                myEditor.putInt(AppConstants.KEY_2_ACHIEVEMENT, count_correct_answers);
            } else {
                Log.d("myLogs", "Код выполнен else");
                if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_2_ACHIEVEMENT, 0)) {
                    myEditor.putInt(AppConstants.KEY_2_ACHIEVEMENT, count_correct_answers);
                }
            }
        } else if (test_num == 1 && difficult == 2){
            if (!myPreferences.contains(AppConstants.KEY_3_ACHIEVEMENT)) {
                int progress = count_correct_answers * questionTest.QuestionTest[test_num][difficult].length / 100;
                Log.d("myLogs", "Код выполнен if " + count_correct_answers);
                myEditor.putInt(AppConstants.KEY_3_ACHIEVEMENT, count_correct_answers);
            } else {
                Log.d("myLogs", "Код выполнен else");
                if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_3_ACHIEVEMENT, 0)) {
                    myEditor.putInt(AppConstants.KEY_3_ACHIEVEMENT, count_correct_answers);
                }
            }
        } else if (test_num == 2 && difficult == 2){
            if (!myPreferences.contains(AppConstants.KEY_4_ACHIEVEMENT)) {
                int progress = count_correct_answers * questionTest.QuestionTest[test_num][difficult].length / 100;
                Log.d("myLogs", "Код выполнен if " + count_correct_answers);
                myEditor.putInt(AppConstants.KEY_4_ACHIEVEMENT, count_correct_answers);
            } else {
                Log.d("myLogs", "Код выполнен else");
                if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_4_ACHIEVEMENT, 0)) {
                    myEditor.putInt(AppConstants.KEY_4_ACHIEVEMENT, count_correct_answers);
                }
            }
        } else if (test_num == 3 && difficult == 2){
            if (!myPreferences.contains(AppConstants.KEY_5_ACHIEVEMENT)) {
                int progress = count_correct_answers * questionTest.QuestionTest[test_num][difficult].length / 100;
                Log.d("myLogs", "Код выполнен if " + count_correct_answers);
                myEditor.putInt(AppConstants.KEY_5_ACHIEVEMENT, count_correct_answers);
            } else {
                Log.d("myLogs", "Код выполнен else");
                if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_5_ACHIEVEMENT, 0)) {
                    myEditor.putInt(AppConstants.KEY_5_ACHIEVEMENT, count_correct_answers);
                }
            }
        } else if (test_num == 4 && difficult == 2){
            if (!myPreferences.contains(AppConstants.KEY_6_ACHIEVEMENT)) {
                int progress = count_correct_answers * questionTest.QuestionTest[test_num][difficult].length / 100;
                Log.d("myLogs", "Код выполнен if " + count_correct_answers);
                myEditor.putInt(AppConstants.KEY_6_ACHIEVEMENT, count_correct_answers);
            } else {
                Log.d("myLogs", "Код выполнен else");
                if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_6_ACHIEVEMENT, 0)) {
                    myEditor.putInt(AppConstants.KEY_6_ACHIEVEMENT, count_correct_answers);
                }
            }
        } else if (test_num == 5 && difficult == 2){
            if (!myPreferences.contains(AppConstants.KEY_7_ACHIEVEMENT)) {
                int progress = count_correct_answers * questionTest.QuestionTest[test_num][difficult].length / 100;
                myEditor.putInt(AppConstants.KEY_7_ACHIEVEMENT, count_correct_answers);
            } else {
                if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_7_ACHIEVEMENT, 0)) {
                    myEditor.putInt(AppConstants.KEY_7_ACHIEVEMENT, count_correct_answers);
                }
            }
        }

        myEditor.apply();

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
        nestedScrollView = findViewById(R.id.scroll_guide_answers);

        text_new_record = findViewById(R.id.text_new_record);
        text_result_correct_ans = findViewById(R.id.text_result_correct_ans);
        text_result_incorrect_ans = findViewById(R.id.text_result_incorrect_ans);
        text_result_skip_ans = findViewById(R.id.text_result_skip_ans);
        imageView_win_cup = findViewById(R.id.imageView_win_cup);
        recyclerView = findViewById(R.id.list_view1); //Список
        test_time = findViewById(R.id.test_time); //Таймер
        //test_name_final = findViewById(R.id.test_name_final); //Вывод уровня сложности

        //test_title = findViewById(R.id.test_title);

        //Статистика
        text_percent_right = findViewById(R.id.text_percent_right);
        text_percent_wrong = findViewById(R.id.text_percent_wrong);
        text_percent_skip = findViewById(R.id.text_percent_skip);
        progress_right = findViewById(R.id.progress_right);
        progress_wrong = findViewById(R.id.progress_wrong);
        progress_skip = findViewById(R.id.progress_skip);

        toolbar = findViewById(R.id.toolbar3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent refresh = new Intent(Activity_result_term.this, Activity_term_test.class);
            startActivity(refresh);//Start the same Activity
            finish(); //finish Activity.
        }
        return super.onOptionsItemSelected(item);
    }

    private void viewHeaderInf() {
        //Кол-во правильных ответов
        for (int i1 = 0; i1 < questionTest1.QuestionTest[test_num][difficult].length; i1++) {
            if (QuestionTest.results[i1] == 1) {
                count_correct_answers += 1;
            }
        }
        text_result_correct_ans.setText(String.valueOf(count_correct_answers));

        //Кол-во пропущенных ответов
        for (int i2 = 0; i2 < QuestionTest.skip_answers.length; i2++) {
            count_skip_answers += QuestionTest.skip_answers[i2];
        }
        text_result_skip_ans.setText(String.valueOf(count_skip_answers));

        //Кол-во непраильных результатов
        for (int i3 = 0; i3 < QuestionTest.incorrect_results.length; i3++) {
            count_incorrect_answers += QuestionTest.incorrect_results[i3];
        }
        text_result_incorrect_ans.setText(String.valueOf(count_incorrect_answers));

        //Вывод уровня сложности и заголовка
//        if (difficult == 0) {
//            ti_name_final.setText("(" + getResources().getString(R.string.text_difficult_easy2) + ")");
//        } else if (difficult == 1) {
//            test_name_final.setText("(" + getResources().getString(R.string.text_difficult_medium2) + ")");
//        }
//        if (difficult == 2) {
//            test_name_final.setText("(" + getResources().getString(R.string.text_difficult_hard2) + ")");
//        }
//
//        test_title.setText(QuestionTest.Question_title[test_num]);
    }

    private void notificationViewNewScore() {
        //Shared Pref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor myEditor = myPreferences.edit();


        if (test_num == 0) {
            if (difficult == 0) {

                if (myPreferences.contains("score_easy")) {
                    if (count_correct_answers == myPreferences.getInt("score_easy", 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt("score_easy", 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt("score_easy", 0)) {
                        myEditor.putInt("score_easy", count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_1, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_1, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt("score_easy", count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_1, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_1, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 1) {


                if (myPreferences.contains("score_medium")) {
                    if (count_correct_answers == myPreferences.getInt("score_medium", 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt("score_medium", 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt("score_medium", 0)) {
                        myEditor.putInt("score_medium", count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_1, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_1, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt("score_medium", count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_1, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_1, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 2) {

                if (myPreferences.contains("score_hard")) {
                    if (count_correct_answers == myPreferences.getInt("score_hard", 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers <= myPreferences.getInt("score_hard", 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt("score_hard", 0)) {
                        myEditor.putInt("score_hard", count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_1, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_1, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt("score_hard", count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_1, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_1, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }
                if (myPreferences.getString("hard" + test_num, "").equals("0") && count_correct_answers != 0 ) {
                    Log.d("myLogs", "ВЫПОЛНИЛОСЬ " + myPreferences.getString("hard" + test_num, ""));
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                    DatabaseReference database = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User");

                    firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    //Проверка записи
                    //DatabaseReference database1 = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User1").child(id);

                    firebaseAuth = FirebaseAuth.getInstance();
                    if (firebaseUser != null){
                        String id = firebaseUser.getUid();
                        String name = firebaseUser.getDisplayName();
                        Glide.with(Activity_result_term.this);

                        UserItem userItem = new UserItem(id, name, count_correct_answers);
                        database.child(id).setValue(userItem);
                    }
                } else if (count_correct_answers == 0 & myPreferences.getString("hard"+test_num, "") == "0") {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                }

//                if (count_correct_answers != 0) {
//
//                    DatabaseReference database = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User1");
//                    firebaseAuth = FirebaseAuth.getInstance();
//                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//
//                    if (firebaseUser != null){
//                        String id = firebaseUser.getUid();
//                        String name = firebaseUser.getDisplayName();
//                        Glide.with(Activity_result_term.this);
////                        DatabaseReference myRef2 = database.getReference(id);
//
//                        UserItem userItem = new UserItem(id, name, String.valueOf(count_correct_answers));
//                        database.setValue(userItem);
//                    }
//                }
            }
        } else if (test_num == 1) {
            if (difficult == 0) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_2)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_EASY_2, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_EASY_2, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_EASY_2, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_EASY_2, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_2, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_2, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_EASY_2, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_2, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_2, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 1) {


                if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_2)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_2, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_2, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_2, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_2, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_2, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_2, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_2, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_2, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_2, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 2) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_2)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_HARD_2, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers <= myPreferences.getInt(AppConstants.KEY_SCORE_HARD_2, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_HARD_2, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_HARD_2, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_2, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_2, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_HARD_2, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_2, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_2, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

                if (count_correct_answers != 0 && (myPreferences.getString("hard"+test_num, "") == "0")) {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                    Log.d("myLogs", "ВЫПОЛНИЛОСЬ " + "hard"+test_num);
                    DatabaseReference database = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User1");

                    firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    //Проверка записи
                    //DatabaseReference database1 = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User1").child(id);

                    firebaseAuth = FirebaseAuth.getInstance();
                    if (firebaseUser != null){
                        String id = firebaseUser.getUid();
                        String name = firebaseUser.getDisplayName();
                        Glide.with(Activity_result_term.this);

                        UserItem userItem = new UserItem(id, name, count_correct_answers);
                        database.child(id).setValue(userItem);
                    }
                } else if (count_correct_answers == 0 & myPreferences.getString("hard"+test_num, "") == "0") {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                }

            }
        } else if (test_num == 2) {
            if (difficult == 0) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_3)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_EASY_3, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_EASY_3, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_EASY_3, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_EASY_3, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_3, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_3, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_EASY_3, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_3, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_3, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 1) {


                if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_3)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_3, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_3, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_3, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_3, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_3, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_3, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_3, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_3, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_3, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 2) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_3)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_HARD_3, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers <= myPreferences.getInt(AppConstants.KEY_SCORE_HARD_3, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_HARD_3, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_HARD_3, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_3, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_3, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_HARD_3, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_3, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_3, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

                if (count_correct_answers != 0 && (myPreferences.getString("hard"+test_num, "") == "0")) {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                    DatabaseReference database = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User2");

                    firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    //Проверка записи
                    //DatabaseReference database1 = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User1").child(id);

                    firebaseAuth = FirebaseAuth.getInstance();
                    if (firebaseUser != null){
                        String id = firebaseUser.getUid();
                        String name = firebaseUser.getDisplayName();
                        Glide.with(Activity_result_term.this);

                        UserItem userItem = new UserItem(id, name, count_correct_answers);
                        database.child(id).setValue(userItem);
                    }
                } else if (count_correct_answers == 0 & myPreferences.getString("hard"+test_num, "") == "0") {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                }

            }
        } else if (test_num == 3) {
            if (difficult == 0) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_4)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_EASY_4, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_EASY_4, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_EASY_4, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_EASY_4, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_4, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_4, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_EASY_4, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_4, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_4, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 1) {


                if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_4)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_4, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_4, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_4, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_4, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_4, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_4, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_4, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_4, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_4, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 2) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_4)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_HARD_4, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers <= myPreferences.getInt(AppConstants.KEY_SCORE_HARD_4, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_HARD_4, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_HARD_4, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_4, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_4, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_HARD_4, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_4, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_4, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

                if (count_correct_answers != 0 && (myPreferences.getString("hard"+test_num, "") == "0")) {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                    Log.d("myLogs", "ВЫПОЛНИЛОСЬ " + "hard"+test_num);
                    DatabaseReference database = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User3");

                    firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    //Проверка записи
                    //DatabaseReference database1 = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User1").child(id);

                    firebaseAuth = FirebaseAuth.getInstance();
                    if (firebaseUser != null){
                        String id = firebaseUser.getUid();
                        String name = firebaseUser.getDisplayName();
                        Glide.with(Activity_result_term.this);

                        UserItem userItem = new UserItem(id, name, count_correct_answers);
                        database.child(id).setValue(userItem);
                    }
                } else if (count_correct_answers == 0 & myPreferences.getString("hard"+test_num, "") == "0") {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                }
            }
        } else if (test_num == 4) {
            if (difficult == 0) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_EASY_5)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_EASY_5, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_EASY_5, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_EASY_5, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_EASY_5, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_5, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_5, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_EASY_5, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_EASY_5, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_EASY_5, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 1) {


                if (myPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_5)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_5, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers < myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_5, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_5, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_5, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_5, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_5, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_MEDIUM_5, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_MEDIUM_5, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_MEDIUM_5, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }

            } else if (difficult == 2) {

                if (myPreferences.contains(AppConstants.KEY_SCORE_HARD_5)) {
                    if (count_correct_answers == myPreferences.getInt(AppConstants.KEY_SCORE_HARD_5, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers <= myPreferences.getInt(AppConstants.KEY_SCORE_HARD_5, 0)) {
                        imageView_win_cup.setVisibility(View.GONE);
                        text_new_record.setVisibility(View.GONE);
                    } else if (count_correct_answers > myPreferences.getInt(AppConstants.KEY_SCORE_HARD_5, 0)) {
                        myEditor.putInt(AppConstants.KEY_SCORE_HARD_5, count_correct_answers);
                        myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_5, time_str);
                        myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_5, time_long);
                        myEditor.commit();
                    }
                } else if (count_correct_answers != 0) {
                    myEditor.putInt(AppConstants.KEY_SCORE_HARD_5, count_correct_answers);
                    myEditor.putString(AppConstants.KEY_MAP_STR_TIME_SCORE_HARD_5, time_str);
                    myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_SCORE_HARD_5, time_long);
                    myEditor.commit();
                } else if (count_correct_answers == 0) {
                    imageView_win_cup.setVisibility(View.GONE);
                    text_new_record.setVisibility(View.GONE);
                }
                if (count_correct_answers != 0 && (myPreferences.getString("hard"+test_num, "") == "0")) {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                    Log.d("myLogs", "ВЫПОЛНИЛОСЬ " + "hard"+test_num);
                    DatabaseReference database = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User4");

                    firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    //Проверка записи
                    //DatabaseReference database1 = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference("User1").child(id);

                    firebaseAuth = FirebaseAuth.getInstance();
                    if (firebaseUser != null){
                        String id = firebaseUser.getUid();
                        String name = firebaseUser.getDisplayName();
                        Glide.with(Activity_result_term.this);

                        UserItem userItem = new UserItem(id, name, count_correct_answers);
                        database.child(id).setValue(userItem);
                    }
                } else if (count_correct_answers == 0 & myPreferences.getString("hard"+test_num, "") == "0") {
                    myEditor.putString("hard" + test_num, "1");
                    myEditor.commit();
                }
            }
        }


        text_new_record.append(" " + String.valueOf(count_correct_answers));
    }

    private void saveTestInf() {
        //Shared Pref
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor myEditor = myPreferences.edit();

        if (test_num == 0) {
            if (difficult == 0) {
                myEditor.putInt("last_result_test_term_easy", count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_1, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_EASY_1, time_long);
                myEditor.commit();
            } else if (difficult == 1) {
                myEditor.putInt("last_result_test_term_medium", count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_1, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_MEDIUM_1, time_long);
                myEditor.commit();
            } else if (difficult == 2) {
                myEditor.putInt("last_result_test_term_hard", count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_1, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_HARD_1, time_long);
                myEditor.commit();
                Log.d("myLogs", "Сохранилось");
            }

        } else if (test_num == 1){
            if (difficult == 0) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_EASY_2, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_2, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_EASY_2, time_long);
                myEditor.commit();
            } else if (difficult == 1) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_MEDIUM_2, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_2, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_MEDIUM_2, time_long);
                myEditor.commit();
            } else if (difficult == 2) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_HARD_2, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_2, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_HARD_2, time_long);
                myEditor.commit();
                Log.d("myLogs", "Сохранилось");
            }
        } else if (test_num == 2) {
            if (difficult == 0) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_EASY_3, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_3, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_EASY_3, time_long);
                myEditor.commit();
            } else if (difficult == 1) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_MEDIUM_3, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_3, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_MEDIUM_3, time_long);
                myEditor.commit();
            } else if (difficult == 2) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_HARD_3, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_3, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_HARD_3, time_long);
                myEditor.commit();
                Log.d("myLogs", "Сохранилось");
            }
        } else if (test_num == 3) {
            if (difficult == 0) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_EASY_4, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_4, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_EASY_4, time_long);
                myEditor.commit();
            } else if (difficult == 1) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_MEDIUM_4, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_4, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_MEDIUM_4, time_long);
                myEditor.commit();
            } else if (difficult == 2) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_HARD_4, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_4, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_HARD_4, time_long);
                myEditor.commit();
                Log.d("myLogs", "Сохранилось");
            }
        } else if (test_num == 4) {
            if (difficult == 0) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_EASY_5, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_EASY_5, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_EASY_5, time_long);
                myEditor.commit();
            } else if (difficult == 1) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_MEDIUM_5, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_MEDIUM_5, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_MEDIUM_5, time_long);
                myEditor.commit();
            } else if (difficult == 2) {
                myEditor.putInt(AppConstants.KEY_LAST_SCORE_HARD_5, count_correct_answers);
                myEditor.putString(AppConstants.KEY_MAP_STR_TIME_LAST_SCORE_HARD_5, time_str);
                myEditor.putLong(AppConstants.KEY_MAP_LONG_TIME_LAST_SCORE_HARD_5, time_long);
                myEditor.commit();
                Log.d("myLogs", "Сохранилось");
            }
        }


    }


}