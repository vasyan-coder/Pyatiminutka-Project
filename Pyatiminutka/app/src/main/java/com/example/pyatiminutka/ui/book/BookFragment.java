package com.example.pyatiminutka.ui.book;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pyatiminutka.Models.Adapters.BooksAdapter;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.items.BookItem;
import com.example.pyatiminutka.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class BookFragment extends Fragment {

    private BooksAdapter booksAdapter;

    private ArrayList<BookItem> mBooks;


    private RecyclerView list_book;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book, container, false);

        listAdd();

        list_book = root.findViewById(R.id.list_book);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        list_book.setLayoutManager(layoutManager);

        booksAdapter = new BooksAdapter(mBooks, getContext());
        list_book.setAdapter(booksAdapter);

        EditText editText = (EditText) root.findViewById(R.id.searchFilter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return root;
    }

    private void filter(String text) {
        ArrayList<BookItem> filteredList = new ArrayList<>();


        for (BookItem item : mBooks) {
            if (item.getBooks().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
//            else if (item.getBooks1().toLowerCase().contains(text.toLowerCase())) {
//                filteredList.add(item);
//            }

        }

        booksAdapter.filterList(filteredList);
    }


    private void listAdd() {
        mBooks = new ArrayList<>();
//        mBooks.add(new BookItem(getString(R.string.text_thermodynamics), "ххх"));
//        mBooks.add(new BookItem(getString(R.string.text_mechanics), "ъъъ"));
//        mBooks.add(new BookItem(getString(R.string.text_electricity), "ыыы"));

        mBooks.add(new BookItem(getString(R.string.text_thermodynamics)));
        mBooks.add(new BookItem(getString(R.string.text_mechanics)));
        mBooks.add(new BookItem(getString(R.string.text_electricity)));
        mBooks.add(new BookItem(getString(R.string.text_optics)));
        mBooks.add(new BookItem(getString(R.string.text_quantum_physics)));

    }
}