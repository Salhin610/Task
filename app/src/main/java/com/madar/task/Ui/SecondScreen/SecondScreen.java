package com.madar.task.Ui.SecondScreen;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madar.task.Models.UserModel;
import com.madar.task.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SecondScreen extends AppCompatActivity {

    @BindView(R.id.UsersList)
    RecyclerView UsersList;
    @BindView(R.id.NoUsers)
    TextView NoUsers;
    private SecondScreenViewModel secondScreenViewModel;
    UsersAdapter adapter = new UsersAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        ButterKnife.bind(this);
        secondScreenViewModel = ViewModelProviders.of(this).get(SecondScreenViewModel.class);
        getSupportActionBar().setTitle("Exsisting users");

        UsersList.setLayoutManager(new LinearLayoutManager(this));
        UsersList.setAdapter(adapter);

        secondScreenViewModel.RetrieveData(this);


        secondScreenViewModel.Users.observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> Users) {

                if (Users.size()==0)
                    NoUsers.setVisibility(View.VISIBLE);
                adapter.Users(Users);
                adapter.notifyDataSetChanged();

            }
        });


    }
}