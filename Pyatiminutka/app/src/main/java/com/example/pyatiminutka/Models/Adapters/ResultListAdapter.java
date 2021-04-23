package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.ui.result.DetailedQuestionActivity;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.ResultListViewHolder> {

    private final QuestionTest questionTest = new QuestionTest();

    private final int numberItems;
    private static int viewHolderCount;

    private final int[] rQuestions;
    private final int[] rIcons;

    private final Context context1;

    private final int test_num = AppConstants.map_test_number.get("test_num");

    private final int difficult = AppConstants.map_difficult.get("Difficult") - 1;

    public ResultListAdapter(int numberOfItems, int[] questions, int[] icons, Context context) {
        numberItems = numberOfItems;
        rQuestions = questions;
        rIcons = icons;
        context1 = context;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public ResultListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.list_layout;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        ResultListViewHolder viewHolder = new ResultListViewHolder(view);
        viewHolder.question_final_text.setText(questionTest.QuestionTest[test_num][difficult][viewHolderCount]);
        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultListViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class ResultListViewHolder extends RecyclerView.ViewHolder {

        TextView question_final_text;
        TextView correct_question_text1;
        TextView correct_question_text2;
        TextView correct_question_text3;
        TextView correct_question_text4;
        TextView choose_question_text1;
        TextView choose_question_text2;
        TextView choose_question_text3;
        TextView choose_question_text4;
        ImageView image_view;
        TextView text_skip;
        ImageView image1;
        CardView image_button1;
        ImageView image_button2;
        View divider;

        TextView question_number;
        TextView text_correct;
        LinearLayout frame_correct;


        public ResultListViewHolder(@NonNull View itemView) {
            super(itemView);

            question_number = itemView.findViewById(R.id.question_number);
            text_correct = itemView.findViewById(R.id.text_correct);
            frame_correct = itemView.findViewById(R.id.frame_correct);

            question_final_text = itemView.findViewById(R.id.text_view11);
            correct_question_text1 = itemView.findViewById(R.id.text_view12);
            correct_question_text2 = itemView.findViewById(R.id.text_view13);
            correct_question_text3 = itemView.findViewById(R.id.text_view18);
            correct_question_text4 = itemView.findViewById(R.id.text_view19);
            choose_question_text1 = itemView.findViewById(R.id.text_view14);
            choose_question_text2 = itemView.findViewById(R.id.text_view15);
            choose_question_text3 = itemView.findViewById(R.id.text_view16);
            choose_question_text4 = itemView.findViewById(R.id.text_view17);
            image_view = itemView.findViewById(R.id.image_view);
            text_skip = itemView.findViewById(R.id.text_view20);
            image1 = itemView.findViewById(R.id.image1);
            divider = itemView.findViewById(R.id.divider);

            image_button1 = itemView.findViewById(R.id.image_button1);

        }

        void bind(int listIndex) {

            correct_question_text1.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][0], 0, 0, 0);
            correct_question_text2.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][1], 0, 0, 0);
            correct_question_text3.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][2], 0, 0, 0);
            correct_question_text4.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][3], 0, 0, 0);

            choose_question_text1.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][0], 0, 0, 0);
            choose_question_text2.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][1], 0, 0, 0);
            choose_question_text3.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][2], 0, 0, 0);
            choose_question_text4.setCompoundDrawablesWithIntrinsicBounds(
                    QuestionTest.imageAnswers[test_num][difficult][listIndex][3], 0, 0, 0);

            question_number.setText(String.valueOf(listIndex + 1));

            image_button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context1.getApplicationContext(), DetailedQuestionActivity.class);
                    intent.putExtra("position", getAdapterPosition());
                    context1.startActivity(intent);
                }
            });

            if (QuestionTest.results[listIndex] > 1){
                text_correct.setTextColor(context1.getResources().getColor(R.color.red));
                text_correct.setText(context1.getText(R.string.text_small_incorrect));
                frame_correct.setBackgroundTintList(context1.getResources().getColorStateList(R.color.red));
            }

            if (QuestionTest.results[listIndex] == 1){
                text_correct.setTextColor(context1.getResources().getColor(R.color.green));
                text_correct.setText(context1.getText(R.string.text_small_correct));
                frame_correct.setBackgroundTintList(context1.getResources().getColorStateList(R.color.green));
            }


