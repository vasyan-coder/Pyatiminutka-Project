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

    private RelativeLayout rel_termodinamika;
    private RelativeLayout mehanika;

    private ImageView favourite_test1;

    private int choose;

    
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test_list, container, false);

        findById(root);


        //Фон кнопок теста
        rel_termodinamika.getBackground().setColorFilter(getContext().getResources().getColor(R.color.btn_red), PorterDuff.Mode.SRC_ATOP);
        mehanika.getBackground().setColorFilter(getContext().getResources().getColor(R.color.btn_yellow), PorterDuff.Mode.SRC_ATOP);


        favourite_test1.setOnClickListener(this);
        rel_termodinamika.setOnClickListener(this);

        return root;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rel_termodinamika:
                Intent intent = new Intent(getActivity(), Activity_term_test.class);
                AppConstants.map_test_number.put("test_num", 0);
                startActivity(intent);
                break;
            case R.id.favourite_test1:
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
        rel_termodinamika = v.findViewById(R.id.rel_termodinamika);
        favourite_test1 = v.findViewById(R.id.favourite_test1);
        mehanika = v.findViewById(R.id.mehanika);
    }

}