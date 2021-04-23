package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.items.formulasItem;
import com.example.pyatiminutka.R;

import java.util.ArrayList;
import java.util.List;

public class FormulasMainAdapter extends RecyclerView.Adapter<FormulasMainAdapter.FormulasViewHolder> {

    private List<formulasItem> mTitleTheme;

    private ArrayList<formulasItem> mFormulas;

    private Context context;

    private List<formulasItem> tag;

    public FormulasMainAdapter(List<formulasItem> mTitleTheme, Context context) {
        this.context = context;
        this.mTitleTheme = mTitleTheme;
//        this.tag = tag;
    }

    @NonNull
    @Override
    public FormulasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.formul_title_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);



        return new FormulasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormulasViewHolder holder, int position) {
        holder.bind(position);
        formulasItem current = mTitleTheme.get(position);
//        holder.dvd.setVisibility(View.GONE);
        holder.dvd.setVisibility(View.VISIBLE);
        holder.dvd.setBackgroundColor(context.getResources().getColor(R.color.silver));
        if (current.getTitle_theme() == context.getString(QuestionTest.Question_title[0])){
//            holder.dvd.setBackgroundColor(context.getResources().getColor(R.color.colorTextBlack));
            holder.dvd.setVisibility(View.GONE);
        }
        if (current.getTitle_theme() == "§2 Механика") {
//            holder.dvd.setBackgroundColor(context.getResources().getColor(R.color.colorTextBlack));
        }

//        boolean isExpanded = mTitleTheme.get(position).isExpanded();
//        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);



//        formulasItem theme = mTitleTheme.get(position);
//        String title = theme.getTitle_theme();
//        List<String> formulas = theme.getText_formulas();
//
//        holder.title_theme.setText(title);
//
//        FormulasChildAdapter formulasChildAdapter = new FormulasChildAdapter(formulas);
//        holder.expandableLayout.setAdapter(formulasChildAdapter);

    }

    @Override
    public int getItemCount() {
        return mTitleTheme.size();
    }

    public class FormulasViewHolder extends RecyclerView.ViewHolder {

        TextView title_theme;
        TextView subtitle_theme;
        TextView text_tag;
        ImageView imageView_formula;
        TextView text_description;

        View dvd;

        public FormulasViewHolder(@NonNull View itemView) {
            super(itemView);

            title_theme = itemView.findViewById(R.id.title_theme);
            subtitle_theme = itemView.findViewById(R.id.subtitle_theme);
            imageView_formula = itemView.findViewById(R.id.imageView_formula);
            text_tag = itemView.findViewById(R.id.text_tag);
            text_description = itemView.findViewById(R.id.text_description_formula);
            dvd = itemView.findViewById(R.id.view);

//            title_theme.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    formulasItem formulasItem = mTitleTheme.get(getAdapterPosition());
//                    notifyItemChanged(getAdapterPosition());
////                    if (formulasItem.isExpanded())
////                        formulas_arrow.animate().rotationBy(360).setDuration(1000).start();
//////                    } else {
//////                        formulas_arrow.animate().rotationBy(360).setDuration(300).start();
//////                    }
//                    formulasItem.setExpanded(!formulasItem.isExpanded());
//
//
//
//                }
//            });


        }

        public void bind(int listIndex) {
            formulasItem currentItem1 = mTitleTheme.get(listIndex);
            title_theme.setText(currentItem1.getTitle_theme());
            subtitle_theme.setText(currentItem1.getSubtitle_theme());
            text_description.setText(currentItem1.getDescription());
            imageView_formula.setImageResource(currentItem1.getFormula());
            text_tag.setText(currentItem1.getTag());

        }
    }

    public void filterFormulasList(ArrayList<formulasItem> filteredList) {
        mTitleTheme = filteredList;
        notifyDataSetChanged();
    }

}

