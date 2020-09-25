package com.madar.task.Ui.SecondScreen;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.madar.task.Models.UserModel;
import com.madar.task.R;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.User> {


    List<UserModel> UsersData = new ArrayList<>();

    public void Users(List<UserModel> Users) {
    UsersData = Users;
    }

    @NonNull
    @Override
    public UsersAdapter.User onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_user, parent, false);
        User holder = new User(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.User holder, int position) {

        holder.Gender.setText(UsersData.get(position).getGender());
        holder.JobTitle.setText(UsersData.get(position).getJobTitle());
        holder.Age.setText(UsersData.get(position).getAge());
        holder.UserName.setText(UsersData.get(position).getUserName());

    }

    @Override
    public int getItemCount() {

        return UsersData.size();
    }
    public class User extends RecyclerView.ViewHolder{

        TextView UserName , Age , JobTitle , Gender;


        public User(View itemView) {
            super(itemView);
            UserName = itemView.findViewById(R.id.UserName);
            Age = itemView.findViewById(R.id.Age);
            JobTitle = itemView.findViewById(R.id.JobTitle);
            Gender = itemView.findViewById(R.id.Gender);

        }

    }
}
