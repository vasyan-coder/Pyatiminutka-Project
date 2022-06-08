package com.example.pyatiminutka.ui.questions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.pyatiminutka.R;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;

public class Question10Fragment extends Fragment {

    private TextView question10text;
    private CheckBox answer_one;
    private CheckBox answer_two;
    private CheckBox answer_three;
    private CheckBox answer_four;

    private CardView card_answer_one;
    private CardView card_answer_two;
    private CardView card_answer_three;
    private CardView card_answer_four;

    private int textquestion;
    private int answer_one_text;
    private int answer_two_text;
    private int answer_three_text;
    private int answer_four_text;
    private int correctAnswer1;
    private int correctAnswer2;
    private int correctAnswer3;
    private int correctAnswer4;
    private ImageView test_image;

    private CardView fix_question;
    private CardView change_question;

    private int score_new_form = 0;

    private String currentView1;
    private int currentView;

    private AlphaAnimation anim1;
    private AlphaAnimation anim2;

    private ViewPager viewPager;

    private final int test_num = AppConstants.map_test_number.get("test_num");
    private final int difficult = AppConstants.map_difficult.get("Difficult") - 1;

    private QuestionTest questionTest = new QuestionTest();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_question10_layout, container, false);

        findByIdFragment(root);

        change_question.setEnabled(false);

        change_question.setAlpha(0.6f);
        anim1 = new AlphaAnimation(0.6f, 1.0f);
        anim1.setDuration(150);
        anim1.setFillAfter(true);
        anim2 = new AlphaAnimation(1f, 0.6f);
        anim2.setDuration(150);
        anim2.setFillAfter(true);

        Bundle args = getArguments();
        currentView = args.getInt(AppConstants.ARG_SECTION_NUMBER) - 1;
        currentView1 = Integer.toString(currentView);

//        Log.d("myLogs", "Возвращаемая позиция TabLayout " + currentView);

        //Возвращение данных вопроса по номеру текущего таба (currentView)
        textquestion = questionTest.QuestionTest[test_num][difficult][currentView]; //Текст вопроса
        question10text.setText(textquestion);

        Log.d("myLogs", String.valueOf(questionTest.choiceans[test_num][difficult][currentView][0]));
        answer_one_text = questionTest.choiceans[test_num][difficult][currentView][0]; //текст первого варианта ответа
        if (getString(answer_one_text).equals("000")) {
            answer_one.setVisibility(View.GONE);
        } else
            answer_one.setText(answer_one_text);
        answer_two_text = questionTest.choiceans[test_num][difficult][currentView][1]; //текст второго варианта ответа
        if (getString(answer_two_text).equals("000")) {
            answer_two.setVisibility(View.GONE);
        } else
            answer_two.setText(answer_two_text);
        answer_three_text = questionTest.choiceans[test_num][difficult][currentView][2]; //текст третьего варианта ответа
        if (getString(answer_three_text).equals("000")) {
            answer_three.setVisibility(View.GONE);
        } else
            answer_three.setText(answer_three_text);
        answer_four_text = questionTest.choiceans[test_num][difficult][currentView][3]; //текст четвёртого варианта ответа
        if (getString(answer_four_text).equals("000")) {
            answer_four.setVisibility(View.GONE);
        } else
            answer_four.setText(answer_four_text);
        answer_four.setText(answer_four_text);

//        answer_four.setButtonDrawable(QuestionTest.imageAnswers[test_num][difficult][currentView][0]);
//        answer_four.setButtonDrawable(QuestionTest.imageAnswers[test_num][difficult][currentView][1]);
//        answer_four.setButtonDrawable(QuestionTest.imageAnswers[test_num][difficult][currentView][2]);
//        answer_four.setButtonDrawable(QuestionTest.imageAnswers[test_num][difficult][currentView][3]);

