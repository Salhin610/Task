package com.madar.task.Ui;


import android.database.Observable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.madar.task.Models.UserModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface UsersDao {


    @Insert
    Completable InsetUser(UserModel User);

    @Query("SELECT * FROM users_table")
    Maybe<List<UserModel>> GetUsers();
}
