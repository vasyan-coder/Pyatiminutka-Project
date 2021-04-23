package com.example.pyatiminutka.ui.theory;

import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pyatiminutka.Models.Adapters.BooksAdapter;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.Models.items.BookItem;
import com.example.pyatiminutka.Models.pagetabsother.SectionsPagerTheoryAdapter;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.ui.book.Activity_book_term;
import com.example.pyatiminutka.ui.book.BookViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TheoryFragment extends Fragment {


    private BookViewModel bookViewModel;
    private ArrayAdapter adapter;
    private String numbook;

    private BooksAdapter booksAdapter;

    private TabLayout tabs_theory;
    private ViewPager viewPager_theory;

    //    private int[] mBooks = {R.string.text_thermodynamics, R.string.text_mechanics, R.string.text_electricity};
    private ArrayList<BookItem> mBooks;

    private RecyclerView list_book;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_theory, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar2);
        toolbar.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R.animator.elevation_off));
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));


        AppBarLayout appBarLayout = root.findViewById(R.id.appBarLayout);
        appBarLayout.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R.animator.elevation));

        tabs_theory = root.findViewById(R.id.tabs_theory);
        viewPager_theory = root.findViewById(R.id.viewPager_theory);
        SectionsPagerTheoryAdapter SectionsPagerTheoryAdapter = new SectionsPagerTheoryAdapter(getContext(),
                getChildFragmentManager());
        viewPager_theory.setAdapter(SectionsPagerTheoryAdapter);
        tabs_theory.setupWithViewPager(viewPager_theory);

        return root;
    }

}