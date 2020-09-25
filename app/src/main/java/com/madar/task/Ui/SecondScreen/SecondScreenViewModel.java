package com.madar.task.Ui.SecondScreen;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.madar.task.DB.UsersDataBase;
import com.madar.task.Models.UserModel;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SecondScreenViewModel extends ViewModel {

    MutableLiveData<List<UserModel>> Users=new MutableLiveData<>();

    public void RetrieveData(Context context){
        UsersDataBase usersDataBase;

        usersDataBase = UsersDataBase.getInstance(context);

        usersDataBase.UsersDao().GetUsers()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<UserModel>>() {


                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onSuccess(List<UserModel> userModels) {

                        Users.setValue(userModels);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
