package com.example.pyatiminutka.ui.tests;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.Adapters.TestsAdapter;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;

public class TestListFragment extends Fragment{

    private RecyclerView recyclerView;
    
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test_list, container, false);

        findById(root);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        TestsAdapter testsAdapter = new TestsAdapter(QuestionTest.Question_title, getActivity());
        recyclerView.setAdapter(testsAdapter);

        return root;
    }


    private void findById(View v){
        recyclerView = v.findViewById(R.id.recyclerView_test);
    }

}