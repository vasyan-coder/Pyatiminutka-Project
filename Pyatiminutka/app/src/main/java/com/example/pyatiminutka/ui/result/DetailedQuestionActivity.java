package com.example.pyatiminutka.ui.result;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.result.Activity_result_term;
import com.example.pyatiminutka.ui.tests.Activity_term_test;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DetailedQuestionActivity extends AppCompatActivity {

    private ImageView text_change;

    private int position;

    private TextView text_num_question_detailed;
    private TextView text_correct_detailed;
    private TextView text_question_detailed;
    private TextView text_detailed;
    private LinearLayout frame_correct_detailed;

    private ImageView image_correct_detailed;
    private ImageView image_question;

    private Toolbar toolbar;

    int[] mIcons = {R.drawable.ic_baseline_done_green_48, R.drawable.ic_baseline_cross_24};

    private QuestionTest questionTest = new QuestionTest();

    private final int test_num = AppConstants.map_test_number.get("test_num");

    private final int difficult = AppConstants.map_difficult.get("Difficult") - 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_question);
        findById();

//        text_change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
//                        getApplicationContext(), R.style.Theme_Design_BottomSheetDialog
//                );
//                View bottomSheetView = LayoutInflater.from(getApplicationContext())
//                        .inflate(
//                                R.layout.bottom_sheet_font,
//                                (ConstraintLayout)findViewById(R.id.bottom_sheet_container)
//                        );
//                bottomSheetView.findViewById(R.id.text_change).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        bottomSheetDialog.dismiss();
//                    }
//                });
//                bottomSheetDialog.setContentView(bottomSheetView);
//                bottomSheetDialog.show();
//            }
//        });

        Intent intent = getIntent();

        position = intent.getIntExtra("position", 0);
        Log.d("myLogs", String.valueOf(position));
        text_num_question_detailed.setText(String.valueOf(position + 1));

        text_detailed.setText(getText(questionTest.Question_Detailed[test_num][difficult][position]));

        if (test_num == 0) {
            if (difficult == 1) {
                if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_medium_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.ic_chart_q5_medium_detailed_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.ic_chart_q5_medium_detailed_2);
                    Drawable image3 = getBaseContext().getDrawable(R.drawable.ic_chart_q5_medium_detailed_2);
                    image1.setBounds(0, 0, 500, 500);
                    image2.setBounds(0, 0, 500, 500);
                    image3.setBounds(0, 0, 500, 500);
                    ImageSpan imageSpan = new ImageSpan(image1, ImageSpan.ALIGN_CENTER);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_CENTER);
                    ImageSpan imageSpan3 = new ImageSpan(image3, ImageSpan.ALIGN_CENTER);
                    textSpan.setSpan(imageSpan, 191, 192, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, 704, 705, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan3, 797, 798, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
                if (position == 6) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_medium_q7_detailed));
                    Drawable image = getBaseContext().getDrawable(R.drawable.ic_chart_q7_medium_detailed);
                    image.setBounds(0, 0, 500, 200);
                    ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan, 714, 715, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
                if (position == 9) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_medium_q10_detailed));
                    Drawable image = getBaseContext().getDrawable(R.drawable.ic_chart_q10_medium_detailed);
                    image.setBounds(0, 0, 730, 100);
                    ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan, 196, 197, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            } else if (difficult == 2) {
                if (position == 5) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_hard_q6_detailed));
                    Drawable image = getBaseContext().getDrawable(R.drawable.ic_chart_q6_hard_detailed);
                    image.setBounds(0, 0, 269, 100);
                    ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan, 691, 692, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
                if (position == 6) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_hard_q7_detailed));
                    Drawable image = getBaseContext().getDrawable(R.drawable.ic_chart_q5_medium_detailed_1);
                    image.setBounds(0, 0, 500, 500);
                    ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan, 190, 191, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
                if (position == 7) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_hard_q8_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.ic_chart_q8_hard_detailed);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.ic_chart_q8_hard_detailed_2);
                    image1.setBounds(0, 0, 500, 500);
                    image2.setBounds(0, 0, 292, 100);
                    ImageSpan imageSpan = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan, 195, 196, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, 1201, 1202, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
                if (position == 9) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_hard_q10_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.ic_chart_q6_hard_detailed);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.ic_chart_q10_hard_detailed_1);
                    Drawable image3 = getBaseContext().getDrawable(R.drawable.ic_chart_q10_hard_detailed_2);
                    image1.setBounds(0, 0, 269, 100);
                    image2.setBounds(0, 0, 211, 100);
                    image3.setBounds(0, 0, 198, 100);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan3 = new ImageSpan(image3, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan1, 37, 38, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, 419, 420, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan3, 545, 546, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            }
        } else if (test_num == 1){
            if (difficult == 0) {
                if (position == 4){
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test2_easy_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test2_easy_q5_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test2_easy_q5_2);
                    image1.setBounds(0, 0, 150, 72);
                    image2.setBounds(0, 0, 213, 72);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan1, 107, 108, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, 126, 127, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            } else if (difficult == 1) {
                if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test2_medium_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test2_easy_q5_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test2_easy_q5_2);
                    image1.setBounds(0, 0, 150, 72);
                    image2.setBounds(0, 0, 213, 72);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan1, 356, 357, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, 375, 376, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            } else if (difficult == 2) {
                if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test2_hard_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test2_hard_q5_1);
                    image1.setBounds(0, 0, 249, 139);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    textSpan.setSpan(imageSpan1, 630, 631, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            }

        } else if (test_num == 2) {
            if (difficult == 0){
                if (position == 1) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_easy_q2_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q2_1);
                    image1.setBounds(0, 0, 180, 152);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a = 1230;
                    textSpan.setSpan(imageSpan1, a, a+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 2) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_easy_q3_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q3_1);
                    image1.setBounds(0, 0, 180, 152);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a = 259;
                    textSpan.setSpan(imageSpan1, a, a+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_easy_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_2);
                    Drawable image3 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_3);
                    Drawable image4 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_4);
                    Drawable image5 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_5);
                    image1.setBounds(0, 0, 192, 90);
                    image2.setBounds(0, 0, 145, 90);
                    image3.setBounds(0, 0, 139, 91);
                    image4.setBounds(0, 0, 180, 152);
                    image5.setBounds(0, 0, 368, 94);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan3 = new ImageSpan(image3, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan4 = new ImageSpan(image4, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan5 = new ImageSpan(image5, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 175;
                    int a2 = 1170;
                    int a3 = 1392;
                    int a4 = 2001;
                    int a5 = 2425;
                    textSpan.setSpan(imageSpan1, a1, a1 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan3, a3, a3 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan4, a4, a4 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan5, a5, a5 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            } else if (difficult == 1) {
                if (position == 0) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_medium_q1_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_5);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q1_2);
                    Drawable image3 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q1_3);
                    image1.setBounds(0, 0, 368, 94);
                    image2.setBounds(0, 0, 794, 92);
                    image3.setBounds(0, 0, 308, 90);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan3 = new ImageSpan(image3, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 123;
                    int a2 = 220;
                    int a3 = 353;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan3, a3, a3+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 1){
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_medium_q2_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q2_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q2_2);
                    image1.setBounds(0, 0, 217, 117);
                    image2.setBounds(0, 0, 497, 117);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 168;
                    int a2 = 467;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 3) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_medium_q4_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q2_1);
                    image1.setBounds(0, 0, 217, 117);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 250;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_medium_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_1);
                    image1.setBounds(0, 0, 282, 117);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 175;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }

            } else if (difficult == 2) {
                if (position == 0) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_hard_q1_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_hard_q1_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_hard_q1_2);
                    image1.setBounds(0, 0, 287, 158);
                    image2.setBounds(0, 0, 283, 229);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 791;
                    int a2 = 920;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 1) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_hard_q2_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q2_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q2_2);
                    image1.setBounds(0, 0, 217, 117);
                    image2.setBounds(0, 0, 497, 117);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 168;
                    int a2 = 467;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 2) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_hard_q3_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q2_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_medium_q2_2);
                    image1.setBounds(0, 0, 217, 117);
                    image2.setBounds(0, 0, 497, 117);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 168;
                    int a2 = 467;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 3) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_hard_q4_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_hard_q4_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_hard_q4_2);
                    Drawable image3 = getBaseContext().getDrawable(R.drawable.formula_test3_hard_q4_3);
                    image1.setBounds(0, 0, 564, 102);
                    image2.setBounds(0, 0, 516, 122);
                    image3.setBounds(0, 0, 346, 116);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan3 = new ImageSpan(image3, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 240;
                    int a2 = 515;
                    int a3 = 645;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan3, a3, a3+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test3_hard_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_2);
                    Drawable image3 = getBaseContext().getDrawable(R.drawable.formula_test3_easy_q5_3);
                    image1.setBounds(0, 0, 192, 90);
                    image2.setBounds(0, 0, 145, 90);
                    image3.setBounds(0, 0, 139, 91);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan3 = new ImageSpan(image3, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 175;
                    int a2 = 1170;
                    int a3 = 1393;
                    textSpan.setSpan(imageSpan1, a1, a1 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan3, a3, a3 + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }

            }
        } else if (test_num == 3) {
            if (difficult == 0) {
                if (position == 0){
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test4_easy_q1_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test4_easy_q1_1);
                    image1.setBounds(0, 0, 422, 224);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 287;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test4_easy_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test4_easy_q2_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test4_easy_q2_2);
                    image1.setBounds(0, 0, 754, 200);
                    image2.setBounds(0, 0, 194, 99);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 344;
                    int a2 = 703;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            } else if (difficult == 1) {
                if (position == 0) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test4_medium_q1_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test4_easy_q1_1);
                    image1.setBounds(0, 0, 422, 224);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 287;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 3) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test4_medium_q4_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test4_medium_q4_1);
                    Drawable image2 = getBaseContext().getDrawable(R.drawable.formula_test4_medium_q4_2);
                    image1.setBounds(0, 0, 706, 213);
                    image2.setBounds(0, 0, 285, 120);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    ImageSpan imageSpan2 = new ImageSpan(image2, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 18;
                    int a2 = 22;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    textSpan.setSpan(imageSpan2, a2, a2+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test4_medium_q4_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test4_medium_q5_1);
                    image1.setBounds(0, 0, 267, 136);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 97;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            } else if (difficult == 2) {
                if (position == 3) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test4_hard_q4_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test4_easy_q2_1);
                    image1.setBounds(0, 0, 754, 200);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 344;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                } else if (position == 4) {
                    SpannableStringBuilder textSpan = new SpannableStringBuilder(getText(R.string.text_test4_hard_q5_detailed));
                    Drawable image1 = getBaseContext().getDrawable(R.drawable.formula_test4_hard_q5_1);
                    image1.setBounds(0, 0, 716, 230);
                    ImageSpan imageSpan1 = new ImageSpan(image1, ImageSpan.ALIGN_BOTTOM);
                    int a1 = 523;
                    textSpan.setSpan(imageSpan1, a1, a1+1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    text_detailed.setText(textSpan);
                }
            }
        }


        if (QuestionTest.incorrect_results[position] == 0) {
            text_correct_detailed.setTextColor(getResources().getColor(R.color.green));
            text_correct_detailed.setText(getText(R.string.text_small_correct));
            frame_correct_detailed.setBackgroundTintList(getResources().getColorStateList(R.color.green));
        }

        if (QuestionTest.skip_answers[position] > 0) {
            text_correct_detailed.setTextColor(getResources().getColor(R.color.red));
            text_correct_detailed.setText(getText(R.string.text_small_skip));
            frame_correct_detailed.setBackgroundTintList(getResources().getColorStateList(R.color.red));
        }

        image_correct_detailed.setImageResource(mIcons[QuestionTest.incorrect_results[position]]);
        if (QuestionTest.results[position] == 0) {
            image_correct_detailed.setImageResource(mIcons[1]);
        }

        text_question_detailed.setText(questionTest.QuestionTest[test_num][difficult][position]);

        if (QuestionTest.test_pictures[test_num][difficult][position] != 0) {
            image_question.setVisibility(View.VISIBLE);
            image_question.setImageResource(QuestionTest.test_pictures[test_num][difficult][position]);
        } else {
            image_question.setVisibility(View.GONE);
        }

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
//        toolbar.setTitle(R.id.);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void findById() {
//        text_change = findViewById(R.id.text_change);

        text_num_question_detailed = findViewById(R.id.text_num_question_detailed);
        text_correct_detailed = findViewById(R.id.text_correct_detailed);
        text_question_detailed = findViewById(R.id.text_question_detailed);
        text_detailed = findViewById(R.id.text_detailed);

        frame_correct_detailed = findViewById(R.id.frame_correct_detailed);
        image_correct_detailed = findViewById(R.id.image_correct_detailed);
        image_question = findViewById(R.id.image_question);

        toolbar = findViewById(R.id.toolbar4);
    }


}