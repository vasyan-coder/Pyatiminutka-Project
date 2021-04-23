package com.example.pyatiminutka.ui.profile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IntegerRes;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.pyatiminutka.ActivityAchievements;
import com.example.pyatiminutka.ActivityChooseRaiting;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.R;
import com.example.pyatiminutka.SignInActivity;
import com.example.pyatiminutka.TopRateActivity;
import com.example.pyatiminutka.ui.result.Activity_result_term;
import com.example.pyatiminutka.ui.tests.Activity_quiz_term;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    private CardView btn_achievements, btn_top;
    private LinearLayout image_add_btn;

    private CircularProgressBar circularProgressBar;
    private TextView text_percent_achievements;

    private TextView text_your_name;
    private ImageView image_profile;

    private CardView button_logout;

    FirebaseAuth firebaseAuth;

    GoogleSignInClient googleSignInClient;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar2);
        toolbar.setElevation(0);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccentSecondary));

        btn_achievements = root.findViewById(R.id.btn_achievements);
        btn_top = root.findViewById(R.id.btn_top);
//        image_add_btn = root.findViewById(R.id.image_add_btn);

//        image_add_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder a_builder1 = new AlertDialog.Builder(getContext());
//                a_builder1.setMessage("Функция в разработке")
//                        .setCancelable(true)
//                        .setPositiveButton("Закрыть", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.cancel();
//                            }
//                        });
//                AlertDialog alert = a_builder1.create();
//                alert.show();
//            }
//        });
        btn_achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityAchievements.class);
                startActivity(intent);
            }
        });
        btn_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ActivityChooseRaiting.class);
                startActivity(intent);
            }
        });


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        button_logout = root.findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), SignInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

//        TextView test1 = root.findViewById(R.id.test);
//        test1.setText(getText(R.string.sds));
        //Имя в профиле
        text_your_name = root.findViewById(R.id.text_your_name);
//        text_your_name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        //Статистика достижений
        //Shared Pref
        circularProgressBar = root.findViewById(R.id.circularProgressBar);
        text_percent_achievements = root.findViewById(R.id.text_percent_achievements);

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(getContext());

        int achievements_progress = (myPreferences.getInt(AppConstants.KEY_1_ACHIEVEMENT, 0) +
                myPreferences.getInt(AppConstants.KEY_2_ACHIEVEMENT, 0) +
                myPreferences.getInt(AppConstants.KEY_3_ACHIEVEMENT, 0) +
                myPreferences.getInt(AppConstants.KEY_4_ACHIEVEMENT, 0) +
                myPreferences.getInt(AppConstants.KEY_5_ACHIEVEMENT, 0) +
                myPreferences.getInt(AppConstants.KEY_6_ACHIEVEMENT, 0) +
                myPreferences.getInt(AppConstants.KEY_7_ACHIEVEMENT, 0)
        ) * 100 / 601;
        circularProgressBar.setProgress(achievements_progress);
        text_percent_achievements.setText(achievements_progress + "%");


        image_profile = root.findViewById(R.id.image_profile);

//        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            Glide.with(ProfileFragment.this)
                    .load(firebaseUser.getPhotoUrl())
                    .into(image_profile);
            text_your_name.setText(firebaseUser.getDisplayName());
        }

        googleSignInClient = GoogleSignIn.getClient(getContext()
                , GoogleSignInOptions.DEFAULT_SIGN_IN);

        return root;
    }
}