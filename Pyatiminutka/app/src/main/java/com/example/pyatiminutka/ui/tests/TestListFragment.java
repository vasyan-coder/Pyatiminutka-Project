package com.example.pyatiminutka.ui.tests;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;

public class TestListFragment extends Fragment implements View.OnClickListener{

    private RelativeLayout rel_thermodynamics;
    private RelativeLayout rel_mechanics;

    private ImageView favourite_test1;

    private int choose;

    
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test_list, container, false);

        findById(root);


        //Фон кнопок теста
        rel_thermodynamics.getBackground().setColorFilter(getContext().getResources()
                .getColor(R.color.btn_red), PorterDuff.Mode.SRC_ATOP);
        rel_mechanics.getBackground().setColorFilter(getContext().getResources()
                .getColor(R.color.btn_yellow), PorterDuff.Mode.SRC_ATOP);


        favourite_test1.setOnClickListener(this);
        rel_thermodynamics.setOnClickListener(this);

        return root;
    }
    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.rel_thermodynamics) {
            Intent intent = new Intent(getActivity(), Activity_term_test.class);
            AppConstants.map_test_number.put("test_num", 0);
            startActivity(intent);
        } else if (id == R.id.favourite_test1) {
            Resources res = getResources();
            if (choose == 0) {
                choose = 1;
                favourite_test1.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_star_24));
            }
            else {
                choose = 0;
                favourite_test1.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_star_border_24));
            }
        }
    }


    private void findById(View v){
        rel_thermodynamics = v.findViewById(R.id.rel_thermodynamics);
        favourite_test1 = v.findViewById(R.id.favourite_test1);
        rel_mechanics = v.findViewById(R.id.mehanika);
    }

}