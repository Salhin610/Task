package com.madar.task.Ui.FirstScreen;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.madar.task.DB.UsersDataBase;
import com.madar.task.Models.UserModel;
import com.madar.task.R;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FirstScreenViewModel extends ViewModel {
    MutableLiveData<Boolean> UserNameError=new MutableLiveData<>();
    MutableLiveData<Boolean> AgeError=new MutableLiveData<>();
    MutableLiveData<Boolean> JobTitleError=new MutableLiveData<>();


    public Boolean Check(String UserName, String Age , String JobTitle){

        if (UserName.equals("")) {

            UserNameError.setValue(true);
            return false;
        }

        if (Age.equals("")) {

            UserNameError.setValue(true);
            return false;
        }

        if (JobTitle.equals("")) {

            JobTitleError.setValue(true);
            return false;
        }

        return true;
    }

    public void InsertData(Context context , String UserName, String Age, String JobTitle, String Gender){

        UsersDataBase   usersDataBase = UsersDataBase.getInstance(context);

        usersDataBase.UsersDao().InsetUser(new UserModel(UserName,Age
                ,JobTitle,Gender)).subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

}
