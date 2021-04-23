package com.example.pyatiminutka.Models.items;

import android.graphics.drawable.Drawable;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class formulasItem {
    private String title_theme;
    private String subtitle_theme;
    private String description;
    private int formula;
    private List<String> mFormulas;
    private Boolean expanded;
    private String tag;
    private CharSequence fraction;
    private CharSequence whole;


    public formulasItem(String subtitle_theme, String title_theme, int formula, String description, String tag) {
        this.title_theme = title_theme;
        this.subtitle_theme = subtitle_theme;
        this.formula = formula;
        this.description = description;
        this.tag = tag;
    }

    public Boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

//    public List<String> getText_formulas() {
//        return mFormulas;
//    }

    public void setText_formulas(List<String> mFormulas) {
        this.mFormulas = mFormulas;
    }

    public String getTitle_theme() {
        return title_theme;
    }

    public void setTitle_theme(String title_theme) {
        this.title_theme = title_theme;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFormula() {
        return formula;
    }

    public void setFormula(int formula) {
        this.formula = formula;
    }

    public String getSubtitle_theme() {
        return subtitle_theme;
    }

    public void setSubtitle_theme(String subtitle_theme) {
        this.subtitle_theme = subtitle_theme;
    }
}
