package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.items.BookItem;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.book.Activity_book_term;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private int numberItems;

//    private OnNoteListener mOnNoteListener;

    private ArrayList<BookItem> mBooks;

    private Context context;

    public BooksAdapter(ArrayList<BookItem> books, Context context) {
//        this.mOnNoteListener = onNoteListener;
        this.mBooks = books;
        this.context = context;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.row_book_list;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        BookItem item = mBooks.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder {

        TextView bookTitle;

        //        OnNoteListener onNoteListener;
        private BookItem currentItem;

        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            bookTitle = itemView.findViewById(R.id.text_view31);

//            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentItem.getBooks().equals(context.getResources().getString(R.string.text_thermodynamics))) {
                        AppConstants.map_book_number.put(AppConstants.KEY_MAP_BOOK_NUMBER, 0);
                        Intent intent = new Intent(context, Activity_book_term.class);
                        context.startActivity(intent);
                    } else if (currentItem.getBooks().equals(context.getResources().getString(R.string.text_mechanics))) {
                        AppConstants.map_book_number.put(AppConstants.KEY_MAP_BOOK_NUMBER, 1);
                        Intent intent = new Intent(context, Activity_book_term.class);
                        context.startActivity(intent);
                    } else if (currentItem.getBooks().equals(context.getResources().getString(R.string.text_electricity))) {
                        AppConstants.map_book_number.put(AppConstants.KEY_MAP_BOOK_NUMBER, 2);
                        Intent intent = new Intent(context, Activity_book_term.class);
                        context.startActivity(intent);
                    } else if (currentItem.getBooks().equals(context.getResources().getString(R.string.text_optics))) {
                        AppConstants.map_book_number.put(AppConstants.KEY_MAP_BOOK_NUMBER, 3);
                        Intent intent = new Intent(context, Activity_book_term.class);
                        context.startActivity(intent);
                    } else if (currentItem.getBooks().equals(context.getResources().getString(R.string.text_quantum_physics))) {
                        AppConstants.map_book_number.put(AppConstants.KEY_MAP_BOOK_NUMBER, 4);
                        Intent intent = new Intent(context, Activity_book_term.class);
                        context.startActivity(intent);
                    }
                }
            });
        }

        public void bind(BookItem listIndex) {
            bookTitle.setText(listIndex.getBooks());
            currentItem = listIndex;
        }

    }

    public void filterList(ArrayList<BookItem> filteredList) {
        mBooks = filteredList;
        notifyDataSetChanged();
    }
}