//        Drawable i1 = getContext().getResources().getDrawable(QuestionTest.imageAnswers[test_num][difficult][currentView][0]);
//        i1.setBounds(0,0,150,150);
        answer_one.setCompoundDrawablesWithIntrinsicBounds(
                QuestionTest.imageAnswers[test_num][difficult][currentView][0], 0, 0, 0);
        answer_two.setCompoundDrawablesWithIntrinsicBounds(
                QuestionTest.imageAnswers[test_num][difficult][currentView][1], 0, 0, 0);
        answer_three.setCompoundDrawablesWithIntrinsicBounds(
                QuestionTest.imageAnswers[test_num][difficult][currentView][2], 0, 0, 0);
        answer_four.setCompoundDrawablesWithIntrinsicBounds(
                QuestionTest.imageAnswers[test_num][difficult][currentView][3], 0, 0, 0);

        correctAnswer1 = questionTest.correctAnswer[test_num][difficult][currentView][0];
        correctAnswer2 = questionTest.correctAnswer[test_num][difficult][currentView][1];
        correctAnswer3 = questionTest.correctAnswer[test_num][difficult][currentView][2];
        correctAnswer4 = questionTest.correctAnswer[test_num][difficult][currentView][3];

        if (QuestionTest.test_pictures[test_num][difficult][currentView] != 0) {
            test_image.setVisibility(View.VISIBLE);
            test_image.setImageResource(QuestionTest.test_pictures[test_num][difficult][currentView]);
        } else {
            test_image.setVisibility(View.GONE);
        }

        View.OnClickListener onClickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.card_answer_one:
                        if (answer_one.isChecked())
                            answer_one.setChecked(false);
                        else
                            answer_one.setChecked(true);
                        break;
                    case R.id.card_answer_two:
                        if (answer_two.isChecked())
                            answer_two.setChecked(false);
                        else
                            answer_two.setChecked(true);
                        break;
                    case R.id.card_answer_three:
                        if (answer_three.isChecked())
                            answer_three.setChecked(false);
                        else
                            answer_three.setChecked(true);
                        break;
                    case R.id.card_answer_four:
                        if (answer_four.isChecked())
                            answer_four.setChecked(false);
                        else
                            answer_four.setChecked(true);
                        break;
                }
            }
        };

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.fixq10:
                        if (answer_one.isChecked() || answer_two.isChecked() || answer_three.isChecked() || answer_four.isChecked()) {
                            if (correctAnswer1 == 1 && answer_one.isChecked()) {
                                score_new_form += 1;
                            } else if (answer_one.isChecked()) score_new_form += 4;

                            if (correctAnswer2 == 1 && answer_two.isChecked()) {
                                score_new_form += 1;
                            } else if (correctAnswer2 == 0 && answer_two.isChecked()) {
                                score_new_form += 4;
                            }

                            if (correctAnswer3 == 1 && answer_three.isChecked()) {
                                score_new_form += 1;
                            } else if (answer_three.isChecked()) score_new_form += 4;


                            if (correctAnswer4 == 1 && answer_four.isChecked()) {
                                score_new_form += 1;
                            } else if (answer_four.isChecked()) score_new_form += 4;

                            int val = currentView + 1;
                            if (score_new_form == correctAnswer1 + correctAnswer2 + correctAnswer3 + correctAnswer4) {
                                QuestionTest.skip_answers[currentView] = 0;
                                QuestionTest.results[currentView] = 1;
                            } else {
                                QuestionTest.skip_answers[currentView] = 0;
                                QuestionTest.incorrect_results[currentView] = 1;
                                QuestionTest.results[currentView] = 3;
                            }
                            AnimQuestionFadeIn();
                            viewPager.setCurrentItem(currentView + 1);
                        } else if (!answer_one.isChecked() && !answer_two.isChecked() &&
                                !answer_three.isChecked() && !answer_four.isChecked()) {
                            AlertDialog.Builder a_builder = new AlertDialog.Builder(getContext());
                            a_builder.setMessage(getResources().getString(R.string.text_no_answer))
                                    .setCancelable(true)
                                    .setPositiveButton(getResources().getString(R.string.text_yes), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            AnimQuestionFadeIn();

                                            viewPager.setCurrentItem(currentView + 1); //Метка при коприровании
                                            QuestionTest.skip_answers[currentView] = 1;
                                            QuestionTest.results[currentView] = 0;
                                            QuestionTest.incorrect_results[currentView] = 0;

                                        }
                                    })
                                    .setNegativeButton(getResources().getString(R.string.text_no), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            QuestionTest.skip_answers[currentView] = 1;
                                            QuestionTest.results[currentView] = 0;
                                            QuestionTest.incorrect_results[currentView] = 0;
                                            dialog.cancel();
                                        }
                                    });
                            AlertDialog alert = a_builder.create();
                            alert.setTitle(getString(R.string.text_skip_question));
                            alert.show();
                        }
                        if (answer_one.isChecked())
                            QuestionTest.choosed_answers1[currentView] = 1; //Метка при коприровании
                        if (answer_two.isChecked())
                            QuestionTest.choosed_answers2[currentView] = 1; //Метка при коприровании
                        if (answer_three.isChecked())
                            QuestionTest.choosed_answers3[currentView] = 1; //Метка при коприровании
                        if (answer_four.isChecked())
                            QuestionTest.choosed_answers4[currentView] = 1; //Метка при коприровании
                        break;

                    case R.id.changeq10:
                        score_new_form = 0;
                        if (answer_one.isChecked())
                            QuestionTest.choosed_answers1[currentView] = 0; //Метка при коприровании
                        if (answer_two.isChecked())
                            QuestionTest.choosed_answers2[currentView] = 0; //Метка при коприровании
                        if (answer_three.isChecked())
                            QuestionTest.choosed_answers3[currentView] = 0; //Метка при коприровании
                        if (answer_four.isChecked())
                            QuestionTest.choosed_answers4[currentView] = 0; //Метка при коприровании
                        QuestionTest.skip_answers[currentView] = 1;
                        QuestionTest.results[currentView] = 0;
                        QuestionTest.incorrect_results[currentView] = 0;

                        AnimQuestionFadeFrom();
                        break;
                }
            }
        };

        fix_question.setOnClickListener(onClickListener);
        change_question.setOnClickListener(onClickListener);

        card_answer_one.setOnClickListener(onClickListener2);
        card_answer_two.setOnClickListener(onClickListener2);
        card_answer_three.setOnClickListener(onClickListener2);
        card_answer_four.setOnClickListener(onClickListener2);

        return root;
    }

    private void findByIdFragment(View v) {
        question10text = v.findViewById(R.id.question10text);

        answer_one = v.findViewById(R.id.answer_one_q10);
        answer_two = v.findViewById(R.id.answer_two_q10);
        answer_three = v.findViewById(R.id.answer_three_q10);
        answer_four = v.findViewById(R.id.answer_four_q10);
        test_image = v.findViewById(R.id.test_image);

        fix_question = v.findViewById(R.id.fixq10);
        change_question = v.findViewById(R.id.changeq10);

        viewPager = getActivity().findViewById(R.id.view_pager);

        card_answer_one = v.findViewById(R.id.card_answer_one);
        card_answer_two = v.findViewById(R.id.card_answer_two);
        card_answer_three = v.findViewById(R.id.card_answer_three);
        card_answer_four = v.findViewById(R.id.card_answer_four);
    }

    private void AnimQuestionFadeIn() {
        card_answer_one.setEnabled(false);
        card_answer_two.setEnabled(false);
        card_answer_three.setEnabled(false);
        card_answer_four.setEnabled(false);

        answer_one.setEnabled(false);
        answer_two.setEnabled(false);
        answer_three.setEnabled(false);
        answer_four.setEnabled(false);
//
//        fix_question.startAnimation(anim2);
        fix_question.setAlpha(.6f);
//
        fix_question.setEnabled(false);
//
//        change_question.startAnimation(anim1);
        change_question.setAlpha(1.0f);
//
        change_question.setEnabled(true);
//
//        answer_one.startAnimation(anim2);
//        answer_two.startAnimation(anim2);
//        answer_three.startAnimation(anim2);
//        answer_four.startAnimation(anim2);
//        answer_one.setAlpha(.6f);
//        answer_two.setAlpha(.6f);
//        answer_three.setAlpha(.6f);
//        answer_four.setAlpha(.6f);
    }

    private void AnimQuestionFadeFrom() {
        card_answer_one.setEnabled(true);
        card_answer_two.setEnabled(true);
        card_answer_three.setEnabled(true);
        card_answer_four.setEnabled(true);
//
        answer_one.setEnabled(true);
        answer_two.setEnabled(true);
        answer_three.setEnabled(true);
        answer_four.setEnabled(true);


//        fix_question.startAnimation(anim1);
        fix_question.setAlpha(1.0f);
//
        fix_question.setEnabled(true);
//
//        change_question.startAnimation(anim1);
        change_question.setAlpha(.6f);
//
        change_question.setEnabled(false);
//
//        answer_one.startAnimation(anim1);
//        answer_two.startAnimation(anim1);
//        answer_three.startAnimation(anim1);
//        answer_four.startAnimation(anim1);
//        answer_one.setAlpha(1.0f);
//        answer_two.setAlpha(1.0f);
//        answer_three.setAlpha(1.0f);
//        answer_four.setAlpha(1.0f);
    }
}
