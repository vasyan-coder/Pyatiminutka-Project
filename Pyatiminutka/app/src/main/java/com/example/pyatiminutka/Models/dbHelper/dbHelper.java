package com.example.pyatiminutka.Models.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "TEST_RESULTS";
    public static final String TEST_SCORE = "TEST_SCORE";
    public static final String TEST_NUM = "TEST_NUM";
    public static final String TEST_DIFFICULT = "TEST_DIFFICULT";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TestHistory.db";

    public dbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
