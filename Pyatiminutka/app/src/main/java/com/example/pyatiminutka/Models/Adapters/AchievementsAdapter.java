package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.items.AchievementsItem;
import com.example.pyatiminutka.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.AchievementsViewHolder> {

    private ArrayList<AchievementsItem> achievementsItems;

    private Context context;

    public AchievementsAdapter (ArrayList<AchievementsItem> achievementsItems, Context context){
        this.achievementsItems = achievementsItems;
        this.context=context;
    }

    @NonNull
    @Override
    public AchievementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.item_achievements;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new AchievementsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementsViewHolder holder, int position) {
        if (position == 0){
            if (holder.myPreferences.contains(AppConstants.KEY_1_ACHIEVEMENT)) {

                holder.text_progress_achievement.setText("1/1");
                holder.progress_achievement.setProgress(100);
                holder.image_done_achievement.setVisibility(View.VISIBLE);
            } else {
                //Log.d("myLogs", "Код выполнен false");
                holder.text_progress_achievement.setText("0/1");
            }
        } else if (position == 1) {
            if (holder.myPreferences.contains(AppConstants.KEY_2_ACHIEVEMENT)) {
                int progress = holder.myPreferences.getInt(AppConstants.KEY_2_ACHIEVEMENT,0);
                if (progress == 100){
                    holder.image_done_achievement.setVisibility(View.VISIBLE);
                }
                //Log.d("myLogs", "Код выполнен true" + progress);
                holder.progress_achievement.setProgress(progress);
                holder.text_progress_achievement.setText(progress + "/100");
            }
        } else if (position == 2) {
            if (holder.myPreferences.contains(AppConstants.KEY_3_ACHIEVEMENT)) {
                int progress = holder.myPreferences.getInt(AppConstants.KEY_3_ACHIEVEMENT,0);
                if (progress == 100){
                    holder.image_done_achievement.setVisibility(View.VISIBLE);
                }
                //Log.d("myLogs", "Код выполнен true" + progress);
                holder.progress_achievement.setProgress(progress);
                holder.text_progress_achievement.setText(progress + "/100");
            }
        } else if (position == 3) {
            if (holder.myPreferences.contains(AppConstants.KEY_4_ACHIEVEMENT)) {
                int progress = holder.myPreferences.getInt(AppConstants.KEY_4_ACHIEVEMENT,0);
                if (progress == 100){
                    holder.image_done_achievement.setVisibility(View.VISIBLE);
                }
                //Log.d("myLogs", "Код выполнен true" + progress);
                holder.progress_achievement.setProgress(progress);
                holder.text_progress_achievement.setText(progress + "/100");
            }
        } else if (position == 4) {
            if (holder.myPreferences.contains(AppConstants.KEY_5_ACHIEVEMENT)) {
                int progress = holder.myPreferences.getInt(AppConstants.KEY_5_ACHIEVEMENT,0);
                if (progress == 100){
                    holder.image_done_achievement.setVisibility(View.VISIBLE);
                }
                //Log.d("myLogs", "Код выполнен true" + progress);
                holder.progress_achievement.setProgress(progress);
                holder.text_progress_achievement.setText(progress + "/100");
            }
        } else if (position == 5) {
            if (holder.myPreferences.contains(AppConstants.KEY_6_ACHIEVEMENT)) {
                int progress = holder.myPreferences.getInt(AppConstants.KEY_6_ACHIEVEMENT,0);
                if (progress == 100){
                    holder.image_done_achievement.setVisibility(View.VISIBLE);
                }
                //Log.d("myLogs", "Код выполнен true" + progress);
                holder.progress_achievement.setProgress(progress);
                holder.text_progress_achievement.setText(progress + "/100");
            }
        }

        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return achievementsItems.size();
    }

    public class AchievementsViewHolder extends RecyclerView.ViewHolder{

        TextView text_title_achievement;
        TextView text_description_achievement;
        TextView text_progress_achievement;

        ProgressBar progress_achievement;

        ImageView image_done_achievement;

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor myEditor = myPreferences.edit();

        public AchievementsViewHolder(@NonNull View itemView) {
            super(itemView);

            text_title_achievement = itemView.findViewById(R.id.text_title_achievement);
            text_description_achievement = itemView.findViewById(R.id.text_description_achievement);
            text_progress_achievement = itemView.findViewById(R.id.text_progress_achievement);

            progress_achievement = itemView.findViewById(R.id.progress_achievement);

            image_done_achievement = itemView.findViewById(R.id.image_done_achievement);

        }

        public void bind(int listIndex){
            AchievementsItem current = achievementsItems.get(listIndex);
            text_title_achievement.setText(current.getmTitle());
            text_description_achievement.setText(current.getmDescription());


        }
    }
}
