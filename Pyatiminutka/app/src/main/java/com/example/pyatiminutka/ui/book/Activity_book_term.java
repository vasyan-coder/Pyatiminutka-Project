package com.example.pyatiminutka.ui.book;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity_book_term extends AppCompatActivity {

    //    private Button enlarge;
//    private Button reduce;
    private TextView term_Text;
    private TextView page_text_counter;


    private static final String TAG = "myLogs";


    private Toolbar toolbar;

    private FloatingActionButton float_previous;
    private FloatingActionButton float_favourite;
    private FloatingActionButton float_next;

    private NestedScrollView scrollView;

    private final int num_book = AppConstants.map_book_number.get(AppConstants.KEY_MAP_BOOK_NUMBER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        //actionBar.hide();
        setContentView(R.layout.activity_book_term);

        findById();

        //Кнопка назад
        setSupportActionBar(toolbar = findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);


        term_Text = findViewById(R.id.text_term);

//        //Запись данных
//        SharedPreferences myPreferences
//                = PreferenceManager.getDefaultSharedPreferences(Activity_book_term.this);
//        float text_size = myPreferences.getFloat("text_size", 0);
//
//        //Установка раннее выбранного шрифта
//        if (myPreferences.contains("text_size")) {
//            term_Text.setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size);
//        }


        //Получение данных из предыдущего activity

        if (num_book == 0) {
            term_Text.setText(R.string.text_paragraph_thermodynamics);
            toolBarLayout.setTitle(getResources().getString(QuestionTest.Question_title[num_book]) + "\n");
            toolBarLayout.setMinimumHeight(200);
            float_previous.setVisibility(View.GONE);
        }
        if (num_book == 1) {
            term_Text.setText("1 страница МЕХАНИКА КуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУКуКуКУ123123");
            float_previous.setVisibility(View.VISIBLE);
            float_next.setVisibility(View.GONE);
        }

        float_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConstants.map_book_number.put(AppConstants.KEY_MAP_BOOK_NUMBER, num_book + 1);
                Intent intent = new Intent(getApplicationContext(), Activity_book_term.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.activity_open, R.anim.activity_close);
            }
        });

        float_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConstants.map_book_number.put(AppConstants.KEY_MAP_BOOK_NUMBER, num_book - 1);

                Intent intent = new Intent(getApplicationContext(), Activity_book_term.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.activity_open, R.anim.activity_close);
            }
        });


    }

    private void findById() {
        float_previous = findViewById(R.id.float_previous);
        float_favourite = findViewById(R.id.float_favourite);
        float_next = findViewById(R.id.float_next);

        scrollView = findViewById(R.id.scrollView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Запись данных
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(Activity_book_term.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();

//        if (id == R.id.textEnlarge) {
//            float mOriginalTextSize = term_Text.getTextSize();
//            if (mOriginalTextSize < 64) {
//                mOriginalTextSize = mOriginalTextSize + 10f;
//                term_Text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mOriginalTextSize);
//                myEditor.putFloat("text_size", mOriginalTextSize);
//                myEditor.commit();
//            } else {
//                Toast toast = Toast.makeText(Activity_book_term.this, R.string.text_max_size, Toast.LENGTH_SHORT);
//                toast.show();
//                term_Text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mOriginalTextSize);
//            }
//        } else if (id == R.id.textReduce) {
//            float mOriginalTextSize = term_Text.getTextSize();
//
//            //Log.d(TAG, "Перед проверкой уменьшения " + mOriginalTextSize);
//            if (mOriginalTextSize > 42) {
//                mOriginalTextSize = mOriginalTextSize - 10f;
//                term_Text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mOriginalTextSize);
//                myEditor.putFloat("text_size", mOriginalTextSize);
//                myEditor.commit();
//            } else {
//                Toast toast = Toast.makeText(Activity_book_term.this, R.string.text_min_size, Toast.LENGTH_SHORT);
//                toast.show();
//                term_Text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mOriginalTextSize);
//            }


        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}