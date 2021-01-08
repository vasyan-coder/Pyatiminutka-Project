package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.items.BookItem;
import com.example.pyatiminutka.R;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private int numberItems;

    private OnNoteListener mOnNoteListener;

    private ArrayList<BookItem> mBooks;


    public BooksAdapter(OnNoteListener onNoteListener, ArrayList<BookItem> books) {
        this.mOnNoteListener = onNoteListener;
        this.mBooks = books;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.row_book_list;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new BooksViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView bookTitle;

        OnNoteListener onNoteListener;

        public BooksViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            bookTitle = itemView.findViewById(R.id.text_view31);

            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        public void bind(int listIndex) {
            BookItem currentItem = mBooks.get(listIndex);
            bookTitle.setText(currentItem.getBooks());
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

    public void filterList(ArrayList<BookItem> filteredList) {
        mBooks = filteredList;
        notifyDataSetChanged();
    }
}
