package com.madar.task.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.madar.task.Models.UserModel;
import com.madar.task.Ui.UsersDao;

@Database(entities = UserModel.class,version = 1)
abstract public class UsersDataBase extends RoomDatabase {

    private static UsersDataBase instance;
    public abstract UsersDao UsersDao();

    public static synchronized UsersDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),UsersDataBase.class,"users_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
