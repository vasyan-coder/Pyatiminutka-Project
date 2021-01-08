package com.example.pyatiminutka.ui.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.pyatiminutka.MainActivity;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.tests.Activity_term_test;

public class ActivitySettings extends AppCompatActivity {


    private LinearLayout purple_background, dark_background;
    private View purple_circle, dark_circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Проверка установленной темы
        LoadTheme loadTheme = new LoadTheme();
        LoadTheme.LoadTheme(this);

        StatusBarColor.StatusBarColor(R.color.colorPrimary, R.color.colorPrimaryNight,this);

        setContentView(R.layout.activity_settings);

        //Кнопка назад
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        findById();

        dark_circle.getBackground().setColorFilter(this.getResources().getColor(R.color.colorPrimaryNight), PorterDuff.Mode.SRC_ATOP);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.dark_background:
                        Log.d("myLogs", "Произошёл клик");
                        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        }
                        recreate();
                        break;
                }
            }
        };

        dark_background.setOnClickListener(onClickListener);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish(); //finish Activity.
        }
        return super.onOptionsItemSelected(item);
    }

    private void findById() {
        purple_background = findViewById(R.id.purple_background);
        purple_circle = findViewById(R.id.purple_circle);
        dark_background = findViewById(R.id.dark_background);
        dark_circle = findViewById(R.id.dark_circle);
    }
}