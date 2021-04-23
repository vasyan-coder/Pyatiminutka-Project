package com.example.pyatiminutka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.pyatiminutka.Models.Adapters.AchievementsAdapter;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.items.AchievementsItem;
import com.example.pyatiminutka.ui.result.Activity_result_term;
import com.example.pyatiminutka.ui.tests.Activity_term_test;

import java.util.ArrayList;

public class ActivityAchievements extends AppCompatActivity {

    private RecyclerView recycler_achievements;

    private ArrayList<AchievementsItem> arrayList;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        toolbar = findViewById(R.id.toolbar5);
        toolbar.setTitle("Достижения");

        //Настройка toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        listAdd();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recycler_achievements = findViewById(R.id.recycler_achievements);
        AchievementsAdapter adapter = new AchievementsAdapter(arrayList, this);
        recycler_achievements.setLayoutManager(layoutManager);
        recycler_achievements.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler_achievements.getContext(),
                layoutManager.getOrientation());
        recycler_achievements.addItemDecoration(dividerItemDecoration);
    }

    private void listAdd(){
        arrayList = new ArrayList<>();
        arrayList.add(new AchievementsItem("Зелёный юнец", "пройти хотя-бы один тест"));
        arrayList.add(new AchievementsItem("Знаток теромодинамики", "выполнить тест по термодинамике на 100% на сложности “Тяжело”"));
        arrayList.add(new AchievementsItem("Знаток механики", "выполнить тест по механике на 100% на сложности “Тяжело”"));
        arrayList.add(new AchievementsItem("Знаток электродинамики", "выполнить тест по электродинамике на 100% на сложности “Тяжело”"));
        arrayList.add(new AchievementsItem("Знаток оптики", "выполнить тест по оптике на 100% на сложности “Тяжело”"));
        arrayList.add(new AchievementsItem("Знаток квантовой физики", "выполнить тест по квантовой физике на 100% на сложности “Тяжело”"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish(); //finish Activity.
        }
        return super.onOptionsItemSelected(item);
    }
}