//            text_correct.setTextColor(context1.getResources().getColor(R.color.red));

            if (QuestionTest.test_pictures[test_num][difficult][listIndex] != 0) {
                image_view.setVisibility(View.VISIBLE);
                image_view.setImageResource(QuestionTest.test_pictures[test_num][difficult][listIndex]);
            } else {
                image_view.setVisibility(View.GONE);
            }

            question_final_text.setText(rQuestions[listIndex]);
            if (listIndex == questionTest.QuestionTest[test_num][difficult].length - 1) {
                divider.setVisibility(View.INVISIBLE);
            }
            image1.setImageResource(rIcons[QuestionTest.incorrect_results[listIndex]]);
            if (QuestionTest.results[listIndex] == 0) {
                image1.setImageResource(rIcons[1]);
                text_skip.setVisibility(View.VISIBLE);
            } else {
                text_skip.setVisibility(View.GONE);
            }

            //Вывод правильных ответов
            if (questionTest.correctAnswer[test_num][difficult][listIndex][0] == 1) {
                correct_question_text1.setText(questionTest.choiceans[test_num][difficult][listIndex][0]);
            } else {
                correct_question_text1.setVisibility(View.GONE);
            }

            if (questionTest.correctAnswer[test_num][difficult][listIndex][1] == 1) {
                correct_question_text2.setText(questionTest.choiceans[test_num][difficult][listIndex][1]);
            } else {
                correct_question_text2.setVisibility(View.GONE);
            }

            if (questionTest.correctAnswer[test_num][difficult][listIndex][2] == 1) {
                correct_question_text3.setText(questionTest.choiceans[test_num][difficult][listIndex][2]);
            } else {
                correct_question_text3.setVisibility(View.GONE);
            }

            if (questionTest.correctAnswer[test_num][difficult][listIndex][3] == 1) {
                correct_question_text4.setText(questionTest.choiceans[test_num][difficult][listIndex][3]);
            } else {
                correct_question_text4.setVisibility(View.GONE);
            }
            //Вывод ответов пользователя

            if (QuestionTest.choosed_answers1[listIndex] == 1) {
                choose_question_text1.setText(questionTest.choiceans[test_num][difficult][listIndex][0]);
                if (questionTest.correctAnswer[test_num][difficult][listIndex][0] == 1) {
                    choose_question_text1.setTextColor(ContextCompat.getColor(context1, R.color.green));
                }
            } else {
                choose_question_text1.setVisibility(View.GONE);
            }

            if (QuestionTest.choosed_answers2[listIndex] == 1) {
                choose_question_text2.setText(questionTest.choiceans[test_num][difficult][listIndex][1]);
                if (questionTest.correctAnswer[test_num][difficult][listIndex][1] == 1) {
                    choose_question_text2.setTextColor(ContextCompat.getColor(context1, R.color.green));
                }
            } else {
                choose_question_text2.setVisibility(View.GONE);
            }

            if (QuestionTest.choosed_answers3[listIndex] == 1) {
                choose_question_text3.setText(questionTest.choiceans[test_num][difficult][listIndex][2]);
                if (questionTest.correctAnswer[test_num][difficult][listIndex][2] == 1) {
                    choose_question_text3.setTextColor(ContextCompat.getColor(context1, R.color.green));
                }
            } else {
                choose_question_text3.setVisibility(View.GONE);
            }

            if (QuestionTest.choosed_answers4[listIndex] == 1) {
                choose_question_text4.setText(questionTest.choiceans[test_num][difficult][listIndex][3]);
                if (questionTest.correctAnswer[test_num][difficult][listIndex][3] == 1) {
                    choose_question_text4.setTextColor(ContextCompat.getColor(context1, R.color.green));
                }
            } else {
                choose_question_text4.setVisibility(View.GONE);
            }

        }
    }

}
