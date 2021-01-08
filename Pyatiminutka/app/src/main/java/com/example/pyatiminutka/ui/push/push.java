package com.example.pyatiminutka.ui.push;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.R;

public class push extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Проверка установленной темы
        LoadTheme loadTheme = new LoadTheme();
        loadTheme.LoadTheme(this);

        setContentView(R.layout.activity_push);
    }
}