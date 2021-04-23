package com.example.pyatiminutka;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NotificationsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar2);
        toolbar.setElevation(getResources().getDimension(R.dimen.shadow));
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));

        return root;
    }
}