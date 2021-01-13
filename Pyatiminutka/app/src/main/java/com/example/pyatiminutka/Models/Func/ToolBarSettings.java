package com.example.pyatiminutka.Models.Func;

import android.app.Activity;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class ToolBarSettings extends AppCompatActivity {
    public void SettingsToolBar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
