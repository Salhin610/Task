package com.madar.task.Ui.FirstScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.madar.task.DB.UsersDataBase;
import com.madar.task.Models.UserModel;
import com.madar.task.R;
import com.madar.task.Ui.SecondScreen.SecondScreen;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FirstScreen extends AppCompatActivity {

    @BindView(R.id.UserName)
    EditText UserNameVal;
    @BindView(R.id.Age)
    EditText AgeVal;
    @BindView(R.id.JobTitle)
    EditText JobTitleVal;
    @BindView(R.id.Gender)
    NiceSpinner GenderVal;
    @BindView(R.id.Save)
    Button Save;
    @BindView(R.id.ExsitingUsers)
    Button ExsitingUsers;

    List<String> GenderList = new ArrayList<>();

    private FirstScreenViewModel firstScreenViewModel;

    UsersDataBase usersDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstScreenViewModel = ViewModelProviders.of(this).get(FirstScreenViewModel.class);

        ButterKnife.bind(this);
            GenderList = new LinkedList<>(Arrays.asList("Male", "Female"));

            getSupportActionBar().setTitle("Add User");
        GenderVal.attachDataSource(GenderList);
         usersDataBase = UsersDataBase.getInstance(this);


        firstScreenViewModel.UserNameError.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (getApplicationContext() != null)
                    Toast.makeText(getApplicationContext(), R.string.UserNameError, Toast.LENGTH_LONG).show();



            }
        });
        firstScreenViewModel.AgeError.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (getApplicationContext() != null)
                    Toast.makeText(getApplicationContext(), R.string.AgeError, Toast.LENGTH_LONG).show();



            }
        });
        firstScreenViewModel.JobTitleError.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (getApplicationContext() != null)
                    Toast.makeText(getApplicationContext(), R.string.JobTitle, Toast.LENGTH_LONG).show();



            }
        });


    }

    @OnClick({R.id.Save, R.id.ExsitingUsers})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Save:

                 String UserName,Age,JobTitle,Gender;

                 UserName = UserNameVal.getText().toString() ;
                 Age = AgeVal.getText().toString();
                 JobTitle = JobTitleVal.getText().toString() ;
                 Gender = GenderList.get(GenderVal.getSelectedIndex());

                 if (firstScreenViewModel.Check(UserName,Age,JobTitle))
                     firstScreenViewModel.InsertData(this,UserName,Age,JobTitle,Gender);

                break;
            case R.id.ExsitingUsers:
                Intent i = new Intent(this, SecondScreen.class);
                startActivity(i);
                break;
        }
    }

}