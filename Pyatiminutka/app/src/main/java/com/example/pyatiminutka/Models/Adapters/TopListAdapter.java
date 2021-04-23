package com.example.pyatiminutka.Models.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyatiminutka.Models.items.UserItem;
import com.example.pyatiminutka.Models.items.formulasItem;
import com.example.pyatiminutka.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class TopListAdapter extends RecyclerView.Adapter<TopListAdapter.TopListViewHolder> {


    private FirebaseAuth firebaseAuth;
    private FirebaseUser FirebaseUser;

    private DatabaseReference databaseReference;
    private String USER_KEY = "User";

    private List<UserItem> list;

    public TopListAdapter(List<UserItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TopListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.item_top_list;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);



        return new TopListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopListViewHolder holder, int position) {
        //holder.bind(position);
        UserItem currentItem1 = list.get(position);
        holder.top_name.setText(currentItem1.getName());
        holder.top_score.setText(String.valueOf(currentItem1.getPoints()));
        String s = String.valueOf(list.size()-position);
        holder.top_place.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopListViewHolder extends RecyclerView.ViewHolder{

        TextView top_place;
        TextView top_name;
        TextView top_score;

        public TopListViewHolder(@NonNull View itemView) {
            super(itemView);

            top_place = itemView.findViewById(R.id.top_place);
            top_name = itemView.findViewById(R.id.top_name);
            top_score = itemView.findViewById(R.id.top_score);

        }

        void bind(int listIndex) {
//            String id = databaseReference.getKey();
//            databaseReference = FirebaseDatabase.getInstance().getReference(USER_KEY);


            //UserItem userItem = new UserItem()
        }
    }



}
