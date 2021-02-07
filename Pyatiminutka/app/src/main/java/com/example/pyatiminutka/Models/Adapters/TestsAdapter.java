package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.tests.Activity_quiz_term;
import com.example.pyatiminutka.ui.tests.Activity_term_test;

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.TestsAdapterViewHolder> {

    private final int[] rTitle;

    private final Context context1;

    private static int viewHolderCount;

    private QuestionTest questionTest = new QuestionTest();

    public TestsAdapter(int[] title, Context context) {
        this.rTitle = title;
        this.context1 = context;
    }

    @NonNull
    @Override
    public TestsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.test_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new TestsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestsAdapterViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return QuestionTest.Question_title.length;
    }

    class TestsAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView test_title;
        ImageView test_icon;

        CardView btn_background;

        ProgressBar easy;
        ProgressBar medium;
        ProgressBar hard;

        public TestsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            test_title = itemView.findViewById(R.id.textView7);
            test_icon = itemView.findViewById(R.id.imageView4);

            easy = itemView.findViewById(R.id.progressBar3);
            medium = itemView.findViewById(R.id.progressBar5);
            hard = itemView.findViewById(R.id.progressBar4);

            btn_background = itemView.findViewById(R.id.card_question);

            btn_background.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppConstants.map_test_number.put("test_num", getAdapterPosition());
                    Intent intent = new Intent(context1, Activity_term_test.class);
                    context1.startActivity(intent);
                }
            });
        }

        void bind(int listIndex) {
            SharedPreferences sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(context1);

            if (listIndex == 0) {
                btn_background.getBackground().setColorFilter(context1.getResources()
                        .getColor(R.color.btn_purple), PorterDuff.Mode.SRC_ATOP);

                if (sharedPreferences.contains(AppConstants.KEY_SCORE_EASY_TERM)) {
                    int score_easy_term =
                            sharedPreferences.getInt(AppConstants.KEY_SCORE_EASY_TERM, 0)
                                    * 100 / questionTest.QuestionTest[listIndex][0].length;
                    easy.setProgress(score_easy_term);
                    Log.d("myLogs", "Рекорд " + score_easy_term);
                } else easy.setProgress(0);

                if (sharedPreferences.contains(AppConstants.KEY_SCORE_MEDIUM_TERM)) {
                    int score_medium_term =
                            sharedPreferences.getInt(AppConstants.KEY_SCORE_MEDIUM_TERM, 0)
                                    * 100 / questionTest.QuestionTest[listIndex][1].length;
                    medium.setProgress(score_medium_term);
                } else medium.setProgress(0);

                if (sharedPreferences.contains(AppConstants.KEY_SCORE_HARD_TERM)) {
                    int score_hard_term =
                            sharedPreferences.getInt(AppConstants.KEY_SCORE_HARD_TERM, 0)
                                    * 100 / questionTest.QuestionTest[listIndex][2].length;
                    hard.setProgress(score_hard_term);
                } else hard.setProgress(0);
            }

            test_title.setText(rTitle[listIndex]);
        }
    }
}
