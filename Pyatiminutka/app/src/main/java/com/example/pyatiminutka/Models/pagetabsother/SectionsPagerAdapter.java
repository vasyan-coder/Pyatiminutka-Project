package com.example.pyatiminutka.Models.pagetabsother;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pyatiminutka.R;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;

import com.example.pyatiminutka.ui.questions.Question10Fragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    QuestionTest questionTest = new QuestionTest();
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3,
            R.string.tab_text_4, R.string.tab_text_5, R.string.tab_text_6,
            R.string.tab_text_7, R.string.tab_text_8, R.string.tab_text_9, R.string.tab_text_10,
            R.string.tab_text_11, R.string.tab_text_12, R.string.tab_text_13, R.string.tab_text_14,
            R.string.tab_text_15, R.string.tab_text_16, R.string.tab_text_17, R.string.tab_text_18,
            R.string.tab_text_19};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle args = new Bundle();
        switch (position) {
            case 0:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 1:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 2:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 3:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 4:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 5:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 6:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 7:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 8:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 9:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 10:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 11:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 12:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 13:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 14:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 15:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 16:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 17:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            case 18:
                fragment = new Question10Fragment();
                args.putInt(AppConstants.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;


        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return questionTest.QuestionTest[AppConstants.map_test_number.get("test_num")][AppConstants.map_difficult.get("Difficult") - 1].length;
    }
}
