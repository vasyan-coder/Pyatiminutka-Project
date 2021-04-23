package com.example.pyatiminutka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.bumptech.glide.Glide;
import com.example.pyatiminutka.Models.Adapters.FormulasMainAdapter;
import com.example.pyatiminutka.Models.Adapters.TopListAdapter;
import com.example.pyatiminutka.Models.items.UserItem;
import com.example.pyatiminutka.ui.result.Activity_result_term;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TopRateActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    //private FirebaseUser firebaseUser;

    private DatabaseReference databaseReference;

    private List<UserItem> userList = new ArrayList<>();

    private TopListAdapter adapter;

    private RecyclerView recyclerView;

    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rate);

        Intent intent1 = getIntent();

        String category = intent1.getStringExtra("num_them");

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            //id = firebaseUser.getUid();
            databaseReference = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/")
                    .getReference(category);
            Glide.with(TopRateActivity.this);
        }

//        getDataFromDB();

        recyclerView = findViewById(R.id.top_list);



        adapter = new TopListAdapter(userList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        Query query = FirebaseDatabase.getInstance("https://pyatiminutka-34b3c-default-rtdb.firebaseio.com/").getReference(category)
                .orderByChild("points")
                .limitToFirst(1000);
        query.addListenerForSingleValueEvent(valueEventListener);
//        databaseReference.addValueEventListener(valueEventListener);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    UserItem user = dataSnapshot1.getValue(UserItem.class);
                    userList.add(user);
                }
                adapter.notifyDataSetChanged();


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

}