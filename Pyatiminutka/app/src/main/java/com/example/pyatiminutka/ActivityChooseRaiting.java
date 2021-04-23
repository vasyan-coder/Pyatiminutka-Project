package com.example.pyatiminutka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;

public class ActivityChooseRaiting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_raiting);

        ListView list_view_theme = findViewById(R.id.list_view_theme);
        final String[] themes = new String[] {
                "§1 Термодинамика", "§2 Механика", "§3 Электродинамика", "§4 Оптика", "§5 Квантовая физика"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, themes);

        list_view_theme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getApplicationContext(), TopRateActivity.class);
                    intent.putExtra("num_them", "User");
                    startActivity(intent);
                } else if (position == 1){
                    Intent intent = new Intent(getApplicationContext(), TopRateActivity.class);
                    intent.putExtra("num_them", "User1");
                    startActivity(intent);
                } else if (position == 2){
                    Intent intent = new Intent(getApplicationContext(), TopRateActivity.class);
                    intent.putExtra("num_them", "User2");
                    startActivity(intent);
                } else if (position == 3){
                    Intent intent = new Intent(getApplicationContext(), TopRateActivity.class);
                    intent.putExtra("num_them", "User3");
                    startActivity(intent);
                } else if (position == 4){
                    Intent intent = new Intent(getApplicationContext(), TopRateActivity.class);
                    intent.putExtra("num_them", "User4");
                    startActivity(intent);
                }
            }
        });

        list_view_theme.setAdapter(adapter);

//        Intent intent = new Intent(getContext(), TopRateActivity.class);
//        startActivity(intent);
    }
}