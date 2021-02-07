package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.items.BookItem;
import com.example.pyatiminutka.R;

import java.util.ArrayList;

public class SettingsListAdapter extends RecyclerView.Adapter<SettingsListAdapter.SettingsListViewHolder> {

    private Context context;

    private int [] mSettingsText;
    private int [] mIcon;

    private static int viewHolderCount;

    public SettingsListAdapter(Context cont, int[] settings_text, int[] icon) {
        this.context = cont;
        this.mSettingsText = settings_text;
        this.mIcon = icon;
    }

    @NonNull
    @Override
    public SettingsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.settings_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        SettingsListViewHolder holder = new SettingsListViewHolder(view);

        holder.text_setting.setText(mSettingsText[viewHolderCount]);
        holder.icon_setting.setImageResource(mIcon[viewHolderCount]);
        viewHolderCount++;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsListViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return QuestionTest.settings_text.length;
    }

    public class SettingsListViewHolder extends RecyclerView.ViewHolder {

        TextView text_setting;
        ImageView icon_setting;

        public SettingsListViewHolder(@NonNull View itemView) {
            super(itemView);

            text_setting = itemView.findViewById(R.id.textView13);
            icon_setting = itemView.findViewById(R.id.imageView5);

        }

        public void bind(int listIndex) {
            text_setting.setText(mSettingsText[listIndex]);
            icon_setting.setImageResource(mIcon[listIndex]);
        }
    }

}
