package com.example.pyatiminutka.ui.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.example.pyatiminutka.MainActivity;
import com.example.pyatiminutka.Models.Adapters.SettingsListAdapter;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.tests.Activity_term_test;

public class ActivitySettings extends AppCompatActivity {


    private LinearLayout purple_background, dark_background;
    private View purple_circle, dark_circle;

    private RecyclerView recyclerView_settings;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        setContentView(R.layout.activity_settings);

        findById();

        settingsToolBar();

        dark_circle.getBackground().setColorFilter(this.getResources().getColor(R.color.colorPrimaryNight), PorterDuff.Mode.SRC_ATOP);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_settings.setLayoutManager(linearLayoutManager);
        SettingsListAdapter adapter = new SettingsListAdapter(this,
                QuestionTest.settings_text, QuestionTest.settings_icon);
        recyclerView_settings.setAdapter(adapter);
        recyclerView_settings.setFocusable(false);
        recyclerView_settings.setNestedScrollingEnabled(false);


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

    private void findById() {
        purple_background = findViewById(R.id.purple_background);
        purple_circle = findViewById(R.id.purple_circle);
        dark_background = findViewById(R.id.dark_background);
        dark_circle = findViewById(R.id.dark_circle);

        recyclerView_settings = findViewById(R.id.recyclerView_settings);

        toolbar=findViewById(R.id.toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish(); //finish Activity.
        }
        return super.onOptionsItemSelected(item);
    }

    private void settingsToolBar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}