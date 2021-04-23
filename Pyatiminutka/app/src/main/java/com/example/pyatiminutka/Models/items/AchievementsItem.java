package com.example.pyatiminutka.Models.items;

public class AchievementsItem {
    private String mTitle;
    private String mDescription;
    private int mPercent;

    public AchievementsItem(String mTitle, String mDescription){
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public int getmPercent() {
        return mPercent;
    }

    public String getmDescription() {
        return mDescription;
    }
}
