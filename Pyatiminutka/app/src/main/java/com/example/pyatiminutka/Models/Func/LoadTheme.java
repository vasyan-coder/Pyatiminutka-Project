package com.example.pyatiminutka.Models.Func;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.pyatiminutka.R;

public class LoadTheme extends Activity {

    public static void LoadTheme(Context context) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            context.setTheme(R.style.AppDarkTheme);
        } else {
            context.setTheme(R.style.AppTheme);
        }
    }

}
