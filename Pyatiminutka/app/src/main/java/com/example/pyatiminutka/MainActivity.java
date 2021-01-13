package com.example.pyatiminutka;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.pyatiminutka.Models.Func.LoadTheme;
import com.example.pyatiminutka.Models.Func.StatusBarColor;
import com.example.pyatiminutka.Models.constants.AppConstants;
import com.example.pyatiminutka.ui.book.BookListFragment;
import com.example.pyatiminutka.ui.profile.ProfileFragment;
import com.example.pyatiminutka.ui.push.push;
import com.example.pyatiminutka.ui.settings.ActivitySettings;
import com.example.pyatiminutka.ui.tests.TestListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Проверка установленной темы
        LoadTheme.LoadTheme(this);

        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }




    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.navigation_book_list:
                            AppConstants.map_btmNav.put("map_btmNav", 1);
                            selectedFragment = new BookListFragment();
                            break;
                        case R.id.navigation_test_list:
                            AppConstants.map_btmNav.put("map_btmNav", 2);
                            selectedFragment = new TestListFragment();
                            break;
                        case R.id.navigation_profile:
                            AppConstants.map_btmNav.put("map_btmNav", 3);
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.navigation_notifications:
                            selectedFragment = new TestListFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view_tag, selectedFragment).commit();

                    return true;
                }
            };


    public void clickSettings(View view) {
        Intent intent = new Intent(this, ActivitySettings.class);
        startActivity(intent);
    }

    public void clickPush(View view) {
        Intent intent = new Intent(this, push.class);
        startActivity(intent);
    }

//    @Override ТУТ НАСРАЛ ЕГОР!!!!!!!        123
//    public void onBackPressed() {
//        if (AppConstants.map_btmNav.containsKey(true)) {
//            if (AppConstants.map_btmNav.get("map_btmNav") == 1) {
//                EditText editText = findViewById(R.id.searchFilter);
//                editText.getText().clear();
//            } else {
//                finish();
//            }
//        } else {
//            EditText editText = findViewById(R.id.searchFilter);
//            editText.getText().clear();
//            if (editText.getText().toString() == "") {
//                finish();
//            }
//        }
//    }
}