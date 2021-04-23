package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.items.formulasItem;
import com.example.pyatiminutka.R;

import java.util.List;

public class FormulasChildAdapter extends RecyclerView.Adapter<FormulasChildAdapter.FormulasViewHolder> {

    private List<formulasItem> mTitleTheme;

    private List<String> mFormulas;


    public FormulasChildAdapter(List<String> mFormulas) {
        this.mFormulas = mFormulas;
    }

    @NonNull
    @Override
    public FormulasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.formul_child_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);


        return new FormulasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormulasViewHolder holder, int position) {
//        holder.bind(position);
        holder.text_formulas.setText(mFormulas.get(position));

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class FormulasViewHolder extends RecyclerView.ViewHolder {

        TextView text_formulas;

        public FormulasViewHolder(@NonNull View itemView) {
            super(itemView);

            text_formulas = itemView.findViewById(R.id.text_formulas);

        }

        public void bind(int listIndex) {
//            formulasItem currentItem1 = mFormulas.get(listIndex);
//            text_formulas.setText(currentItem1.getText_formulas());

        }

    }

//    public void filterChildFormulasList(ArrayList<formulasItem> filteredList) {
//        mFormulas = filteredList;
//        notifyDataSetChanged();
//    }

}

